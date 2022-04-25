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

package com.github.mattnicee7.util.chat;

import lombok.val;
import lombok.var;
import org.bukkit.ChatColor;

import java.util.regex.Pattern;

public class ChatUtils {

    private static boolean HEX_COLOR_SUPPORT;

    public static final Pattern HEX_COLOR_PATTERN = Pattern.compile("&#([0-9A-Fa-f]{6})");

    static {
        try {
            net.md_5.bungee.api.ChatColor.class.getDeclaredMethod("of", String.class);
            HEX_COLOR_SUPPORT = true;
        } catch (NoSuchMethodException e) {
            HEX_COLOR_SUPPORT = false;
        }
    }

    /**
     * It takes a string, and replaces all hex color codes with their corresponding ChatColor
     *
     * @param text
     *        The text to colorize
     *
     * @return The colored text.
     */
    public static String colorize(String text) {
        var coloredText = text;
        if (HEX_COLOR_SUPPORT) {
            val matcher = HEX_COLOR_PATTERN.matcher(coloredText);
            StringBuffer buffer = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(buffer, net.md_5.bungee.api.ChatColor.of("#" + matcher.group(1)).toString());
            }
            coloredText = matcher.appendTail(buffer).toString();
        }
        return ChatColor.translateAlternateColorCodes('&', coloredText);
    }

    public static boolean supportHexColor() {
        return HEX_COLOR_SUPPORT;
    }

}