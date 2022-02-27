package com.github.mattnicee7.cooldown;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

/**
 * Make a cooldown collection with this class.
 * Put your objects on cooldown whenever you want.
 *
 * <h2> Example Usage:
 *
 * <pre>
 *     {@code
 *     public static void main(String[] args) {
 *         val cooldownMap = CooldownMap.of(User.class);
 *
 *         // Do what you want with the cooldown map (...)
 *     }}</pre>
 *
 */
public class CooldownMap<T> {

    /**
     * Collection responsible for keeping objects on cooldown
     */
    private final Map<T, Long> inCooldown = new HashMap<>();

    /**
     * Get a CooldownMap from a class.
     *
     * <h2> Example Usage:
     *
     * <pre>
     *     {@code
     *     public static void main(String[] args) {
     *         val cooldownMap = CooldownMap.of(String.class);
     *
     *         cooldownMap.add("Matt", 10000L);
     *     }}</pre>
     *
     * @param clazz
     *        The generic type class you want in the cooldown map.
     *
     * @return A cooldown map with the given generic class type.
     */
    public static <T> CooldownMap<T> of(Class<T> clazz) {
        return new CooldownMap<T>();
    }

    /**
     * Add the object in the cooldown.
     *
     * @param key
     *        Object to put in cooldown.
     *
     * @param time
     *        Cooldown time in millis. (Example: 10000L = 10 Seconds).
     *
     */
    public void put(T key, Long time) {
        inCooldown.put(key, System.currentTimeMillis() + time);
    }

    /**
     * Remove the object from cooldown.
     *
     * @param key
     *        Object to remove from cooldown.
     *
     */
    private void remove(T key) {
        inCooldown.remove(key);
    }

    /**
     * Check if the object is in cooldown.
     *
     * @param key
     *        Object to check if present on cooldown.
     *
     * @return If the object is present in cooldown, true, else, false.
     *
     */
    public boolean isInCooldown(T key) {
        if (!inCooldown.containsKey(key))
            return false;

        if (inCooldown.get(key) < System.currentTimeMillis())
            remove(key);

        return inCooldown.containsKey(key);
    }

    /**
     * Get remaining cooldown time of the object.
     *
     * @param key
     *        Object to get remaining time in cooldown.
     *
     * @return Remaining time in millis.
     * */
    public long getRemainingTime(T key) {
        if (!inCooldown.containsKey(key))
            return 0L;

        return inCooldown.get(key) - System.currentTimeMillis();
    }

    /**
     * Get formatted remaining cooldown time of the object.
     *
     * @param key
     *        Object to get formatted remaining time in cooldown.
     *
     * @return A formatted string with remaining time cooldown.
     */
    @Deprecated
    private String getRemainingTimeFormatted(T key) {
        val remainingTimeInMillis = getRemainingTime(key);

        return "";
    }

}
