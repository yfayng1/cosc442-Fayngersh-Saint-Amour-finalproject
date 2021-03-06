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
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import net.sf.freecol.common.io.FreeColXMLReader;
import net.sf.freecol.common.io.FreeColXMLWriter;
import static net.sf.freecol.common.util.CollectionUtils.*;
import net.sf.freecol.common.util.Utils;


/**
 * This class describes a possible production type of a tile or building.
 */
public class ProductionType extends FreeColSpecObject {

    // Serialization

    private static final String UNATTENDED_TAG = "unattended";
    private static final String GOODS_TYPE_TAG = "goods-type";
    private static final String INPUT_TAG = "input";
    private static final String OUTPUT_TAG = "output";
    private static final String PRODUCTION_LEVEL_TAG = "production-level";
    // @compat 0.11.3
    private static final String OLD_PRODUCTION_LEVEL_TAG = "productionLevel";
    // end @compat 0.11.3

	
    /** Whether this production type applies only to colony center tiles. */
    private boolean unattended;

    /**
     * The production level of this production type (usually a
     * difficulty level key).
     */
    private String productionLevel;

    /** The goods that are produced by this production type. */
    private List<AbstractGoods> outputs = null;

    /** The goods that are consumed by this production type. */
    private List<AbstractGoods> inputs = null;


    /**
     * Simple constructor.
     *
     * @param specification The <code>Specification</code> to refer to.
     */
    public ProductionType(final Specification specification) {
        super(specification);
    }

    /**
     * Creates a new production type that consumes no raw materials
     * and produces the given output.
     *
     * @param outputs A list of the <code>AbstractGoods</code> produced.
     */
    public ProductionType(final List<AbstractGoods> outputs) {
        this((Specification)null);

        this.outputs = outputs;
    }

    /**
     * Creates a new production type that consumes the given raw materials
     * and produces the given output.
     *
     * @param inputs A list of the <code>AbstractGoods</code> consumed.
     * @param outputs A list of the <code>AbstractGoods</code> produced.
     */
    public ProductionType(final List<AbstractGoods> inputs,
                          final List<AbstractGoods> outputs) {
        this(outputs);

        this.inputs = inputs;
    }

    /**
     * Convenience constructor for a production type with a single output.
     *
     * @param output The <code>AbstractGoods</code> produced.
     * @param unattended True if this is unattended production.
     * @param level The difficulty level key.
     */
    public ProductionType(final AbstractGoods output, final boolean unattended,
                          final String level) {
        this(new ArrayList<AbstractGoods>());

        this.outputs.add(output);
        this.unattended = unattended;
        this.productionLevel = level;
    }

    /**
     * Convenience constructor for a new <code>ProductionType</code>
     * instance with a single input and output.
     *
     * @param input The <code>GoodsType</code> consumed.
     * @param output The <code>GoodsType</code> produced.
     * @param amount The amount of goods both produced and consumed.
     */
    public ProductionType(final GoodsType input, final GoodsType output, final int amount) {
        this((Specification)null);
        
        if (input != null) {
            this.inputs = new ArrayList<>();
            this.inputs.add(new AbstractGoods(input, amount));
        }
        if (output != null) {
            this.outputs = new ArrayList<>();
            this.outputs.add(new AbstractGoods(output, amount));
        }
    }

    /**
     * Creates a new <code>ProductionType</code> instance.
     *
     * @param xReader The <code>FreeColXMLReader</code> to read from.
     * @param specification The <code>Specification</code> to refer to.
     * @exception XMLStreamException if there is a problem reading the stream.
     */
    public ProductionType(final FreeColXMLReader xReader, final Specification specification) throws XMLStreamException {
        this(specification);

        readFromXML(xReader);
    }


    /**
     * Get the input goods.
     *
     * @return A list of the input <code>AbstractGoods</code>.
     */
    public final List<AbstractGoods> getInputs() {
        return (inputs == null) ? Collections.<AbstractGoods>emptyList()
            : inputs;
    }

    /**
     * Set the input goods.
     *
     * @param newInputs The new list of input <code>AbstractGoods</code>.
     */
    public final void setInputs(final List<AbstractGoods> newInputs) {
        this.inputs = newInputs;
    }

    /**
     * Add a new input.
     *
     * @param type The <code>GoodsType</code> to add.
     * @param amount The amount of goods.
     */
    private void addInput(final GoodsType type, final int amount) {
        if (inputs == null) {
        	inputs = new ArrayList<>(1);
        }
        inputs.add(new AbstractGoods(type, amount));
    }

    /**
     * Get the output goods.
     *
     * @return A list of the output <code>AbstractGoods</code>.
     */
    public final List<AbstractGoods> getOutputs() {
        return (outputs == null) ? Collections.<AbstractGoods>emptyList()
            : outputs;
    }

