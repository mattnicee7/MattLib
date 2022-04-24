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
