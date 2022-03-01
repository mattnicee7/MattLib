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

package com.github.mattnicee7.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Utility class to generate qr codes.
 */
public class QRCodeGenerator {

    /**
     * Generate a QRCode with the text you prefer.
     * Default charset: UTF-8
     *
     * @param text
     *        The text of the QRCode content.
     *
     * @param path
     *        File path to save the qr code image.
     *
     * @param height
     *        Height of the QRCode image.
     *
     * @param width
     *        Width of the QRCode image.
     */
    public static void generateQRCode(@NotNull String text, @NotNull String path, int height, int width) {
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(text.getBytes("UTF-8"),
                            "UTF-8"),
                    BarcodeFormat.QR_CODE,
                    width,
                    height
            );

            MatrixToImageWriter.writeToPath(
                    matrix,
                    path.substring(path.lastIndexOf('.') + 1),
                    new File(path).getAbsoluteFile().toPath()
            );

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Generate a QRCode with the text you prefer,
     * and with the charset you prefer.
     *
     * @param text
     *        The text of the QRCode content.
     *
     * @param path
     *        File path to save the qr code image.
     *
     * @param height
     *        Height of the QRCode image.
     *
     * @param width
     *        Width of the QRCode image.
     */
    public static void generateQRCode(@NotNull String text, @NotNull String path, @NotNull String charset, int height, int width) {
        try {
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(text.getBytes(charset),
                            charset),
                    BarcodeFormat.QR_CODE,
                    width,
                    height);

            MatrixToImageWriter.writeToPath(
                    matrix,
                    path.substring(path.lastIndexOf('.') + 1),
                    new File(path).getAbsoluteFile().toPath()
            );

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
