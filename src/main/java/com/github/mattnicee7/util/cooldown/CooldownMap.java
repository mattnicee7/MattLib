package com.github.mattnicee7.util.cooldown;

import com.google.common.collect.Maps;
import lombok.val;

import java.util.Map;

public class CooldownMap<T> {

    private final Map<T, Long> inCooldown = Maps.newHashMap();

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
    public void add(T key, Long time) {
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
    private String getRemainingTimeFormatted(T key) {
        val remainingTimeInMillis = getRemainingTime(key);

        return "";
    }

}
