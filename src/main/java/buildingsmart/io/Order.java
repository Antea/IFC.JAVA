/*
 * Copyright (C) 2020 Giovanni Velludo
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

package buildingsmart.io;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates the order in which fields with annotation {@link Attribute} or
 * {@link InverseAttribute} should be serialized in an IFC file. All fields
 * annotated with the same {@link Attribute} or {@link InverseAttribute}
 * Annotation must have a different value between each other (including fields
 * of superclasses). When applying this annotation on fields in a class, you
 * should continue counting from the highest value in the class' superclass.
 * Attributes and InverseAttributes have two different orderings, so both the
 * first {@link Attribute} and the first {@link InverseAttribute} in a class
 * will have value == 0. The ordering should follow the one outlined in the IFC
 * specification of each class (look at the section "Inheritance graph" in each
 * entity).
 */
@Target(ElementType.FIELD) @Retention(RetentionPolicy.RUNTIME)
public @interface Order {
    int value();
}
