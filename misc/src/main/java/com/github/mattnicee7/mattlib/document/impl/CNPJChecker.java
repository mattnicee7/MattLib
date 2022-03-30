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

/**
 * This class is responsible to check if a CNPJ is valid.
 * Attention: it does not verify if the CNPJ exists, only if it is valid, through verifications in the verification codes.
 *
 * <h2>Available formats</h2>
 * <ul type="disc">
 *     <li>xxxxxxxxxxxxxx</li>
 *     <li>xx.xxx.xxx/xxxx-xx</li>
 * </ul>
 *
 * See more about this calculation <a href="https://www.macoratti.net/alg_cnpj.htm">here</a>.
 **/
public class CNPJChecker implements DocumentChecker<String> {

    /** Pattern: 12345678901234 */
    private static final Pattern ONLY_NUMBERS_PATTERN = Pattern.compile("(\\d{14})");
    /** Pattern: 12.345.678/9012-34 */
    private static final Pattern SEPARATE_NUMBERS_PATTERN = Pattern.compile("(\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})");

    @Override
    public boolean check(@NotNull String string) {
        if (!SEPARATE_NUMBERS_PATTERN.matcher(string).matches() && !ONLY_NUMBERS_PATTERN.matcher(string).matches())
            return false;

        final List<Integer> cnpjCode = new ArrayList<>();
        final List<Integer> verificationCodes = new ArrayList<>();
        final String[] cnpjFullSplit = string.replace(".", "")
                .replace("/", "")
                .replace("-", "")
                .split("");

        for (int i = 0; i < 12; i++)
            cnpjCode.add(Integer.parseInt(cnpjFullSplit[i]));

        for (int i = 12; i < 14; i++)
            verificationCodes.add(Integer.parseInt(cnpjFullSplit[i]));

        return verificationCodesMatches(cnpjCode, verificationCodes);
    }

    /**
     * Get verification code of a cnpj by multiplier.
     *
     * @param multiplier
     *        The multiplier that you want to verify.
     *
     * @param cnpjCode
     *        The cnpj codes.
     *
     * @return The verification code.
     */
    private int getVerificationCode(int multiplier, List<Integer> cnpjCode) {
        double result = 0.0;
        int index = 0;

        for (int i = multiplier; i >= 2; i--) {
            result += cnpjCode.get(index) * i;
            index++;
        }

        for (int i = 9; i >= 2; i--) {
            result += cnpjCode.get(index) * i;
            index++;
        }

        int verificationCode = (result % 11 < 2) ? 0 : 11 - (int) Math.round(result % 11);
        cnpjCode.add(verificationCode);

        return verificationCode;
    }

    /**
     * Verify if cnpj codes matches with verification codes informed.
     *
     * @param cnpjCode
     *        The cnpj codes.
     *
     * @param verificationCodes
     *        The verification codes informed.
     *
     * @return If the verification codes matches.
     */
    private boolean verificationCodesMatches(List<Integer> cnpjCode, List<Integer> verificationCodes) {
        return getVerificationCode(5, cnpjCode) == verificationCodes.get(0) &&
                getVerificationCode(6, cnpjCode) == verificationCodes.get(1);
    }

}
