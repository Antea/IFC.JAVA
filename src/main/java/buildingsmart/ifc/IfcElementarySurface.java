/*
 * Copyright (C) 2019 Pieter Pauwels, Ghent University
 * Modifications Copyright (C) 2020 Giovanni Velludo
 *
 * This file is part of ifc-java.
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

import buildingsmart.io.Attribute;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * An elementary surface (IfcElementarySurface) is a simple analytic surface
 * with defined parametric representation.
 */
@EqualsAndHashCode(callSuper = false)
@ToString
public abstract class IfcElementarySurface extends IfcSurface {
    @Attribute(0)
    protected final IfcAxis2Placement3D position;

    /**
     * @param position The position and orientation of the surface. This
     *                 attribute is used in the definition of the
     *                 parameterization of the surface.
     * @throws NullPointerException If position is null.
     */
    public IfcElementarySurface(@NonNull IfcAxis2Placement3D position) {
        this.position = position;
    }
}
