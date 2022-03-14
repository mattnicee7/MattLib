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

package com.github.mattnicee7.document.util;

import com.github.mattnicee7.document.DocumentChecker;
import com.github.mattnicee7.document.impl.CNPJChecker;
import com.github.mattnicee7.document.impl.CPFChecker;

public class DocumentUtil {

    private static final DocumentChecker<String> CPF_CHECKER = new CPFChecker();
    private static final DocumentChecker<String> CNPJ_CHECKER = new CNPJChecker();

    /**
     * Not instantiable
     */
    private DocumentUtil() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

    /**
     * Format: xxx.xxx.xxx.xx
     * */
    public static boolean isCPFValid(String cpf) {
        return CPF_CHECKER.check(cpf);
    }

    /*
    * Format: xx.xxx.xxx/xxxx-xx
    * */
    public static boolean isCNPJValid(String cnpj) {
        return CNPJ_CHECKER.check(cnpj);
    }

}
