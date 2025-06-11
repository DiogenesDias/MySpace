package com.dio.master.utils;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class UtilsFiles {

    public static List<File> retrieveFiles(String path) {
        try {
            List<File> files = new ArrayList<>();
            List<File> everything = Stream.of(Objects.requireNonNull(new File(path).listFiles())).toList();

            for (File file : everything) {
                if (file.isFile()) {
                    files.add(file);
                }
                if (file.isDirectory()) {
                    files.add(file);
                    files.addAll(UtilsFiles.retrieveFiles(file.getAbsolutePath()));
                }
            }
            return files;
        } catch (Exception exception) {
            return new ArrayList<>();
        }
    }

}