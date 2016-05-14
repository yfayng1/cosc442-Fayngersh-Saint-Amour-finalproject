/**
 *  Copyright (C) 2002-2016   The FreeCol Team
 *
 *  This file is part of FreeCol.
 *
 *  FreeCol is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  FreeCol is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FreeCol.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.freecol.common.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import net.sf.freecol.common.i18n.Messages;
import net.sf.freecol.common.io.FreeColXMLReader;
import net.sf.freecol.common.io.FreeColXMLWriter;
import static net.sf.freecol.common.util.CollectionUtils.*;
import static net.sf.freecol.common.util.StringUtils.*;


/**
 * A named region on the map.
 */
public class Region extends FreeColGameObject implements Nameable {

    // Serialization

    private static final String CHILD_TAG = "child";
    private static final String CLAIMABLE_TAG = "claimable";
    private static final String DISCOVERABLE_TAG = "discoverable";
    private static final String DISCOVERED_BY_TAG = "discoveredBy";
    private static final String DISCOVERED_IN_TAG = "discoveredIn";
    private static final String KEY_TAG = "key";
    private static final String NAME_TAG = "name";
    private static final String PARENT_TAG = "parent";
    private static final String SCORE_VALUE_TAG = "scoreValue";
    private static final String TYPE_TAG = "type";
    // @compat 0.11.3
    private static final String NAME_KEY_TAG = "nameKey";
    // end @compat 0.11.3
    
    /** The keys for the valid predefined regions. */
    public static final List<String> PREREGKEYS
        = makeUnmodifiableList("model.region.arctic", "model.region.antarctic",
            "model.region.northWest", "model.region.north", "model.region.northEast",
            "model.region.west", "model.region.center", "model.region.east",
            "model.region.southWest", "model.region.south", "model.region.southEast",
            "model.region.atlantic", "model.region.northAtlantic", "model.region.southAtlantic",
            "model.region.pacific", "model.region.northPacific", "model.region.southPacific");

    /** Hardwired name key for the Pacific for the benefit of isPacific(). */
    public static final String PACIFIC_KEY = "model.region.pacific";

    /** The type of region. */
    public static enum RegionType implements Named {
        OCEAN(false),
        COAST(false),
        LAKE(false),
        RIVER(true),
        LAND(true),
        MOUNTAIN(true),
        DESERT(true);

        /** Are regions of this type claimable by default? */
        private final boolean claimable;


        /**
         * Create a region type.
         *
         * @param claimable The default claimability of this region type.
         */
        RegionType(final boolean claimable) {
            this.claimable = claimable;
        }
        

        /** Is this region claimable by default?
         *
         * @return True if this region type is normally claimable.
         */
        public boolean isClaimable() {
            return this.claimable;
        }

        /**
         * Get a stem key for this region type.
         *
         * @return A stem key.
         */
        public String getKey() {
            return "regionType." + getEnumKey(this);
        }

        /**
         * Gets a message key for an unknown region of this type.
         *
         * @return A message key.
         */
        public String getUnknownKey() {
            return "model." + getKey() + ".unknown";
        }

        // Interface Named

        /**
         * {@inheritDoc}
         */
        @Override
        public String getNameKey() {
            return Messages.nameKey("model." + getKey());
        }
    }

    /** The name of this region, given by a player. */
    protected String name;

    /** The key for this region if it is a predefined one. */
    protected String key;

    /** The type of region. */
    protected RegionType type;

    /** The parent region of this region. */
    protected Region parent;

    /** The child regions of this region. */
    protected List<Region> children = null;

    /**
     * Whether this region is claimable.
     * Ocean regions and non-leaf regions are not claimable.
     */
    protected boolean claimable = false;

    /**
     * Whether this region is discoverable.  The Eastern Ocean regions
     * should not be discoverable.  In general, non-leaf regions should
     * not be discoverable.  The Pacific Ocean is an exception however,
     * unless players start there.
     */
    protected boolean discoverable = false;

    /** Which Turn the region was discovered in. */
    protected Turn discoveredIn;

    /** Which Player the Region was discovered by. */
    protected Player discoveredBy;

    /**
     * Identifier for the unit the region was discovered by.   Using
     * an identifier as units may subsequently die.
     */
    private String discoverer = null;

    /**
     * How much discovering this region contributes to your score.
     * This should be zero unless the region is discoverable.
     */
    protected int scoreValue = 0;


    /**
     * Creates a new <code>Region</code> instance.
     *
     * @param game The enclosing <code>Game</code>.
     */
    public Region(final Game game) {
        super(game);
    }

    /**
     * Creates a new <code>Region</code> instance.
     *
     * @param game The enclosing <code>Game</code>.
     * @param identifier The object identifier.
     */
    public Region(final Game game, final String identifier) {
        super(game, identifier);
    }


    /**
     * Get the key for this region.
     *
     * @return The region key, which will be null for non-fixed regions.
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Does this region have a name?
     *
     * @return True if the region has been named or was predefined.
     */
    public boolean hasName() {
        return this.name != null || this.key != null;
    }

