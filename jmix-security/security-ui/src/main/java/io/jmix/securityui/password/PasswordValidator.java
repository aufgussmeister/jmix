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

package io.jmix.securityui.password;

/**
 * Interface to be implemented by beans that validate password when it is created or changed for a user.
 *
 * @param <E> type of the user entity
 * @see #validate(PasswordValidationContext)
 */
public interface PasswordValidator<E> {

    /**
     * Validates the password for the given user.
     *
     * @param context object containing information about the user and password
     * @throws PasswordValidationException in case of validation error
     */
    void validate(PasswordValidationContext<E> context) throws PasswordValidationException;
}
