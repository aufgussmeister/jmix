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

package component_xml_load

import com.vaadin.flow.component.shared.Tooltip
import component_xml_load.screen.FileUploadFieldView
import io.jmix.core.DataManager
import io.jmix.core.FileRef
import org.apache.commons.lang3.RandomUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import test_support.entity.attachment.DocumentAttachment
import test_support.spec.FlowuiTestSpecification

@SpringBootTest
class FileUploadFieldXmlLoadTest extends FlowuiTestSpecification {

    @Autowired
    private DataManager dataManager

    void setup() {
        registerViewBasePackages("component_xml_load.screen")

        dataManager.save(createAttachment())
    }

    def "Load FileUploadField component with datasource from XML"() {
        when: "Open view with FileUploadField"
        def view = navigateToView(FileUploadFieldView)


        then: "Field should be bound with data container"

        view.dataSourceFileUploadField.valueSource != null
        view.dataSourceFileUploadField.getValue() == view.attachmentDc.item.preview
        view.vceOccurred
    }

    def "Load FileUploadField component from XML"() {
        when: "Open view with FileUploadFields"
        def view = navigateToView(FileUploadFieldView)

        then: "FileUploadField attributes should be loaded"
        def field = view.xmlFileUploadField
        field.acceptedFileTypes[0] == ".jpg"
        field.classNames[0] == "custom-className"
        field.clearButtonAriaLabel == "clearButtonAriaLabel"
        field.i18n.uploading.status.connecting == "connectingStatusText"
        !field.dropAllowed
        field.errorMessage == "errorMessage"
        field.fileName == "fileName"
        field.fileNotSelectedText == "fileNotSelectedText"
        field.i18n.error.fileIsTooBig == "fileTooBigText"
        field.height == "8em"
        field.width == "20em"
        field.helperText == "helperText"
        field.i18n.error.incorrectFileType == "incorrectFileTypeText"
        field.label == "label"
        field.maxFileSize == 10480000
        field.maxHeight == "100em"
        field.maxWidth == "100em"
        field.minHeight == "8em"
        field.minWidth == "20em"
        field.i18n.uploading.status.processing == "processingStatusText"
        field.i18n.uploading.remainingTime.prefix == "remainingTimeText"
        field.i18n.uploading.remainingTime.unknown == "remainingTimeUnknownText"
        field.required
        field.requiredIndicatorVisible
        field.requiredMessage == "requiredMessage"
        field.i18n.uploadDialog.cancel == "uploadDialogCancelText"
        field.i18n.uploadDialog.title == "uploadDialogTitle"
        field.uploadIcon != null
        field.uploadText == "uploadText"
        !field.visible

        field.tooltip.text == "tooltipText"
        field.tooltip.focusDelay == 1
        field.tooltip.hideDelay == 2
        field.tooltip.hoverDelay == 3
        field.tooltip.manual
        field.tooltip.opened
        field.tooltip.position == Tooltip.TooltipPosition.BOTTOM

        view.readOnlyFileUploadField.readOnly
        !view.disabledFileUploadField.enabled
    }

    protected DocumentAttachment createAttachment() {
        def attachment = dataManager.create(DocumentAttachment)
        attachment.setName("test")
        attachment.setAttachment(FileRef.create("s1", "s1://2022/12/32/file.docx", "file.docx"))
        attachment.setPreview(RandomUtils.nextBytes(1))
        return attachment
    }
}
