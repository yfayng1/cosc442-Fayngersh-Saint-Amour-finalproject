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
import java.util.List;

import javax.xml.stream.XMLStreamException;

import net.sf.freecol.common.io.FreeColXMLReader;
import net.sf.freecol.common.io.FreeColXMLWriter;
import static net.sf.freecol.common.util.CollectionUtils.*;


/**
 * The various types of settlements in the game.
 */
public class SettlementType extends FreeColSpecObjectType {

	// Serialization

    private static final String CAPITAL_TAG = "capital";
    private static final String CRAD_TAG = "claimable-radius";
    private static final String CT_TAG = "convert-threshold";
    private static final String EX_CRAD_TAG = "extra-claimable-radius";
    private static final String GIFTS_TAG = "gifts";
    private static final String MAX_GRO_TAG = "maximum-growth";
    private static final String MAX_SIZE_TAG = "maximum-size";
    private static final String MIN_GRO_TAG = "minimum-growth";
    private static final String MIN_SIZE_TAG = "minimum-size";
    private static final String PLUNDER_TAG = "plunder";
    private static final String TB_TAG = "trade-bonus";
    private static final String VIS_RAD_TAG = "visible-radius";
    private static final String WRAD_TAG = "wandering-radius";
    // @compat 0.11.3
    private static final String OLD_CRAD_TAG = "claimableRadius";
    private static final String OLD_CT_TAG = "convertThreshold";
    private static final String OLD_EX_CRAD_TAG = "extraClaimableRadius";
    private static final String OLD_MAX_GRO_TAG = "maximumGrowth";
    private static final String OLD_MAX_SIZE_TAG = "maximumSize";
    private static final String OLD_MIN_GRO_TAG = "minimumGrowth";
    private static final String OLD_MIN_SIZE_TAG = "minimumSize";
    private static final String OLD_TB_TAG = "tradeBonus";
    private static final String OLD_VIS_RAD_TAG = "visibleRadius";
    private static final String OLD_WRAD_TAG = "wanderingRadius";
    // end @compat 0.11.3
	
    /** Whether this SettlementType is a capital. */
    private boolean capital = false;

    /** How many tiles this SettlementType can see. */
    private int visibleRadius = 2;

    /** How many tiles this SettlementType can claim. */
    private int claimableRadius = 1;

    /**
     * The extra radius beyond the claimableRadius where wandering
     * units may claim as yet unclaimed tiles.
     */
    private int exCrad = 2;

    /** How far units from this SettlementType may roam. */
    private int wanderingRadius = 4;

    /** The minimum number of units for this SettlementType. */
    private int minimumSize = 3;

    /** The maximum number of units for this SettlementType. */
    private int maximumSize = 10;

    /** The minimum number of tiles to grow this SettlementType. */
    private int minimumGrowth = 1;

    /** The maximum number of tiles to grown this SettlementType. */
    private int maximumGrowth = 10;

    /**
     * The general trade bonus, roughly proportional to the settlement
     * size and general sophistication.
     */
    private int tradeBonus = 1;

    /** The threshold at which a new convert occurs. */
    private int convertThreshold = 100;

    /** The plunder this SettlementType generates when destroyed. */
    private List<RandomRange> plunder = null;

    /** The gifts this SettlementType generates when visited by a scout. */
    private List<RandomRange> gifts = null;


    /**
     * Creates a new settlement type.
     *
     * @param identifier The object identifier.
     * @param specification The <code>Specification</code> to refer to.
     */
    public SettlementType(final String identifier, final Specification specification) {
        super(identifier, specification);
    }

    /**
     * Creates a new settlement type.
     *
     * @param xReader The <code>FreeColXMLReader</code> to read from.
     * @param specification The <code>Specification</code> to refer to.
     * @exception XMLStreamException if there is problem reading the stream.
     */
    public SettlementType(final FreeColXMLReader xReader,
                          final Specification specification) throws XMLStreamException {
        super(specification);

        readFromXML(xReader);
    }


    /**
     * Is this a capital settlement type?
     *
     * @return True if this is a capital.
     */
    public final boolean isCapital() {
        return capital;
    }

