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

package com.github.mattnicee7.mattlib.document.util;

import com.github.mattnicee7.mattlib.document.impl.CPFChecker;
import com.github.mattnicee7.mattlib.document.DocumentChecker;
import com.github.mattnicee7.mattlib.document.impl.CNPJChecker;

public class DocumentUtil {

    /** The CPF Checker instance. */
    private static final DocumentChecker<String> CPF_CHECKER = new CPFChecker();
    /** The CNPJ Checker instance. */
    private static final DocumentChecker<String> CNPJ_CHECKER = new CNPJChecker();

    /**
     * Not instantiable
     */
    private DocumentUtil() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

    /**
     * Return if the cpf informed is valid.
     * <p>
     * Available Formats:
     * <ul>
     *    <li>xxxxxxxxxxx</li>
     *    <li>xxx.xxx.xxx-xx</li>
     * </ul>
     *
     * @param cpf
     *        The cpf you want to know if it's valid
     *
     * @return If cpf informed is valid
     */
    public static boolean isCPFValid(String cpf) {
        return CPF_CHECKER.check(cpf);
    }

    /**
     * Return if the cnpj informed is valid.
     * <p>
     * Available Formats:
     * <ul>
     *     <li>xxxxxxxxxxxxxx</li>
     *     <li>xx.xxx.xxx/xxxx-xx</li>
     * </ul>
     *
     * @param cnpj
     *        The cnpj you want to know if it's valid
     *
     * @return If the cnpj informed is valid
     */
    public static boolean isCNPJValid(String cnpj) {
        return CNPJ_CHECKER.check(cnpj);
    }

}
