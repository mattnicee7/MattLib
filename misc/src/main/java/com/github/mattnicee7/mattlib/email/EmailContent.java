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

package com.github.mattnicee7.mattlib.email;

import lombok.Getter;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 * Class responsible to manage the email content.
 * */
@Getter
public class EmailContent {

    private final String subject;
    private String message;

    public EmailContent(@NotNull String subject, @NotNull String message) {
        this.subject = subject;
        this.message = message;
    }

    public static EmailContent of(@NotNull String subject, @NotNull String message) {
        return new EmailContent(subject, message);
    }

    /**
     * Concat message into the current message.
     *
     * @param message
     *        the message to concat.
     *
     * @return this.
     * */
    public EmailContent concat(@NotNull String message) {
        this.message += message;
        return this;
    }

    /**
     * Build message to a MimeMessage.
     *
     * @param session
     *        the session to use.
     *
     * @return the MimeMessage.
     * */
    @Nullable
    protected MimeMessage build(@NotNull Session session) {
        try {
            val mimeMessage = new MimeMessage(session);
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            return mimeMessage;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

}
