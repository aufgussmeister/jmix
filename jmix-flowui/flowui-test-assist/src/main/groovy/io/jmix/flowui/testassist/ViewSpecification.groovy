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

package io.jmix.flowui.testassist

import com.vaadin.flow.component.HasElement
import com.vaadin.flow.component.UI
import io.jmix.core.security.SystemAuthenticator
import io.jmix.flowui.view.View
import org.springframework.beans.factory.annotation.Autowired

class ViewSpecification extends FlowuiTestAssistSpecification {

    @Autowired
    protected SystemAuthenticator systemAuthenticator;

    @Override
    protected void setupAuthentication() {
        systemAuthenticator.begin()
    }

    @Override
    protected void removeAuthentication() {
        systemAuthenticator.end()
    }

    protected <T extends View> T navigateToView(Class<T> view) {
        def activeRouterTargetsChain = getRouterChain(view)

        activeRouterTargetsChain.get(0) as T
    }

    protected List<HasElement> getRouterChain(Class<View> viewClass) {
        viewNavigators.view(viewClass)
                .navigate()

        UI.getCurrent().getInternals().getActiveRouterTargetsChain()
    }
}
