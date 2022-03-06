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

package com.github.mattnicee7.sql.util;

import lombok.val;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * The PreparedStatementBuilder class is a utility class that allows you to build a prepared statement in steps
 * Credits: https://github.com/chicoferreira/screen-quests/blob/master/src/main/java/com/redescreen/quests/util/database/PreparedStatementBuilder.java
 */
public class PreparedStatementBuilder {

    private final String query;
    private final Map<Integer, Object> parameters;

    public PreparedStatementBuilder(@NotNull String query) {
        this.query = query;
        this.parameters = new HashMap<>();
    }

    public static PreparedStatementBuilder of(@NotNull String query) {
        return new PreparedStatementBuilder(query);
    }

    /**
     * This function adds a parameter to the prepared statement
     *
     * @param index The index of the parameter in the SQL statement.
     * @param value The value to bind to the parameter.
     * @return Nothing.
     */
    public PreparedStatementBuilder parameter(int index, @NotNull Object value) {
        this.parameters.put(index, value);
        return this;
    }

    /**
     * Build a prepared statement from the query and parameters
     *
     * @param connection The connection to the database.
     * @return PreparedStatement
     */
    public PreparedStatement build(@NotNull Connection connection) throws SQLException {
        val preparedStatement = connection.prepareStatement(this.query);

        for (Map.Entry<Integer, Object> entry : parameters.entrySet()) {
            preparedStatement.setObject(entry.getKey(), entry.getValue());
        }

        return preparedStatement;
    }

}