    /**
     * Get the minimum size of this settlement type.
     *
     * @return The minimum settlement size.
     */
    public final int getMinimumSize() {
        return minimumSize;
    }

    /**
     * Get the maximum size of this settlement type.
     *
     * @return The maximum settlement size.
     */
    public final int getMaximumSize() {
        return maximumSize;
    }

    /**
     * Get the visible radius of this settlement type.
     *
     * @return The visible radius.
     */
    public final int getVisibleRadius() {
        return visibleRadius;
    }

    /**
     * Get the claimable radius of this settlement type.
     *
     * @return The claimable radius.
     */
    public final int getClaimableRadius() {
        return claimableRadius;
    }

    /**
     * Get the extra claimable radius.
     *
     * @return The extra claimable radius.
     */
    public final int getExtraClaimableRadius() {
        return exCrad;
    }

    /**
     * Get the wandering radius for this settlement type.
     *
     * @return The wandering radius.
     */
    public final int getWanderingRadius() {
        return wanderingRadius;
    }

    /**
     * Get the minimum growth value.
     *
     * @return The minimum number of tiles to try to grow this
     *     settlement type by.
     */
    public final int getMinimumGrowth() {
        return minimumGrowth;
    }

    /**
     * Get the maximum growth value.
     *
     * @return The maximum number of tiles to try to grow this
     *     settlement type by.
     */
    public final int getMaximumGrowth() {
        return maximumGrowth;
    }

    /**
     * Gets the trade bonus.
     *
     * @return The general bonus to trade.
     */
    public final int getTradeBonus() {
        return tradeBonus;
    }

    /**
     * Gets the convert threshold for this settlement.
     *
     * @return The convert threshold.
     */
    public int getConvertThreshold() {
        return convertThreshold;
    }

    /**
     * Gets the plunder range available for the supplied unit.
     *
     * @param unit The <code>Unit</code> to check.
     * @return The plunder range, or null if none applicable.
     */
    public final RandomRange getPlunderRange(final Unit unit) {
        return (plunder == null) ? null
            : find(plunder, pRange -> pRange.appliesTo(unit));
    }

    /**
     * Get the range of gifts available to a unit.
     *
     * @param unit The <code>Unit</code> to check.
     * @return A range of gifts, or null if none applicable.
     */
    public final RandomRange getGifts(final Unit unit) {
        return (gifts == null) ? null
            : find(gifts, gift -> gift.appliesTo(unit));
    }


    /**
     * Gets the warehouse capacity of this settlement.
     *
     * @return The warehouse capacity of this settlement.
     */
    public int getWarehouseCapacity() {
        return GoodsContainer.CARGO_SIZE * getClaimableRadius();
    }

    /**
     * Add a gift.
     *
     * @param gift The gift to add.
     */
    private void addGift(final RandomRange gift) {
        if (gifts == null) {
        	gifts = new ArrayList<>();
        }
        gifts.add(gift);
    }

