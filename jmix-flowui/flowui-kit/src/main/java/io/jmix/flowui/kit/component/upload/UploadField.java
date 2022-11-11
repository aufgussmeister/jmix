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

package io.jmix.flowui.kit.component.upload;

public class UploadField extends UploadFieldBase<byte[]> {

    public UploadField() {
        this(new byte[0]);
    }

    public UploadField(byte[] defaultValue) {
        super(defaultValue);
    }

    @Override
    protected void setPresentationValue(byte[] newPresentationValue) {
        // todo rp
    }
}