    /**
     * Set the output goods.
     *
     * @param newOutputs The new list of output <code>AbstractGoods</code>.
     */
    public final void setOutputs(final List<AbstractGoods> newOutputs) {
        this.outputs = newOutputs;
    }

    /**
     * Add a new output.
     *
     * @param type The <code>GoodsType</code> to add.
     * @param amount The amount of goods.
     */
    private void addOutput(final GoodsType type, final int amount) {
        if (outputs == null) {
        	outputs = new ArrayList<>(1);
        }
        outputs.add(new AbstractGoods(type, amount));
    }

    /**
     * Get the goods of the given goods type in this production type.
     *
     * @param goodsType The <code>GoodsType</code> to check.
     * @return The <code>AbstractGoods</code> output if any, otherwise
     *     null.
     */
    public AbstractGoods getOutput(final GoodsType goodsType) {
        if (outputs != null) {
            final AbstractGoods output = AbstractGoods.findByType(goodsType, outputs);
            if (output != null) {
            	return output;
            }
        }
        return null;
    }

    /**
     * Get the type of the most productive output.
     *
     * @return The <code>GoodsType</code> of the most productive output.
     */
    public GoodsType getBestOutputType() {
        AbstractGoods goods;
        return (outputs == null
            || (goods = maximize(outputs, AbstractGoods.amountComparator)) == null)
            ? null
            : goods.getType();
    }

    /**
     * Get the unattended production state.
     *
     * @return True if this is unattended production.
     */
    public final boolean isUnattended() {
        return unattended;
    }

    /**
     * Set the unattended state of this production.
     *
     * @param unattended The new unattended production state.
     */
    public final void setUnattended(final boolean unattended) {
        this.unattended = unattended;
    }

    /**
     * The production level of this type of production (used by
     * difficulty levels).
     *
     * @return The production level key.
     */
    public final String getProductionLevel() {
        return productionLevel;
    }

    /**
     * Does this production apply to a given difficulty level.
     *
     * @param level The difficulty level key to check.
     * @return True if this production applies.
     */
    public boolean appliesTo(final String level) {
        return level == null
            || productionLevel == null
            || level.equals(productionLevel);
    }

    /**
     * Does this production apply exactly to a given difficulty level,
     * that is without using wildcard matches on null.
     *
     * @param level The difficulty level key to check.
     * @return True if this production applies.
     */
    public boolean appliesExactly(final String level) {
        return level != null && level.equals(productionLevel);
    }


    /**
     * Convenience function to check if there is an output for a given
     * goods type in a collection of production types.
     *
     * @param goodsType The <code>GoodsType</code> to use.
     * @param types A list of <code>ProductionType</code>s to consider.
     * @return The most productive output that produces the goods type,
     *     or null if none found.
     */
    public static boolean canProduce(final GoodsType goodsType,
                                     final Collection<ProductionType> types) {
        return any(types, prodType -> AbstractGoods.containsType(goodsType,
                prodType.getOutputs()));
    }

    /**
     * Get the production type with the greatest total output of an
     * optional goods type from a collection of production types
     *
     * @param goodsType An optional <code>GoodsType</code> to restrict the
     *     choice of outputs with.
     * @param types A collection of <code>ProductionType</code>s to consider.
     * @return The most productive <code>ProductionType</code>.
     */
    public static ProductionType getBestProductionType(final GoodsType goodsType,
        final Collection<ProductionType> types) {
        ProductionType best = null;
        int bestSum = 0;
        for (final ProductionType pt : types) {
            final int sum = pt.getOutputs().stream()
                .filter(optType -> goodsType == null || goodsType == optType.getType())
                .mapToInt(AbstractGoods::getAmount).sum();
            if (bestSum < sum) {
                bestSum = sum;
                best = pt;
            }
        }
        return best;
    }

    /**
     * Convenience function to get the best output for a given goods
     * type from a collection of production types.
     *
     * @param goodsType The <code>GoodsType</code> to use.
     * @param types A collection of <code>ProductionType</code>s to consider.
     * @return The most productive output that produces the goods type,
     *     or null if none found.
     */
    public static AbstractGoods getBestOutputFor(final GoodsType goodsType,
                                                 final Collection<ProductionType> types) {
        AbstractGoods best = null;
        for (final ProductionType productionType : types) {
            for (final AbstractGoods output : productionType.getOutputs()) {
                if (output.getType() == goodsType
                    && (best == null
                        || output.getAmount() > best.getAmount())) {
                    best = output;
                }
            }
        }
        return best;
    }


