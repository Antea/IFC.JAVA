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

import buildingsmart.io.DefinedType;
import buildingsmart.util.Functions;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * A text is an alphanumeric string of characters which is intended to be read
 * and understood by a human being. It is for information purposes only.
 */
@EqualsAndHashCode
@ToString
public class IfcText implements DefinedType, IfcSimpleValue {
    private final String value;

    /**
     * @param value Cannot be null.
     * @throws NullPointerException If value is null.
     */
    public IfcText(@NonNull final String value) {
        this.value = Functions.formatForStepFile(value);
    }

    @Override
    public String serialize() {
        return "'" + value + "'";
    }
}
