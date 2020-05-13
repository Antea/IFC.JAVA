package buildingsmart.ifc;

import buildingsmart.util.Functions;
import com.sun.istack.internal.NotNull;

import java.util.Objects;

/**
 * An SI unit is the fixed quantity used as a standard in terms of which items
 * are measured as defined by ISO 1000 (clause 2).
 */
public class IfcSIUnit extends IfcNamedUnit {
    private final IfcSIPrefix prefix;
    private final IfcSIUnitName name;
    //TODO: test constructor

    /**
     * @param unitType The type of the unit.
     * @param prefix   The SI Prefix for defining decimal multiples and
     *                 submultiples of the unit.
     * @param name     The word, or group of words, by which the SI unit is
     *                 referred to.
     * @throws IllegalArgumentException If unitType or name are null, or if the
     *                                  given unitType is not the appropriate
     *                                  one for the given name.
     */
    public IfcSIUnit(@NotNull IfcUnitEnum unitType, IfcSIPrefix prefix,
                     @NotNull IfcSIUnitName name) {
        super(Functions.ifcDimensionsForSiUnit(name), unitType);
        this.prefix = prefix;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        IfcSIUnit ifcSIUnit = (IfcSIUnit) o;
        return prefix == ifcSIUnit.prefix && name == ifcSIUnit.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), prefix, name);
    }
}
