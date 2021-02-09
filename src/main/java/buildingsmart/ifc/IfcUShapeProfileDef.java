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
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * <p>The <i>IfcUShapeProfileDef</i> defines a section profile that provides
 * the defining parameters of a U-shape (channel) section to be used by the
 * swept area solid. Its parameters and orientation relative to the position
 * coordinate system are according to the following illustration. The centre of
 * the position coordinate system is in the^profiles centre of the
 * <strike>gravity</strike> bounding box.</p>
 * <p>The centre of gravity, if
 * given, is located in y direction within the center of the bounding box, and
 * in x-direction along the negative x axis, the offset value is given by the
 * offset parameter CentreOfGravityInX.
 * </p>
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IfcUShapeProfileDef extends IfcParameterizedProfileDef {
    @Attribute(3)
    private final IfcPositiveLengthMeasure depth;
    @Attribute(4)
    private final IfcPositiveLengthMeasure flangeWidth;
    @Attribute(5)
    private final IfcPositiveLengthMeasure webThickness;
    @Attribute(6)
    private final IfcPositiveLengthMeasure flangeThickness;
    @Attribute(7)
    private final IfcPositiveLengthMeasure filletRadius;
    @Attribute(8)
    private final IfcPositiveLengthMeasure edgeRadius;
    @Attribute(9)
    private final IfcPlaneAngleMeasure flangeSlope;
    @Attribute(10)
    private final IfcPositiveLengthMeasure centreOfGravityInX;

    /**
     * @param profileType        Defines the type of geometry into which this
     *                           profile definition shall be resolved, either a
     *                           curve or a surface area. In case of curve the
     *                           profile should be referenced by a swept
     *                           surface, in case of area the profile should be
     *                           referenced by a swept area solid.
     * @param profileName        Name of the profile type according to some
     *                           standard profile table.
     * @param position           Position coordinate system of the parameterized
     *                           profile definition.
     * @param depth              Web lengths.
     * @param flangeWidth        Flange lengths.
     * @param webThickness       Constant wall thickness of web.
     * @param flangeThickness    Constant wall thickness of flange.
     * @param filletRadius       Fillet radius. If it is not given, zero is
     *                           assumed.
     * @param edgeRadius         Edge radius. If it is not given, zero is
     *                           assumed.
     * @param flangeSlope        Slope of flange of the profile. If it is not
     *                           given, zero is assumed.
     * @param centreOfGravityInX Location of centre of gravity along the x axis
     *                           measured from the center of the bounding box.
     * @throws NullPointerException     If profileType, position, depth,
     *                                  flangeWidth, webThickness or
     *                                  flangeThickness are null.
     * @throws IllegalArgumentException If flangeThickness is not smaller than
     *                                  half of depth, if webThickness is not
     *                                  smaller than flangeWidth.
     */
    @Builder
    public IfcUShapeProfileDef(@NonNull IfcProfileTypeEnum profileType,
                               IfcLabel profileName,
                               @NonNull IfcAxis2Placement2D position,
                               @NonNull IfcPositiveLengthMeasure depth,
                               @NonNull IfcPositiveLengthMeasure flangeWidth,
                               @NonNull IfcPositiveLengthMeasure webThickness,
                               @NonNull IfcPositiveLengthMeasure flangeThickness,
                               IfcPositiveLengthMeasure filletRadius,
                               IfcPositiveLengthMeasure edgeRadius,
                               IfcPlaneAngleMeasure flangeSlope,
                               IfcPositiveLengthMeasure centreOfGravityInX) {
        super(profileType, profileName, position);
        if (flangeThickness.getValue() >= (depth.getValue() / 2)) {
            throw new IllegalArgumentException(
                    "flangeThickness must be smaller than half of depth");
        }
        if (webThickness.getValue() >= flangeWidth.getValue()) {
            throw new IllegalArgumentException(
                    "webThickness must be smaller than flangeWidth");
        }
        this.depth = depth;
        this.flangeWidth = flangeWidth;
        this.webThickness = webThickness;
        this.flangeThickness = flangeThickness;
        this.filletRadius = filletRadius;
        this.edgeRadius = edgeRadius;
        this.flangeSlope = flangeSlope;
        this.centreOfGravityInX = centreOfGravityInX;
    }
}