    // Override Object

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
        	return true;
        }
        if (object instanceof ProductionType) {
            final ProductionType prodType = (ProductionType)object;
            return super.equals(object)
                && this.unattended == prodType.unattended
                && Utils.equals(this.productionLevel, prodType.productionLevel)
                && listEquals(this.outputs, prodType.outputs)
                && listEquals(this.inputs, prodType.inputs);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + ((this.unattended) ? 1 : 0);
        hash = 31 * hash + Utils.hashCode(this.productionLevel);
        if (this.outputs != null) {
            for (final AbstractGoods ag : this.outputs) {
                hash = 31 * hash + Utils.hashCode(ag);
            }
        }
        if (this.inputs != null) {
            for (final AbstractGoods ag : this.inputs) {
                hash = 31 * hash + Utils.hashCode(ag);
            }
        }
        return hash;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeAttributes(final FreeColXMLWriter xWriter) throws XMLStreamException {
        // ProductionType does not need an id.
        // No need for: super.writeAttributes(out);

        if (unattended) {
            xWriter.writeAttribute(UNATTENDED_TAG, unattended);
        }

        if (productionLevel != null) {
            xWriter.writeAttribute(PRODUCTION_LEVEL_TAG, productionLevel);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void writeChildren(final FreeColXMLWriter xWriter) throws XMLStreamException {
        super.writeChildren(xWriter);

        if (inputs != null) {
            for (final AbstractGoods input : inputs) {
                xWriter.writeStartElement(INPUT_TAG);

                xWriter.writeAttribute(GOODS_TYPE_TAG, input.getType());

                xWriter.writeAttribute(VALUE_TAG, input.getAmount());

                xWriter.writeEndElement();
            }
        }

        if (outputs != null) {
            for (final AbstractGoods output : outputs) {
                xWriter.writeStartElement(OUTPUT_TAG);

                xWriter.writeAttribute(GOODS_TYPE_TAG, output.getType());

                xWriter.writeAttribute(VALUE_TAG, output.getAmount());

                xWriter.writeEndElement();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readAttributes(final FreeColXMLReader xReader) throws XMLStreamException {
        // ProductionType does not need an id.
        // No need for: super.readAttributes(in);
        // FIXME: as soon as we allow the user to select a production type,
        // we will need an id

        unattended = xReader.getAttribute(UNATTENDED_TAG, false);

        productionLevel = xReader.getAttribute(PRODUCTION_LEVEL_TAG, (String)null);
        // @compat 0.11.3
        if (productionLevel == null) {
            productionLevel = xReader.getAttribute(OLD_PRODUCTION_LEVEL_TAG, (String)null);
        }
        // end @compat 0.11.3
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readChildren(final FreeColXMLReader xReader) throws XMLStreamException {
        // Clear containers.
        if (inputs != null) {
        	inputs.clear();
        }
        if (outputs != null) {
        	outputs.clear();
        }

        super.readChildren(xReader);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void readChild(final FreeColXMLReader xReader) throws XMLStreamException {
        final Specification spec = getSpecification();
        final String tag = xReader.getLocalName();

        if (INPUT_TAG.equals(tag)) {
            final GoodsType type = xReader.getType(spec, GOODS_TYPE_TAG,
                                        GoodsType.class, (GoodsType)null);
            if (type == null) {
                logger.warning("Skipping input with null type: "
                    + xReader.getAttribute(GOODS_TYPE_TAG, (String)null));
            } else {
                addInput(type, xReader.getAttribute(VALUE_TAG, -1));
            }
            xReader.closeTag(INPUT_TAG);

        } else if (OUTPUT_TAG.equals(tag)) {
            final GoodsType type = xReader.getType(spec, GOODS_TYPE_TAG,
                                        GoodsType.class, (GoodsType)null);
            if (type == null) {
                logger.warning("Skipping output with null type: "
                    + xReader.getAttribute(GOODS_TYPE_TAG, (String)null));
            } else {
                addOutput(type, xReader.getAttribute(VALUE_TAG, -1));
            }
            xReader.closeTag(OUTPUT_TAG);

        } else {
            super.readChild(xReader);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder(64);
        result.append("[").append(getId()).append(":");
        if (productionLevel != null) {
            result.append(" ").append(productionLevel);
        }
        if (unattended) {
            result.append(" unattended");
        }
        if (!(inputs == null || inputs.isEmpty())) {
            result.append(" [inputs: ");
            for (final AbstractGoods input : inputs) {
                result.append(input).append(", ");
            }
            final int length = result.length();
            result.replace(length - 2, length, "]");
        }
        if (!(outputs == null || outputs.isEmpty())) {
            result.append(" [outputs: ");
            for (final AbstractGoods output : outputs) {
                result.append(output).append(", ");
            }
            final int length = result.length();
            result.replace(length - 2, length, "]");
        }
        result.append("]");
        return result.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTagName() { return getTagName(); }

    /**
     * Gets the tag name of the root element representing this object.
     *
     * @return "production".
     */
    public static String getTagName() {
        return "production";
    }
}
