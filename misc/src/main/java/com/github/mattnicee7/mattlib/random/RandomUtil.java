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

package com.github.mattnicee7.mattlib.random;

import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

/**
 * Utility class for random things.
 */
public class RandomUtil {

    /**
     * The random instance.
     */
    private static final Random RANDOM = new Random();

    /**
     * Alphabet & Numeric characters pattern.
     */
    private static final char[] ALPHANUMERIC_CHARS = "01234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * Alphabet, Numeric & Special characters pattern.
     */
    private static final char[] ALPHANUMERIC_SPECIAL_CHARS = "01234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&*()_+=-,.;/".toCharArray();

    /**
     * Not instantiable
     */
    private RandomUtil() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

    /**
     * Get a random element from a generic type list
     *
     * @param elements
     *        A generic list
     *
     * @throws IllegalArgumentException
     *          <ul type="disc">
     *              <li>If the provided {@code elements} is empty</li>
     *          </ul>
     *
     * @return A random element from the list
     */
    public static <T> T getRandomElement(@NotNull List<T> elements) {
        if (elements.size() < 1)
            throw new IllegalArgumentException("List can't be empty");

        return elements.get(RANDOM.nextInt(elements.size()));
    }

    /**
     * Get a random element from a generic array.
     *
     * @param elements
     *        A generic array.
     *
     * @throws IllegalArgumentException
     *         <ul type="disc">
     *             <li>If the provided {@code elements} is null or empty.</li>
     *         </ul>
     *
     * @return A random element from the array.
     */
    public static <T> T getRandomElement(@NotNull T[] elements) {
        if (elements.length < 1)
            throw new IllegalArgumentException("Array can't be empty");

        return elements[RANDOM.nextInt(elements.length)];
    }

    /**
     * Checks if the percentage you entered is between the randomly generated percentage.
     *
     * @param percentage
     *        The percentage that you want to test.
     *
     * @throws IllegalArgumentException
     *         If the percentage you entered is less than 0.
     *
     * @return If the random percentage is within the one you entered
     */
    public static boolean checkPercentage(double percentage) {
        if (percentage < 0.0)
            throw new IllegalArgumentException("The percentage must be greater than 0");

        return RANDOM.nextDouble() * 100 <= percentage;
    }

    /**
     * Get a random number between two numbers
     *
     * @param min
     *        The minimum number
     *
     * @param max
     *        The maximum number
     *
     * @return A random number among those informed.
     */
    public static int getRandomNumberBetween(int min, int max) {
        int randomNumber = RANDOM.nextInt(max);

        while (randomNumber < min)
            randomNumber = RANDOM.nextInt(max);

        return randomNumber;
    }

    /**
     * Returns a random string.
     *
     * @param length
     *        Size of random string.
     *
     * @throws IllegalArgumentException
     *         <ul type="disc">
     *             <li>If the provided size is 0 or below.</li>
     *         </ul>
     *
     * @return A random string with the size informed.
     */
    public static String generateRandomString(int length) {
        if (length <= 0)
            throw new IllegalArgumentException("The size must be greater than 0");

        val stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++)
            stringBuilder.append(ALPHANUMERIC_CHARS[RANDOM.nextInt(ALPHANUMERIC_CHARS.length)]);

        return stringBuilder.toString();
    }

    /**
     * Generate a random string with size informed, and if you prefer, you can use special characters.
     *
     * @param length
     *        Size of random string.
     *
     * @param specialChars
     *        If you want to use the special characters in the random string.
     *
     * @throws IllegalArgumentException
     *         <ul type="disc">
     *             <li>If the provided size is 0 or below.</li>
     *         </ul>
     *
     * @return The random string.
     */
    public static String generateRandomString(int length, boolean specialChars) {
        if (length <= 0)
            throw new IllegalArgumentException("The size must be greater than 0");

        if (!specialChars)
            return generateRandomString(length);

        val stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++)
            stringBuilder.append(ALPHANUMERIC_SPECIAL_CHARS[RANDOM.nextInt(ALPHANUMERIC_CHARS.length)]);

        return stringBuilder.toString();
    }

}
