package com.github.mattnicee7.util;

import com.sun.istack.internal.Nullable;
import lombok.val;

import java.security.SecureRandom;
import java.util.List;

public class RandomUtil {

    private static final SecureRandom RANDOM = new SecureRandom();

    private static final char[] ALPHANUMERIC_CHARS = "01234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] ALPHANUMERIC_SPECIAL_CHARS = "01234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%&*()_+=-,.;/".toCharArray();

    /**
     * Not instantiable
     */
    private RandomUtil() {

    }

    /**
     * Get a random element from a generic type list
     *
     * @param elements
     *        A generic list
     *
     * @throws IllegalArgumentException
     *          <ul type="circle">
     *              <li>If the provided {@code elements} is null or empty</li>
     *          </ul>
     * @return a random element from the list
     */
    @Nullable
    public static <T> T getRandomElement(List<T> elements) {
        if (elements == null || elements.size() < 1)
            throw new IllegalArgumentException("List can't be null or empty");

        return elements.get(RANDOM.nextInt(elements.size()));
    }

    /**
     * Get a random element from a generic array
     *
     * @param elements
     *        A generic array
     *
     * @throws IllegalArgumentException
     *         <ul type="circle">
     *             <li>If the provided {@code elements} is null or empty</li>
     *         </ul>
     *
     * @return a random element from the array
     */
    @Nullable
    public static <T> T getRandomElement(T[] elements) {
        return elements[RANDOM.nextInt(elements.length)];
    }

    /**
     * Returns a random string
     *
     * @param length
     *        Size of random string
     *
     * @throws IllegalArgumentException
     *         <ul type="circle">
     *             <li>If the provided size is 0 or below</li>
     *         </ul>
     *
     * @return a random string with the size informed
     */
    @Nullable
    public static String generateRandomString(int length) {
        if (length <= 0)
            throw new IllegalArgumentException("");

        val stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++)
            stringBuilder.append(ALPHANUMERIC_CHARS[RANDOM.nextInt(ALPHANUMERIC_CHARS.length)]);

        return stringBuilder.toString();
    }

    /**
     * Generate a random string with size informed, and if you prefer, you can use special characters
     *
     * @param length
     *        Size of random string
     * @param specialChars
     *        If you want to use the special characters in the random string
     *
     * @throws IllegalArgumentException
     *         <ul type="circle">
     *             <li>If the provided size is 0 or below</li>
     *         </ul>
     *
     * @return the random string
     */
    @Nullable
    public static String generateRandomString(int length, boolean specialChars) {
        if (length <= 0)
            throw new IllegalArgumentException("");

        if (!specialChars)
            return generateRandomString(length);

        val stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++)
            stringBuilder.append(ALPHANUMERIC_SPECIAL_CHARS[RANDOM.nextInt(ALPHANUMERIC_CHARS.length)]);

        return stringBuilder.toString();
    }

}
