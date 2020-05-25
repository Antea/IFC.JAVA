/*
 * Copyright (C) 2019 Pieter Pauwels, Ghent University
 * Modifications Copyright (C) 2020 Giovanni Velludo
 *
 * This file is part of IFC.JAVA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package buildingsmart.ifc;

import buildingsmart.io.IfcEntity;
import buildingsmart.util.Functions;
import com.sun.istack.internal.NotNull;

import java.util.Objects;
import java.util.Set;

/**
 * A set of units which may be assigned. Within an IfcUnitAssigment each unit
 * definition shall be unique. I.e. there shall be no redundant unit definitions
 * for the same unit type, like length unit, area unit etc. For currencies,
 * there shall be only a single IfcMonetaryUnit within an IfcUnitAssignment.
 * <p>
 * <small>NOTE:  A project (IfcProject) has a unit assignment which establishes
 * a set of units which will be used globally within the project, if not
 * otherwise defined. Other objects may have local unit assignments if there is
 * a requirement for them to make use of units which do not fall within the
 * project unit assignment.</small>
 */
public class IfcUnitAssignment extends IfcEntity {
    private final Set<IfcUnit> units;

    /**
     * @param units Units to be included within a unit assignment.
     * @throws IllegalArgumentException If units is null, has size equal to
     *                                  zero, doesn't only include units with a
     *                                  different unitType (for IfcNamedUnit and
     *                                  IfcDerivedUnit), or includes more than
     *                                  one IfcMonetaryUnit.
     */
    public IfcUnitAssignment(@NotNull Set<IfcUnit> units) {
        if (units == null) {
            throw new IllegalArgumentException("units cannot be null");
        }
        if (units.size() < 1) {
            throw new IllegalArgumentException(
                    "size of units must be at least 1");
        }
        if (!Functions.ifcCorrectUnitAssignment(units)) {
            throw new IllegalArgumentException("");
        }
        this.units = units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IfcUnitAssignment that = (IfcUnitAssignment) o;
        return units.equals(that.units);
    }

    @Override
    public int hashCode() {
        return Objects.hash(units);
    }
}
