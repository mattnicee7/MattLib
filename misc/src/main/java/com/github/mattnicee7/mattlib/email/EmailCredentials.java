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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Class responsible to storage and provide access to email credentials.
 * */
@Getter(AccessLevel.PACKAGE)
public class EmailCredentials {

    private final String email;
    private final String password;
    private final EmailHostType emailHostType;

    private final Session session;

    public EmailCredentials(@NotNull String email, @NotNull String password, @NotNull EmailHostType emailHostType) {
        this.email = email;
        this.password = password;
        this.emailHostType = emailHostType;

        val properties = new Properties();
        properties.put("mail.smtp.user", email);
        properties.put("mail.smtp.host", emailHostType.getSmtp());
        properties.put("mail.smtp.port", emailHostType.getPort());
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", emailHostType.getPort());
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");

        final Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        };

        this.session = Session.getInstance(properties, authenticator);
    }

    public static EmailCredentials of(@NotNull String email, @NotNull String password, @NotNull EmailHostType emailHostType) {
        return new EmailCredentials(email, password, emailHostType);
    }

}
