/*
 * This file is part of MattLib, licensed under the MIT License.
 *
 *  Copyright (c) mattnicee7
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.github.mattnicee7.mattlib.password;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordVerifierBuilder {

    private final PasswordVerifier passwordVerifier = new PasswordVerifier();

    public PasswordVerifierBuilder symbolsPattern(char[] symbolsPattern) {
        passwordVerifier.setSymbolsPattern(symbolsPattern);
        return this;
    }

    public PasswordVerifierBuilder lowerLettersPattern(char[] lowerLettersPattern) {
        passwordVerifier.setLowerLettersPattern(lowerLettersPattern);
        return this;
    }

    public PasswordVerifierBuilder upperLettersPattern(char[] upperLettersPattern) {
        passwordVerifier.setUpperLettersPattern(upperLettersPattern);
        return this;
    }

    public PasswordVerifierBuilder minLength(int minLength) {
        passwordVerifier.setMinLength(minLength);
        return this;
    }

    public PasswordVerifierBuilder maxLength(int maxLength) {
        passwordVerifier.setMaxLength(maxLength);
        return this;
    }

    public PasswordVerifierBuilder minSymbols(int minSymbols) {
        passwordVerifier.setMinSymbols(minSymbols);
        return this;
    }

    public PasswordVerifierBuilder minLowerLetter(int minLowerLetter) {
        passwordVerifier.setMinLowerLetter(minLowerLetter);
        return this;
    }

    public PasswordVerifierBuilder minUpperLetter(int minUpperLetter) {
        passwordVerifier.setMinUpperLetter(minUpperLetter);
        return this;
    }

    public PasswordVerifierBuilder repeatedCharacters(boolean repeatedCharacters) {
        passwordVerifier.setRepeatedCharacters(repeatedCharacters);
        return this;
    }

    public PasswordVerifierBuilder removeBlankSpaces(boolean removeBlankSpaces) {
        passwordVerifier.setRemoveBlankSpaces(removeBlankSpaces);
        return this;
    }

    public PasswordVerifier build() {
        return passwordVerifier;
    }

}