    /**
     * Add a plunder.
     *
     * @param range The plunder to add.
     */
    private void addPlunder(final RandomRange range) {
        if (plunder == null) {
        	plunder = new ArrayList<>();
        }
        plunder.add(range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeAttributes(final FreeColXMLWriter xWriter) throws XMLStreamException {
        super.writeAttributes(xWriter);

        xWriter.writeAttribute(CAPITAL_TAG, capital);

        xWriter.writeAttribute(MIN_SIZE_TAG, minimumSize);

        xWriter.writeAttribute(MAX_SIZE_TAG, maximumSize);

        xWriter.writeAttribute(VIS_RAD_TAG, visibleRadius);

        xWriter.writeAttribute(CRAD_TAG, claimableRadius);

        xWriter.writeAttribute(EX_CRAD_TAG, exCrad);

        xWriter.writeAttribute(WRAD_TAG, wanderingRadius);

        xWriter.writeAttribute(MIN_GRO_TAG, minimumGrowth);

        xWriter.writeAttribute(MAX_GRO_TAG, maximumGrowth);

        xWriter.writeAttribute(TB_TAG, tradeBonus);

        xWriter.writeAttribute(CT_TAG, convertThreshold);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeChildren(final FreeColXMLWriter xWriter) throws XMLStreamException {
        super.writeChildren(xWriter);

        if (plunder != null) {
            for (final RandomRange range : plunder) {
            	range.toXML(xWriter, PLUNDER_TAG);
            }
        }

        if (gifts != null) {
            for (final RandomRange range : gifts) {
            	range.toXML(xWriter, GIFTS_TAG);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void readAttributes(final FreeColXMLReader xReader) throws XMLStreamException {
        super.readAttributes(xReader);

        capital = xReader.getAttribute(CAPITAL_TAG, capital);

        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_MIN_SIZE_TAG)) {
            minimumSize = xReader.getAttribute(OLD_MIN_SIZE_TAG, minimumSize);
        } else {
        // end @compat 0.11.3
            minimumSize = xReader.getAttribute(MIN_SIZE_TAG, minimumSize);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_MAX_SIZE_TAG)) {
            maximumSize = xReader.getAttribute(OLD_MAX_SIZE_TAG, maximumSize);
        } else {
        // end @compat 0.11.3
            maximumSize = xReader.getAttribute(MAX_SIZE_TAG, maximumSize);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_VIS_RAD_TAG)) {
            visibleRadius = xReader.getAttribute(OLD_VIS_RAD_TAG, visibleRadius);
        } else {
        // end @compat 0.11.3
            visibleRadius = xReader.getAttribute(VIS_RAD_TAG, visibleRadius);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_CRAD_TAG)) {
            claimableRadius = xReader.getAttribute(OLD_CRAD_TAG, claimableRadius);
        } else {
        // end @compat 0.11.3
            claimableRadius = xReader.getAttribute(CRAD_TAG, claimableRadius);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_EX_CRAD_TAG)) {
            exCrad = xReader.getAttribute(OLD_EX_CRAD_TAG, exCrad);
        } else {
        // end @compat 0.11.3
            exCrad = xReader.getAttribute(EX_CRAD_TAG, exCrad);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_WRAD_TAG)) {
            wanderingRadius = xReader.getAttribute(OLD_WRAD_TAG, wanderingRadius);
        } else {
        // end @compat 0.11.3
            wanderingRadius = xReader.getAttribute(WRAD_TAG, wanderingRadius);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_MIN_GRO_TAG)) {
            minimumGrowth = xReader.getAttribute(OLD_MIN_GRO_TAG, minimumGrowth);
        } else {
        // end @compat 0.11.3
            minimumGrowth = xReader.getAttribute(MIN_GRO_TAG, minimumGrowth);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_MAX_GRO_TAG)) {
            maximumGrowth = xReader.getAttribute(OLD_MAX_GRO_TAG, maximumGrowth);
        } else {
        // end @compat 0.11.3
            maximumGrowth = xReader.getAttribute(MAX_GRO_TAG, maximumGrowth);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_TB_TAG)) {
            tradeBonus = xReader.getAttribute(OLD_TB_TAG, tradeBonus);
        } else {
        // end @compat 0.11.3
            tradeBonus = xReader.getAttribute(TB_TAG, tradeBonus);
        }
        // @compat 0.11.3
        if (xReader.hasAttribute(OLD_CT_TAG)) {
            convertThreshold = xReader.getAttribute(OLD_CT_TAG, convertThreshold);
        } else {
        // end @compat 0.11.3
            convertThreshold = xReader.getAttribute(CT_TAG, convertThreshold);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void readChildren(final FreeColXMLReader xReader) throws XMLStreamException {
        // Clear containers.
        if (xReader.shouldClearContainers()) {
            plunder = null;
            gifts = null;
        }

        super.readChildren(xReader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void readChild(final FreeColXMLReader xReader) throws XMLStreamException {
        final String tag = xReader.getLocalName();

        if (GIFTS_TAG.equals(tag)) {
            addGift(new RandomRange(xReader));

        } else if (PLUNDER_TAG.equals(tag)) {
            addPlunder(new RandomRange(xReader));

        } else {
            super.readChild(xReader);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTagName() { return getTagName(); }

    /**
     * Gets the tag name of the root element representing this object.
     *
     * @return "settlementType".
     */
    public static String getTagName() {
        return "settlementType";
    }
}