    /**
     * Is this region the Pacific Ocean?
     *
     * The Pacific Ocean is special in that it is the only Region that
     * could be discovered in the original game.
     *
     * @return True if this region is the Pacific.
     */
    public boolean isPacific() {
        return PACIFIC_KEY.equals(this.key)
            || (this.parent != null && this.parent.isPacific());
    }

    /**
     * Gets the name or default name of this Region.
     *
     * @return The i18n-ready name for the region.
     */
    public StringTemplate getLabel() {
        return (this.key != null)
            ? StringTemplate.key(Messages.nameKey(this.key))
            : (this.name != null)
            ? StringTemplate.name(this.name)
            : StringTemplate.key(type.getUnknownKey());
    }

    /**
     * Gets the type of the region.
     *
     * @return The region type.
     */
    public final RegionType getType() {
        return this.type;
    }

    /**
     * Gets the enclosing parent region.
     *
     * @return The parent region
     */
    public final Region getParent() {
        return this.parent;
    }

    /**
     * Sets the parent region.
     *
     * @param newParent The new parent region.
     */
    public final void setParent(final Region newParent) {
        this.parent = newParent;
    }

    /**
     * Get a list of the child regions.
     *
     * @return The child regions.
     */
    public final List<Region> getChildren() {
        return (this.children == null) ? Collections.<Region>emptyList()
            : this.children;
    }

    /**
     * Sets the child regions.
     *
     * @param newChildren The new child regions.
     */
    public final void setChildren(final List<Region> newChildren) {
        this.children = newChildren;
    }

    /**
     * Add a child region to this region.
     *
     * @param child The child <code>Region</code> to add.
     */
    public void addChild(final Region child) {
        if (this.children == null) {
        	this.children = new ArrayList<>();
        }
        this.children.add(child);
    }

    /**
     * Is this a leaf region?
     *
     * @return True if the region has no children.
     */
    public boolean isLeaf() {
        return this.children == null || this.children.isEmpty();
    }

    /**
     * Can this region be claimed?
     *
     * @return True if the region can be claimed.
     */
    public final boolean isClaimable() {
        return this.claimable;
    }

    /**
     * Set the claimability of this region.
     *
     * @param newClaimable True if the region can be claimed.
     */
    public final void setClaimable(final boolean newClaimable) {
        this.claimable = newClaimable;
    }

    /**
     * Can this region be discovered?
     *
     * @return True if the region can be discovered.
     */
    public final boolean isDiscoverable() {
        return this.discoverable;
    }

    /**
     * Set the discoverability of this region.
     *
     * @param newDiscoverable True if the region can be discovered.
     */
    public final void setDiscoverable(final boolean newDiscoverable) {
        this.discoverable = newDiscoverable;
    }

    /**
     * Get the identifier for the unit that discovered the region.
     *
     * @return The unit identifier, or null if none yet.
     */
    public synchronized String getDiscoverer() {
        return this.discoverer;
    }

    /**
     * Set the identifier for the unit the discovered the region.
     *
     * @param discoverer The unit identifier to set.
     */
    public synchronized void setDiscoverer(final String discoverer) {
        this.discoverer = discoverer;
    }

    /**
     * Gets a discoverable Region or null.  If this region is
     * discoverable, it is returned.  If not, a discoverable parent is
     * returned, unless there is none.  This is intended for
     * discovering the Pacific Ocean when discovering one of its
     * sub-Regions.
     *
     * @return A discoverable a region, or null if none found.
     */
    public Region getDiscoverableRegion() {
        return (isDiscoverable()) ? this
            : (getParent() != null) ? getParent().getDiscoverableRegion()
            : null;
    }

    /**
     * Gets the turn the region was discovered in.
     *
     * @return The discovery turn.
     */
    public final Turn getDiscoveredIn() {
        return this.discoveredIn;
    }

    /**
     * Sets the discovery turn.
     *
     * @param newDiscoveredIn The new discoveredy turn.
     */
    public final void setDiscoveredIn(final Turn newDiscoveredIn) {
        this.discoveredIn = newDiscoveredIn;
    }

    /**
     * Gets the player that discovered the region.
     *
     * @return The discovering <code>Player</code>.
     */
    public final Player getDiscoveredBy() {
        return this.discoveredBy;
    }

    /**
     * Sets the discovering player.
     *
     * @param newDiscoveredBy The new discovering player.
     */
    public final void setDiscoveredBy(final Player newDiscoveredBy) {
        this.discoveredBy = newDiscoveredBy;
    }

    /**
     * Gets the score for discovering this region.
     *
     * @return The score.
     */
    public final int getScoreValue() {
        return this.scoreValue;
    }

    /**
     * Sets the score for discovering this region.
     *
     * @param newScoreValue The new score.
     */
    public final void setScoreValue(final int newScoreValue) {
        this.scoreValue = newScoreValue;
    }

