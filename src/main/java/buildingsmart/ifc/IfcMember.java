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

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

/**
 * <p>An <i>IfcMember</i>
 * is a structural member designed to carry loads between or beyond points of
 * support. It is not required to be load bearing. The location of the member
 * (being horizontal, vertical or sloped) is not relevant to its definition (in
 * contrary to <i>IfcBeam</i> and <i>IfcColumn</i>).</p>
 * </blockquote><p><u><b>Type Use Definition</b></u></p>
 * <p><i>IfcMember</i> defines the occuurence of any
 * member, common information about member types (or styles) is handled by
 * <i>IfcMemberType</i>. The <i>IfcMemberType</i> (if present) may establish
 * the common&nbsp;type name, usage (or predefined) type, common material layer
 * set, common set of properties and common shape representations (using
 * <i>IfcRepresentationMap</i>). The
 * <i>IfcMemberType</i>
 * is attached using the <i>IfcRelDefinedByType.RelatingType</i> objectified
 * relationship and is accessible by the inverse <i>IsDefinedBy</i>
 * attribute.</p>
 * <p>If no <span style="font-style: italic;">IfcMemberType</span>
 * is attached&nbsp;(i.e. if only occurrence information is given) the
 * predefined type may be given by using the <i>ObjectType</i>
 * attribute.&nbsp;Recommended values are 'member' (the default), 'brace',
 * 'collar', 'member', 'post', 'purlin', 'rafter', 'stringer', 'strut'.</p>
 * <p><u><b>Property Set Use Definition</b></u></p>
 * <p>The property sets relating to the <i>IfcMember</i>
 * are defined by the <i>IfcPropertySet</i> and attached by the
 * <i>IfcRelDefinesByProperties</i> relationship. It is accessible by the
 * inverse <i>IsDefinedBy</i> relationship. The following property set
 * definitions specific to the <i>IfcMember</i> are part of this IFC
 * release:</p>
 * <ul> <li><a
 *  href="../../psd/IfcSharedBldgElements/Pset_MemberCommon.xml"
 *  target="SOURCE">Pset_MemberCommon</a>: common property
 * set for all member occurrences</li>
 * </ul><p><u><b>Material Use Definition</b></u></p>
 * <p>The material of the <i>IfcMember </i>is defined
 * by
 * the <i>IfcMaterial</i> or <i>IfcMaterialList</i>
 * and attached by the <i>IfcRelAssociatesMaterial</i><i>.RelatingMaterial</i>.
 * It is accessible by the inverse <i>HasAssociations</i>
 * relationship. Material information can also be given at the&nbsp;
 * <i>IfcMember</i><i></i><i>Type</i>,
 * defining the common attribute data for all occurrences of the same
 * type.&nbsp;It is then accessible by the inverse <i>IsDefinedBy</i>
 * relationship pointing to <i>IfcMember</i><i>Type</i><i>.HasAssociations</i>
 * and via <i>IfcRelAssociatesMaterial.RelatingMaterial</i>
 * to <i>IfcMaterial</i> or <i>IfcMaterialList</i>.
 * If both are given, then the material directly assigned to <i>IfcMember
 * </i>overrides the material assigned to&nbsp;
 * <i>IfcMember</i><i></i><i>Type</i>.</p>
 * <p><u><b>Quantity Use Definition</b></u></p>
 * <p>The quantities relating to the <i>IfcMember</i>
 * are defined by the <i>IfcElementQuantity</i> and attached
 * by the <i>IfcRelDefinesByProperties</i> relationship. It
 * is accessible by the inverse <i>IsDefinedBy</i>
 * relationship. The following quantities are foreseen, but will be
 * subjected to the local standard of measurement used:</p>
 * <table border="1" cellpadding="2" cellspacing="2">
 * <tbody> <tr valign="top"> <td align="left"
 *  valign="top"><font size="-1"><i><b>Name</b></i></font></td>
 * <td align="left" valign="top" width="60%"><font
 *  size="-1"><i><b>Description</b></i></font></td>
 * <td align="left" valign="top"><font size="-1"><i><b>Value
 * Type</b></i></font></td> </tr> <tr>
 * <td align="left" valign="top"><font size="-1">NominalLength</font></td>
 * <td align="left" valign="top" width="60%"><font
 *  size="-1">Total nominal length of the member, not taking
 * into account any cut-out's or other processing features.</font></td>
 * <td align="left" valign="top"><font
 * size="-1"><i>IfcQuantityLength</i></font></td>
 * </tr> <tr> <td align="left" valign="top"><font
 *  size="-1">CrossSectionArea</font></td> <td
 *  align="left" valign="top" width="60%"><font
 *  size="-1">Total area of the cross section (or profile) of
 * the member. The exact definition and calculation rules depend on the
 * method of measurement used.</font></td> <td align="left"
 *  valign="top"><font size="-1"><i>IfcQuantityArea</i></font></td>
 * </tr> <tr> <td align="left" valign="top"><font
 *  size="-1">OuterSurfaceArea</font></td> <td
 *  align="left" valign="top" width="60%"><font
 *  size="-1">Total area of the extruded surfaces of the member
 * (not taking into account the end cap areas), normally generated as
 * perimeter * length.</font></td> <td align="left"
 *  valign="top"><font size="-1"><i>IfcQuantityArea</i></font></td>
 * </tr> <tr> <td align="left" valign="top"><font
 *  size="-1">TotalSurfaceArea</font></td> <td
 *  align="left" valign="top" width="60%"><font
 *  size="-1">Total area of the member, normally generated as
 * perimeter * length + 2 * cross section area.</font></td> <td
 *  align="left" valign="top"><font size="-1"><i>IfcQuantityArea</i></font></td>
 * </tr> <tr> <td align="left" valign="top"><font
 *  size="-1">GrossVolume</font></td> <td
 *  align="left" valign="top" width="60%"><font
 *  size="-1">Total gross volume of the member, not taking into
 * account possible processing features (cut-out's, etc.) or openings and
 * recesses. The exact definition and calculation rules depend on the
 * method of measurement used.</font></td> <td align="left"
 *  valign="top"><font size="-1"><i>IfcQuantityVolume</i></font></td>
 * </tr> <tr> <td align="left" valign="top"><font
 *  size="-1">NetVolume</font></td> <td
 *  align="left" valign="top" width="60%"><font
 *  size="-1">Total net volume of the member, taking into
 * account possible processing features (cut-out's, etc.) or openings and
 * recesses. The exact definition and calculation rules depend on the
 * method of measurement used.</font></td> <td align="left"
 *  valign="top"><font size="-1"><i>IfcQuantityVolume</i></font></td>
 * </tr> <tr> <td align="left" valign="top"><font
 *  size="-1">GrossWeight</font></td> <td
 *  align="left" valign="top" width="60%"><font
 *  size="-1"> Total gross weight of the member without add-on
 * parts, not taking into account possible processing features (cut-out's,
 * etc.) or openings and recesses.</font></td> <td
 *  align="left" valign="top"><font
 *  size="-1"><i>IfcQuantityWeight</i></font></td>
 * </tr> <tr> <td align="left" valign="top"><font
 *  size="-1">NetWeight</font></td> <td
 *  align="left" valign="top" width="60%"><font
 *  size="-1"> Total net weight of the member without add-on
 * parts, taking into account possible processing features (cut-out's,
 * etc.) or openings and recesses.</font></td> <td
 *  align="left" valign="top"><font
 *  size="-1"><i>IfcQuantityWeight</i></font></td>
 * </tr> </tbody>
 * </table><p><u><b>Containment Use Definition</b></u></p>
 * <p>The <i>IfcMember</i>, as any subtype of <i>IfcBuildingElement</i>,
 * may participate in two different containment relationships. The first
 * (and in most implementation scenarios mandatory) relationship is the
 * hierachical spatial containment, the second (optional) relationship is
 * the aggregation within an&nbsp;element assembly.</p>
 * <ul> <li>The <i>IfcMember</i> is placed
 * within the
 * project spatial hierarchy using the objectified relationship
 * <i>IfcRelContainedInSpatialStructure</i>,
 * referring to it by its inverse attribute <i>SELF\IfcElement
 * .ContainedInStructure</i>.
 * Subtypes of&nbsp;<i>IfcSpatialStructureElement</i> are
 * valid spatial containers, with <i>IfcBuildingStorey</i>
 * being the default container.</li> <li>The <i>IfcMember</i>
 * may be aggregated into an
 * element assembly using the objectified relationship <i>IfcRelAggregates</i>,
 * referring to it by its inverse attribute <i>SELF\IfcObjectDefinition
 * .Decomposes</i>.
 * Any subtype of <i>IfcElement</i> can be an element
 * assembly, with <i>IfcElementAssembly</i> as a special
 * focus subtype. </li>
 * </ul><p><u><b>Geometry Use Definition</b></u></p>
 * <p>The geometric representation of <i>IfcMember</i>
 * is given by the <i>IfcProductDefinitionShape</i>, allowing
 * multiple geometric representations. Included are: </p>
 * <p><b>Local Placement</b></p>
 * <p>The local placement for <i>IfcMember</i> is
 * defined in its supertype <i>IfcProduct</i>. It is defined
 * by the <i>IfcLocalPlacement</i>, which defines the local
 * coordinate system that is referenced by all geometric representations. </p>
 * <ul> <li>The <i>PlacementRelTo</i>
 * relationship of <i>IfcLocalPlacement</i>
 * shall point (if given) to the local placement of the same
 * <i>IfcSpatialStructureElement</i>,
 * which is used in the <i>ContainedInStructure</i> inverse
 * attribute, or to a spatial structure element at a higher level,
 * referenced by that. </li> <li>If the relative placement
 * is not used, the absolute
 * placement is defined within the world coordinate system.</li>
 * </ul><p><b><i>Geometric Representations</i></b></p>
 * <p>Currently, the use of 'SweptSolid', 'Clipping', and
 * 'MappedRepresentation' representations is supported. In addition the
 * general representation types 'SurfaceModel', 'Brep', and 'BoundingBox'
 * are
 * allowed. The geometry use definition for 'BoundingBox', 'SurfaceModel'
 * and 'Brep' is explained at <i>IfcBuildingElement</i>.</p>
 * <p><b>SweptSolid Representation</b></p>
 * <p>The standard geometric representation of <i>IfcMember</i>
 * is defined using the 'SweptSolid' representation. The following
 * attribute values for the <i>IfcShapeRepresentation</i>
 * holding this geometric representation shall be used:</p>
 * <ul> <li><i>RepresentationIdentifier</i> :
 * 'Body'</li> <li><i>RepresentationType</i> :
 * 'SweptSolid'</li>
 * </ul><p>The following additional constraints apply to the
 * 'SweptSolid'
 * representation: </p>
 * <ul> <li><u>Solid</u>: <i>IfcExtrudedAreaSolid</i>
 * shall be supported </li> <li><u>Profile</u>:
 * All subtypes of <i>IfcParameterizedProfileDef</i>
 * and <i>IfcArbitraryClosedProfileDef</i> (including the
 * subtype <i>IfcArbitraryProfileDefWithVoids</i>) shall be
 * supported
 * (exclusions need to be agreed upon by implementer agreements).</li>
 * <li><u>Extrusion</u>: All extrusion directions shall
 * be supported.</li>
 * </table><p><b>Clipping Representation</b></p>
 * <p>The advanced geometric representation of <i>IfcBeam</i>
 * is defined using the 'Clipping' geometry. The following attribute
 * values for the <i>IfcShapeRepresentation</i>
 * holding this geometric representation shall be used:</p>
 * <ul> <li><i>RepresentationIdentifier</i> :
 * 'Body'</li> <li><i>RepresentationType</i> :
 * 'Clipping'</li>
 * </ul><p>The following constraints apply to the advanced
 * representation: </p>
 * <ul> <li><u>Solid</u>: see 'SweptSolid'
 * geometric
 * representation </li> <li><u>Profile</u>: see
 * 'SweptSolid' geometric
 * representation </li> <li><u>Extrusion</u>:&nbsp;see
 * 'SweptSolid' geometric
 * representation</li> <li><u>Boolean result</u>:
 * The <i>IfcBooleanClippingResult</i>
 * shall be supported, allowing for Boolean differences between the swept
 * solid (here <i>IfcExtrudedAreaSolid</i>) and one or
 * several <i>IfcHalfSpaceSolid</i> (or its subtypes). </li>
 * </table><p><b>MappedRepresentation</b></p>
 * <p>In addition to the &nbsp;'SweptSolid' and
 * the 'Clipping' geometric
 * representation of <i>IfcMember</i>&nbsp;also the
 * 'MappedRepresentation'
 * shall be supported as it allows for reusing the geometry definition of
 * the member type at all occurrences of the same type. The following
 * attribute values for the <i>IfcShapeRepresentation</i>
 * holding this geometric representation shall be used:</p>
 * <ul> <li><i>RepresentationIdentifier</i> :
 * 'Body'</li> <li><i>RepresentationType</i> :
 * 'MappedRepresentation'</li>
 * </ul><p>The same constraints, as given for
 * the&nbsp;'SweptSolid' and
 * the 'Clipping' geometric representation, shall
 * apply to the <i>MappedRepresentation</i> of the
 * <i>IfcRepresentationMap</i>.</p>
 */
