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
 * The parameterized profile definition defines a 2D position coordinate system
 * to which the parameters of the different profiles relate to. All profiles are
 * defined centric to the origin of the position coordinate system, or more
 * specific, the origin [0.,0.] shall be in the center of the bounding box
 * <strike>gravity</strike> of the profile.</p>
 * <p>The <i>Position</i> attribute of the <i>IfcParameterizedProfileDef</i>
 * is used to position the profile within the XY plane of the underlying
 * coordinate system of the swept surface geometry, the swept area solid or the
 * sectioned spine. It can be used to position the profile at any cardinal point
 * that becomes the origin [0.,0.,0.] of the extruded or rotated surface or
 * solid.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class IfcParameterizedProfileDef extends IfcProfileDef {
    @Attribute(2)
    private final IfcAxis2Placement2D position;

    /**
     * @param profileType Defines the type of geometry into which this profile
     *                    definition shall be resolved, either a curve or a
     *                    surface area. In case of curve the profile should be
     *                    referenced by a swept surface, in case of area the
     *                    profile should be referenced by a swept area solid.
     * @param profileName Name of the profile type according to some standard
     *                    profile table.
     * @param position    Position coordinate system of the parameterized
     *                    profile definition.
     * @throws NullPointerException If profileType or position are null.
     */
    public IfcParameterizedProfileDef(@NonNull IfcProfileTypeEnum profileType,
                                      IfcLabel profileName,
                                      @NonNull IfcAxis2Placement2D position) {
        super(profileType, profileName);
        this.position = position;
    }
}

