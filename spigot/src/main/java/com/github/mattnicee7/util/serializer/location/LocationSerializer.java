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

package com.github.mattnicee7.util.serializer.location;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;

/**
 * This class is a util class to serialize Bukkit Locations.
 */
public class LocationSerializer {

    private static final String DEFAULT_SEPARATOR = ";";

    /**
     * Not instantiable.
     * */
    private LocationSerializer() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

    public static String serialize(@NotNull Location location) {
        return serialize(location, DEFAULT_SEPARATOR);
    }

    public static String serialize(@NotNull Location location, @NotNull String separator) {
        return location.getWorld().getName() + separator +
                location.getX() + separator +
                location.getY() + separator +
                location.getZ() + separator +
                location.getYaw() + separator +
                location.getPitch();
    }

    public static Location deserialize(@NotNull String serialized) {
        return deserialize(serialized, DEFAULT_SEPARATOR);
    }

    public static Location deserialize(@NotNull String serialized, @NotNull String separator) {
        String[] split = serialized.split(separator);

        if (split.length != 6)
            throw new IllegalArgumentException(
                    String.format("Serialized location must be in the format of world%sx%sy%sz%syaw%spitch", separator, separator, separator, separator, separator)
            );

        return new Location(
                Bukkit.getWorld(split[0]),
                Double.parseDouble(split[1]),
                Double.parseDouble(split[2]),
                Double.parseDouble(split[3]),
                Float.parseFloat(split[4]),
                Float.parseFloat(split[5])
        );
    }

}