@ToString(callSuper = true)
public class IfcMember extends IfcBuildingElement {
    /**
     * Creates a new IfcBuildingElement, using the provided globalId.
     *
     * @param globalId        Assignment of a globally unique identifier within
     *                        the entire software world.
     * @param ownerHistory    Assignment of the information about the current
     *                        ownership of that object, including owning actor,
     *                        application, local identification and information
     *                        captured about the recent changes of the object,
     *                        NOTE: only the last modification in stored.
     * @param name            Optional name for use by the participating
     *                        software systems or users. For some subtypes of
     *                        IfcRoot the insertion of the Name attribute may be
     *                        required . This would be enforced by a where
     *                        rule.
     * @param description     Optional description, provided for exchanging
     *                        informative comments.
     * @param objectType      The type denotes a particular type that indicates
     *                        the object further. The use has to be established
     *                        at the level of instantiable subtypes. In
     *                        particular it holds the user defined type, if the
     *                        enumeration of the attribute PredefinedType is set
     *                        to USERDEFINED.
     * @param objectPlacement Placement of the product in space, the placement
     *                        can either be absolute (relative to the world
     *                        coordinate system), relative (relative to the
     *                        object placement of another product), or
     *                        constraint (e.g. relative to grid axes). It is
     *                        determined by the various subtypes of
     *                        IfcObjectPlacement, which includes the axis
     *                        placement information to determine the
     *                        transformation for the object coordinate system.
     * @param representation  Reference to the representations of the product,
     *                        being either a representation
     *                        (IfcProductRepresentation)
     *                        or as a special case a shape representations
     *                        (IfcProductDefinitionShape). The product
     *                        definition shape provides for multiple geometric
     *                        representations of the shape property of the
     *                        object within the same object coordinate system,
     *                        defined by the object placement.
     * @param tag             The tag (or label) identifier at the particular
     *                        instance of a product, e.g. the serial number, or
     *                        the position number. It is the identifier at the
     *                        occurrence level.
     * @throws NullPointerException     If globalId or ownerHistory are null.
     * @throws IllegalArgumentException If globalId was used in another instance
     *                                  of this class; if representation is not
     *                                  null and objectPlacement is, while
     *                                  representation is an instance of
     *                                  IfcProductDefinitionShape.
     */
    @Builder
    public IfcMember(@NonNull IfcGloballyUniqueId globalId,
                     @NonNull IfcOwnerHistory ownerHistory,
                     IfcLabel name,
                     IfcText description,
                     IfcLabel objectType,
                     IfcObjectPlacement objectPlacement,
                     IfcProductRepresentation representation,
                     IfcIdentifier tag) {
        super(globalId,
              ownerHistory,
              name,
              description,
              objectType,
              objectPlacement,
              representation,
              tag);
    }
}
