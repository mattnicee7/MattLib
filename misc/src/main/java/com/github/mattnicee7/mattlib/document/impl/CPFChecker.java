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

package com.github.mattnicee7.mattlib.document.impl;

import com.github.mattnicee7.mattlib.document.DocumentChecker;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CPFChecker implements DocumentChecker<String> {

    /* Pattern: 12345678901 */
    private final Pattern ONLY_NUMBERS_PATTERN = Pattern.compile("(\\d{11})");
    /* Pattern: 123.456.789-01 */
    private final Pattern SEPARATE_NUMBERS_PATTERN = Pattern.compile("(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})");

    @Override
    public boolean check(@NotNull String string) {
        if (!ONLY_NUMBERS_PATTERN.matcher(string).matches() && !SEPARATE_NUMBERS_PATTERN.matcher(string).matches())
            return false;

        final List<Integer> verificationCodes = new ArrayList<>();
        final List<Integer> cpfCode = new ArrayList<>();
        final String[] cpfFullSplit = string.replace("-", "")
                .replace(".", "")
                .split("");

        for (int i = 0; i < 9; i++) {
            cpfCode.add(Integer.parseInt(cpfFullSplit[i]));
        }

        for (int i = 9; i < 11; i++) {
            verificationCodes.add(Integer.parseInt(cpfFullSplit[i]));
        }

        return getVerificationCode(10, cpfCode) == verificationCodes.get(0) &&
                getVerificationCode(11, cpfCode) == verificationCodes.get(1);
    }

    private int getVerificationCode(int multiplier, List<Integer> cpfCode) {
        double result = 0.0;
        for (Integer code : cpfCode) {
            result += (code * multiplier--);
        }

        int verificationCode = (result % 11 < 2) ? 0 : (int) Math.round(11 - (result % 11));
        cpfCode.add(verificationCode);

        return verificationCode;
    }

}
