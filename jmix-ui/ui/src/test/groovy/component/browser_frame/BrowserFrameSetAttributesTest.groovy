/*
 * Copyright 2020 Haulmont.
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

package component.browser_frame

import component.browser_frame.screen.*
import io.jmix.core.CoreConfiguration
import io.jmix.data.DataConfiguration
import io.jmix.eclipselink.EclipselinkConfiguration
import io.jmix.ui.UiConfiguration
import io.jmix.ui.component.BrowserFrame
import io.jmix.ui.testassistspock.spec.ScreenSpecification
import org.springframework.test.context.ContextConfiguration
import test_support.UiTestConfiguration

@ContextConfiguration(classes = [CoreConfiguration, UiConfiguration, DataConfiguration,
        EclipselinkConfiguration, UiTestConfiguration])
class BrowserFrameSetAttributesTest extends ScreenSpecification {

    @Override
    void setup() {
        exportScreensPackages(["component.browser_frame"])
    }

    def "Sets allow attribute to BrowserFrame"() {
        showTestMainScreen()

        def bfAllowScreen = screens.create(BrowserFrameAllowTestScreen)
        bfAllowScreen.show()

        when:
        def bfAllowParameter = bfAllowScreen.getWindow().getComponentNN("bfAllowParameter") as BrowserFrame
        def bfAllowParameters2 = bfAllowScreen.getWindow().getComponentNN("bfAllowParameters2") as BrowserFrame
        def bfAllowParameters5 = bfAllowScreen.getWindow().getComponentNN("bfAllowParameters5") as BrowserFrame
        def bfAllowCustomParameter = bfAllowScreen.getWindow().getComponentNN("bfAllowCustomParameter") as BrowserFrame
        def bfAllowCombinedParameters = bfAllowScreen.getWindow().getComponentNN("bfAllowCombinedParameters") as BrowserFrame

        then:
        bfAllowParameter.allow == "fullscreen"
        bfAllowParameters2.allow == "autoplay camera"
        bfAllowParameters5.allow == "fullscreen geolocation document-domain microphone payment"
        bfAllowCustomParameter.allow == "custom-parameter"
        bfAllowCombinedParameters.allow == "payment custom-parameter"
    }

    def "Sets referrerpolicy attribute to BrowserFrame"() {
        showTestMainScreen()

        def bfReferrerPolicyScreen = screens.create(BrowserFrameReferrerPolicyTestScreen)
        bfReferrerPolicyScreen.show()

        when:
        def bfReferrerPolicyParameter = bfReferrerPolicyScreen.getWindow().getComponentNN("bfReferrerPolicyParameter") as BrowserFrame
        def bfReferrerPolicyParameters2 = bfReferrerPolicyScreen.getWindow().getComponentNN("bfReferrerPolicyParameters2") as BrowserFrame
        def bfReferrerPolicyParameters5 = bfReferrerPolicyScreen.getWindow().getComponentNN("bfReferrerPolicyParameters5") as BrowserFrame
        def bfReferrerPolicyCustomParameter = bfReferrerPolicyScreen.getWindow().getComponentNN("bfReferrerPolicyCustomParameter") as BrowserFrame
        def bfReferrerPolicyCombinedParameters = bfReferrerPolicyScreen.getWindow().getComponentNN("bfReferrerPolicyCombinedParameters") as BrowserFrame

        then:
        bfReferrerPolicyParameter.referrerPolicy == "no-referrer"
        bfReferrerPolicyParameters2.referrerPolicy == "same-origin strict-origin"
        bfReferrerPolicyParameters5.referrerPolicy == "no-referrer-when-downgrade origin no-referrer origin-when-cross-origin strict-origin-when-cross-origin unsafe-url"
        bfReferrerPolicyCustomParameter.referrerPolicy == "custom-parameter"
        bfReferrerPolicyCombinedParameters.referrerPolicy == "unsafe-url custom-parameter"
    }

    def "Sets sandbox attribute to BrowserFrame"() {
        showTestMainScreen()

        def bfSandboxScreen = screens.create(BrowserFrameSandboxTestScreen)
        bfSandboxScreen.show()

        when:
        def bfSandboxParameter = bfSandboxScreen.getWindow().getComponentNN("bfSandboxParameter") as BrowserFrame
        def bfSandboxParameters2 = bfSandboxScreen.getWindow().getComponentNN("bfSandboxParameters2") as BrowserFrame
        def bfSandboxParameters5 = bfSandboxScreen.getWindow().getComponentNN("bfSandboxParameters5") as BrowserFrame
        def bfSandboxCustomParameter = bfSandboxScreen.getWindow().getComponentNN("bfSandboxCustomParameter") as BrowserFrame
        def bfSandboxCombinedParameters = bfSandboxScreen.getWindow().getComponentNN("bfSandboxCombinedParameters") as BrowserFrame

        then:
        bfSandboxParameter.sandbox == ""
        bfSandboxParameters2.sandbox == "allow-same-origin allow-popups"
        bfSandboxParameters5.sandbox == "allow-popups allow-pointer-lock allow-top-navigation allow-scripts allow-presentation"
        bfSandboxCustomParameter.sandbox == "custom-parameter"
        bfSandboxCombinedParameters.sandbox == "allow-modals custom-parameter"
    }

    def "Sets srcdoc attribute to BrowserFrame"() {
        showTestMainScreen()

        def bfSrcdocScreen = screens.create(BrowserFrameSrcdocTestScreen)
        bfSrcdocScreen.show()

        when:
        def bfSrcdocHeading1 = bfSrcdocScreen.getWindow().getComponentNN("bfSrcdocHeading1") as BrowserFrame
        def bfSrcdocHeading3 = bfSrcdocScreen.getWindow().getComponentNN("bfSrcdocHeading3") as BrowserFrame
        def bfSrcdocHeading6 = bfSrcdocScreen.getWindow().getComponentNN("bfSrcdocHeading6") as BrowserFrame
        def bfSrcdocParagraph = bfSrcdocScreen.getWindow().getComponentNN("bfSrcdocParagraph") as BrowserFrame
        def bfSrcdocBold = bfSrcdocScreen.getWindow().getComponentNN("bfSrcdocBold") as BrowserFrame
        def bfSrcdocItalic = bfSrcdocScreen.getWindow().getComponentNN("bfSrcdocItalic") as BrowserFrame

        then:
        bfSrcdocHeading1.srcdoc == "<h1>Test srcdoc Heading 1</h1>"
        bfSrcdocHeading3.srcdoc == "<h3>Test srcdoc Heading 3</h3>"
        bfSrcdocHeading6.srcdoc == "<h6>Test srcdoc Heading 6</h6>"
        bfSrcdocParagraph.srcdoc == "<p>Test srcdoc Paragraph</p>"
        bfSrcdocBold.srcdoc == "<b>Test srcdoc Bold</b>"
        bfSrcdocItalic.srcdoc == "<i>Test srcdoc Italic</i>"
    }

    def "Sets srcdocFile attribute to BrowserFrame"() {
        showTestMainScreen()

        def bfSrcdocFileScreen = screens.create(BrowserFrameSrcdocFileTestScreen)
        bfSrcdocFileScreen.show()

        when:
        def bfSrcdocFileHtml = bfSrcdocFileScreen.getWindow().getComponentNN("bfSrcdocFileHtml") as BrowserFrame
        def bfSrcdocFileXml = bfSrcdocFileScreen.getWindow().getComponentNN("bfSrcdocFileXml") as BrowserFrame

        then:
        bfSrcdocFileHtml.srcdoc == "<!DOCTYPE html><html><body><h1>Test Html</h1></body></html>"
        bfSrcdocFileXml.srcdoc == "<window><heading>Test Xml</heading></window>"
    }
}
