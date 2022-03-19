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

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
public class PasswordVerifier {

    private char[] symbolsPattern = "!@#$%¨&*()-=+".toCharArray();
    private char[] lowerLettersPattern = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] upperLettersPattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private int minLength;
    private int maxLength;
    private int minSymbols;
    private int minLowerLetter;
    private int minUpperLetter;

    private boolean repeatedCharacters;
    private boolean removeBlankSpaces = true;

    public boolean verify(@NotNull String password) {
        if (removeBlankSpaces)
            password = password.replace(" ", "");

        if (!checkIfHasMinLength(password))
            return false;

        if (checkIfHasMaxLength(password))
            return false;

        if (getPatternCount(symbolsPattern, password) < minSymbols)
            return false;

        if (getPatternCount(lowerLettersPattern, password) < minLowerLetter)
            return false;

        if (getPatternCount(upperLettersPattern, password) < minUpperLetter)
            return false;

        if (repeatedCharacters && hasRepeatedCharacters(password))
            return false;

        return true;
    }

    private boolean checkIfHasMinLength(@NotNull String password) {
        return password.length() >= minLength;
    }

    private boolean checkIfHasMaxLength(@NotNull String password) {
        return maxLength > 0 && password.length() >= maxLength;
    }

    private int getPatternCount(char[] pattern, @NotNull String password) {
        return (int) password.chars().mapToObj(it -> (char) it).filter(it -> equals(it, pattern)).count();
    }

    private boolean hasRepeatedCharacters(@NotNull String password) {
        final List<Character> characters = new ArrayList<>();
        char[] passwordArray = password.toCharArray();

        for (char character : passwordArray) {
            if (characters.contains(character))
                return false;

            characters.add(character);
        }

        return false;
    }

    private boolean equals(char character, char[] array) {
        for (char element : array)
            if (element == character)
                return true;

        return false;
    }

}