    /**
     * Discover this region (and its children).
     *
     * @param player The discovering <code>Player</code>.
     * @param turn The <code>Turn</code> of discovery.
     * @return A list of discovered <code>Region</code>s.
     */
    public List<Region> discover(final Player player, final Turn turn) {
        final List<Region> result = new ArrayList<>();
        this.discoveredBy = player;
        this.discoveredIn = turn;
        this.discoverable = false;
        result.add(this);
        for (final Region r : getChildren()) {
            if (!r.isDiscoverable()) {
            	continue;
            }
            r.discoveredBy = player;
            r.discoveredIn = turn;
            r.discoverable = false;
            result.add(r);
        }
        return result;
    }

    // @compat 0.11.3
    /**
     * Is a key one of the dodgy keys that were generated up to 0.11.3?
     *
     * @param key The key to check.
     * @return A valid key or null if already null or invalid.
     */
    private String fixRegionKey(final String key) {
        if (key == null) {
        	return key;
        }
        for (final String r : PREREGKEYS) {
            if (key.equals(r)) {
                return r;
            } else if (key.equals(Messages.nameKey(r))) {
                return lastPart(key, ".");
            }            
        }
        return null;
    }
    // end @compat 0.11.3


    // Implement Nameable

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeAttributes(final FreeColXMLWriter xWriter) throws XMLStreamException {
        super.writeAttributes(xWriter);

        if (name != null) {
            xWriter.writeAttribute(NAME_TAG, name);
        }

        if (key != null) {
            xWriter.writeAttribute(KEY_TAG, key);
        }

        xWriter.writeAttribute(TYPE_TAG, type);

        xWriter.writeAttribute(CLAIMABLE_TAG, claimable);

        xWriter.writeAttribute(DISCOVERABLE_TAG, discoverable);

        if (parent != null) {
            xWriter.writeAttribute(PARENT_TAG, parent);
        }

        if (discoveredIn != null) {
            xWriter.writeAttribute(DISCOVERED_IN_TAG, discoveredIn.getNumber());
        }

        if (discoveredBy != null) {
            xWriter.writeAttribute(DISCOVERED_BY_TAG, discoveredBy);
        }

        if (scoreValue > 0) {
            xWriter.writeAttribute(SCORE_VALUE_TAG, scoreValue);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeChildren(final FreeColXMLWriter xWriter) throws XMLStreamException {
        super.writeChildren(xWriter);

        for (final Region child : getChildren()) {

            xWriter.writeStartElement(CHILD_TAG);

            xWriter.writeAttribute(ID_ATTRIBUTE_TAG, child);

            xWriter.writeEndElement();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readAttributes(final FreeColXMLReader xReader) throws XMLStreamException {
        super.readAttributes(xReader);

        name = xReader.getAttribute(NAME_TAG, (String)null);

        // @compat 0.11.3
        if (xReader.hasAttribute(NAME_KEY_TAG)) {
            key = xReader.getAttribute(NAME_KEY_TAG, (String)null);
            key = fixRegionKey(key);
        } else {
        // @end compat 0.11.3
            key = xReader.getAttribute(KEY_TAG, (String)null);
        }
        type = xReader.getAttribute(TYPE_TAG, RegionType.class, (RegionType)null);

        claimable = xReader.getAttribute(CLAIMABLE_TAG, false);

        discoverable = xReader.getAttribute(DISCOVERABLE_TAG, false);

        scoreValue = xReader.getAttribute(SCORE_VALUE_TAG, 0);

        final int turn = xReader.getAttribute(DISCOVERED_IN_TAG, UNDEFINED);
        discoveredIn = (turn == UNDEFINED) ? null : new Turn(turn);

        discoveredBy = xReader.findFreeColGameObject(getGame(), DISCOVERED_BY_TAG,
            Player.class, (Player)null, false);

        parent = xReader.makeFreeColGameObject(getGame(), PARENT_TAG,
                                          Region.class, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readChildren(final FreeColXMLReader xReader) throws XMLStreamException {
        // Clear containers.
        children = null;

        super.readChildren(xReader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readChild(final FreeColXMLReader xReader) throws XMLStreamException {
        final String tag = xReader.getLocalName();

        if (CHILD_TAG.equals(tag)) {
            addChild(xReader.makeFreeColGameObject(getGame(), ID_ATTRIBUTE_TAG,
                                              Region.class, true));
            xReader.closeTag(CHILD_TAG);
        
        } else {
            super.readChild(xReader);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sBuilder = new StringBuilder(32);
        sBuilder.append("[").append(getId())
            .append(" ").append((key != null) ? key : (name != null) ? name
                : "<unnamed>")
            .append(" ").append(type);
        if (isDiscoverable()) {
        	sBuilder.append("!");
        }
        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTagName() { return getTagName(); }

    /**
     * Gets the tag name of the root element representing this object.
     *
     * @return "region".
     */
    public static String getTagName() {
        return "region";
    }
}
