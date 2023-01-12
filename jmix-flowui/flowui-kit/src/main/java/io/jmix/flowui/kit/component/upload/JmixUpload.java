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

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.internal.JsonSerializer;
import com.vaadin.flow.shared.Registration;

@Tag("jmix-upload")
@JsModule("./src/upload/jmix-upload.js")
public class JmixUpload extends Upload {

    protected JmixUploadI18N i18n = new JmixUploadI18N();

    protected static final String JMIX_UPLOAD_CLASS_NAME = "jmix-upload";

    public JmixUpload() {
        addClassName(JMIX_UPLOAD_CLASS_NAME);
    }

    public void setReadOnly(boolean readOnly) {
        getElement().setProperty("readOnly", readOnly);
    }

    public boolean isReadOnly() {
        return getElement().getProperty("readOnly", false);
    }

    public void setEnabled(boolean readOnly) {
        getElement().setProperty("enabled", readOnly);
    }

    public boolean isEnabled() {
        return getElement().getProperty("enabled", false);
    }

    @Override
    public void setI18n(UploadI18N i18n) {
        super.setI18n(i18n);

        if (i18n instanceof JmixUploadI18N) {
            ((JmixUploadI18N) i18n).copyUploadDialogPropertiesTo(this.i18n);
        }

        if (this.i18n.getUploadDialog() != null) {
            getElement().setPropertyJson("jmixI18n", JsonSerializer.toJson(this.i18n));
        }
    }

    protected Registration addUploadInternalError(ComponentEventListener<JmixUploadInternalErrorEvent> listener) {
        return addListener( JmixUploadInternalErrorEvent.class, listener);
    }

    @DomEvent("jmix-upload-internal-error")
    protected static class JmixUploadInternalErrorEvent extends ComponentEvent<JmixUpload> {
        protected String fileName;

        public JmixUploadInternalErrorEvent(JmixUpload source, boolean fromClient, @EventData("event.detail.file.name") String fileName) {
            super(source, fromClient);
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }
}
