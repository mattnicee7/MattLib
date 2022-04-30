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

package com.github.mattnicee7.mattlib.file;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class for file operations.
 */
public class FileUtils {

    private static final FileFilter FILE_FILTER_EMPTY = file -> true;

    /**
     * Not instantiable.
     * */
    private FileUtils() {
        throw new UnsupportedOperationException("This class is not instantiable");
    }

    /**
     * It returns a list of all files in a folder, including all files in all subfolders
     *
     * @param path
     *        The path of the folder you want to get all the files from.
     *
     * @return A list of files
     */
    public static List<File> getAllFilesOfAFileFolder(@NotNull File path) {
        return getAllFilesOfAFileFolder(path, FILE_FILTER_EMPTY);
    }

    /**
     * It returns a list of all files in a folder, including all files in subfolders, that match a given filter
     *
     * @param path
     *        The path of the folder you want to get all the files from.
     *
     * @param filter
     *        The filter to be used to filter the files.
     *
     * @return A list of all files in a folder and its subfolders.
     */
    public static List<File> getAllFilesOfAFileFolder(@NotNull File path, @NotNull FileFilter filter) {
        final List<File> files = new ArrayList<>();
        final File[] filesOfFolder = path.listFiles(filter);

        for (File file : filesOfFolder) {
            if (file.isDirectory())
                files.addAll(getAllFilesOfAFileFolder(file, filter));
            else
                files.add(file);
        }

        return files;
    }

}
