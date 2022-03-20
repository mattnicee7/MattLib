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

import org.jetbrains.annotations.NotNull;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class EmailService {

    private final EmailCredentials emailCredentials;

    public EmailService(@NotNull EmailCredentials emailCredentials) {
        this.emailCredentials = emailCredentials;
    }

    public static EmailService of(@NotNull EmailCredentials emailCredentials) {
        return new EmailService(emailCredentials);
    }

    public void sendEmail(@NotNull String receiver, @NotNull EmailContent emailContent) {
        try {
            MimeMessage mimeMessage = emailContent.build(emailCredentials.getSession());
            mimeMessage.setFrom(new InternetAddress(emailCredentials.getEmail()));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            Transport.send(mimeMessage);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void sendEmail(@NotNull List<String> receivers, @NotNull EmailContent emailContent) {
        for (String receiver : receivers)
            sendEmail(receiver, emailContent);
    }

}
