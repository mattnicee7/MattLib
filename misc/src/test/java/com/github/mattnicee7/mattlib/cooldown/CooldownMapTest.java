package com.github.mattnicee7.mattlib.cooldown;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class CooldownMapTest {

    /**
     * Instance of the CooldownMap for String objects used in all test cases.
     */
    private CooldownMap<String> cooldownMap;

    /**
     * Set up method to initialize the CooldownMap instance before each test.
     */
    @BeforeEach
    public void setUp() {
        this.cooldownMap = CooldownMap.of(String.class);
    }

    /**
     * Tests the cooldown expiry mechanism.
     * Verifies that an object remains in cooldown for the specified duration and then is no longer in cooldown.
     *
     * @throws InterruptedException if the thread sleep is interrupted
     */
    @Test
    public void testCooldownExpiry() throws InterruptedException {
        final String key = "TestKey";
        final long cooldownTime = 2000L; // 2 seconds

        this.cooldownMap.put(key, cooldownTime);
        Thread.sleep(1000); // Wait for 1 second
        assertTrue(cooldownMap.isInCooldown(key), "Object should still be in cooldown");
        Thread.sleep(1500); // Wait additional 1.5 seconds
        assertFalse(cooldownMap.isInCooldown(key), "Object should no longer be in cooldown");
    }

    /**
     * Tests the accuracy of the getRemainingTime method.
     * Ensures that the method returns a time that is within a second of the expected remaining cooldown time.
     */
    @Test
    public void testGetRemainingTimeAccuracy() {
        final String key = "TestKey";
        final long cooldownTime = 5000L; // 5 seconds

        this.cooldownMap.put(key, cooldownTime);
        final long remainingTime = cooldownMap.getRemainingTime(key);
        assertTrue(remainingTime <= cooldownTime && remainingTime > cooldownTime - 1000,
                "Remaining time should be accurate within a second");
    }

    /**
     * Tests the functionality of updating the cooldown time of an object already in cooldown.
     * Verifies that the most recent cooldown time is applied and the old one is overridden.
     */
    @Test
    public void testPutObjectTwiceWithDifferentCooldowns() {
        final String key = "TestKey";
        this.cooldownMap.put(key, 3000L); // Put with 3 seconds cooldown
        this.cooldownMap.put(key, 5000L); // Update with 5 seconds cooldown

        assertTrue(cooldownMap.getRemainingTime(key) > 3000L,
                "Cooldown time should be updated to the new value");
    }

    /**
     * Tests the removal of an object from cooldown.
     * Verifies that an object is no longer considered to be in cooldown after it has been removed.
     */
    @Test
    public void testRemoveFromCooldown() {
        final String key = "TestKey";
        this.cooldownMap.put(key, 10000L); // 10 seconds
        this.cooldownMap.remove(key); // Remove from cooldown immediately

        assertFalse(cooldownMap.isInCooldown(key),
                "Object should not be in cooldown after being removed");
    }

    /**
     * Tests the cooldown time expiry after an object has been removed.
     * Verifies that an object is not in cooldown after the cooldown period has expired,
     * even if it was not explicitly removed from the cooldown map.
     *
     * @throws InterruptedException if the thread sleep is interrupted
     */
    @Test
    public void testCooldownTimeExpiryAfterRemoval() {
        final String key = "TestKey";
        this.cooldownMap.put(key, 1000L); // 1 second cooldown
        assertTrue(cooldownMap.isInCooldown(key), "Object should initially be in cooldown");

        try {
            TimeUnit.SECONDS.sleep(2); // Wait for cooldown to expire
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        assertFalse(cooldownMap.isInCooldown(key),
                "Object should not be in cooldown after time expires");
    }

}


