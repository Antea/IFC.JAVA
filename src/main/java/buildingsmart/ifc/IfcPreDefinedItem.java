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
import buildingsmart.io.Entity;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * <p>: A pre defined item is
 * a qualified name given to a style, font, etc., which is determined within the data exchange specification by
 * convention on using the <i>Name</i> attribute value (in contrary to externally defined items, which are agreed by an
 * external source).</p>
 * <blockquote>
 * <small>NOTE&nbsp; The
 * convention on using the <i>Name</i> value is defined at the subtypes of <i>IfcPreDefinedItem</i> and is part of the
 * specification. </small></blockquote>
 */
@EqualsAndHashCode(callSuper = false)
@ToString
public class IfcPreDefinedItem extends Entity {

    @Attribute(0)
    private final IfcLabel name;

    /**
     * @param name The string by which the pre defined item is identified. Allowable values for the string are declared
     *             at the level of subtypes.
     * @throws NullPointerException If {@code name} is {@code null}.
     */
    public IfcPreDefinedItem(@NonNull IfcLabel name) {
        this.name = name;
    }
}
