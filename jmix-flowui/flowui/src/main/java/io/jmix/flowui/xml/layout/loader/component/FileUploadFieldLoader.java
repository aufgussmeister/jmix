/*
 * Copyright 2022 Haulmont.
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

package io.jmix.flowui.xml.layout.loader.component;

import io.jmix.flowui.component.upload.FileUploadField;

public class FileUploadFieldLoader extends AbstractUploadFieldLoader<FileUploadField> {

    @Override
    protected FileUploadField createComponent() {
        return factory.create(FileUploadField.class);
    }

    @Override
    public void loadComponent() {
        super.loadComponent();

        componentLoader().loadRequired(resultComponent, element, context);
        componentLoader().loadValidationAttributes(resultComponent, element, context);

        getLoaderSupport().loadString(element, "fileName", resultComponent::setFileName);
    }
}
