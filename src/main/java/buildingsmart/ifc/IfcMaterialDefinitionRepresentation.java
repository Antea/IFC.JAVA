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

import java.util.List;

public class IfcMaterialDefinitionRepresentation
        extends IfcProductRepresentation {
    private final IfcMaterial RepresentedMaterial;

    /**
     * @param name            The word or group of words by which the product
     *                        representation is known.
     * @param description     The word or group of words that characterize the
     *                        product representation. It can be used to add
     *                        additional meaning to the name of the product
     *                        representation.
     * @param representations Contained list of representations (including shape
     *                        representations). Each member defines a valid
     *                        representation of a particular type within a
     *                        particular representation context.
     * @throws IllegalArgumentException If representations is null, or if its
     * size
     *                                  is lower than 1.
     */
    public IfcMaterialDefinitionRepresentation(IfcLabel name,
                                               IfcText description,
                                               List<IfcRepresentation> representations,
                                               IfcMaterial representedMaterial) {
        super(name, description, representations);
        RepresentedMaterial = representedMaterial;
    }
}
