package com.dio.master.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.dio.master.infra.configs.constants.StcProjectPaths.*;

public class ProjectStructureScanner {

    public static void listClazzAttributes() {
        Map<String, Map<String, List<String>>> result = retrieveClazzFields(PATH_CORE);
        printClazzFields(result);
    }

    public static void listPkgStructure(String pkgPath) {
        Map<String, Map<String, List<String>>> result = retrievePackagesClassesAndMethods(pkgPath);
        printPkgStructure(result);
    }

    public static Map<String, Map<String, List<String>>> retrievePackagesClassesAndMethods(String pathRoot) {
        Map<String, Map<String, List<String>>> result = new HashMap<>();
        Path root = Paths.get(pathRoot);

        try (Stream<Path> paths = Files.walk(root)) {

            paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(path -> {
                        try {
                            Pattern pattern = Pattern.compile("\\bpublic\\s+(?:static\\s+)?([\\w<>,\\[\\]\\s]+)\\s+(\\w+)\\s*\\(([^)]*)\\)");
                            String content = Files.readString(path);
                            Matcher matcher = pattern.matcher(content);
                            List<String> methods = new ArrayList<>();
                            while (matcher.find()) {
                                String returnType = matcher.group(1).trim().replaceAll("\\s+", " ");
                                String methodName = matcher.group(2);
                                String params = matcher.group(3).trim();

                                String methodSignature = params.isEmpty()
                                        ? String.format("%s %s()", returnType, methodName)
                                        : String.format("%s %s(%s)", returnType, methodName, params.replaceAll("\\s+", " "));

                                methods.add(methodSignature);
                            }

                            Path relativePath = root.relativize(path.getParent());
                            String packageName = relativePath.toString()
                                    .replace(FileSystems.getDefault().getSeparator(), ".");
                            if (packageName.isEmpty()) packageName = "(default)";

                            String className = path.getFileName().toString().replace(".java", "");

                            result
                                    .computeIfAbsent(packageName, k -> new HashMap<>())
                                    .put(className, methods);

                        } catch (IOException e) {
                            System.err.println(e.getMessage());
                        }
                    });

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return result;
    }

    public static Map<String, Map<String, List<String>>> retrieveClazzFields(String pathRoot) {
        Map<String, Map<String, List<String>>> result = new HashMap<>();
        Path root = Paths.get(pathRoot);

        // Regex atualizada para capturar campos com modificadores opcionais, static/final, tipo e nome
        Pattern fieldPattern = Pattern.compile(
                "\\b(private|protected|public)?\\s*" +        // modificador de acesso
                        "(static\\s*)?" +                             // static opcional
                        "(final\\s*)?" +                              // final opcional
                        "([\\w<>\\[\\]]+)\\s+" +                      // tipo do campo
                        "(\\w+)\\s*([=;])"                             // nome do campo e fim
        );

        try (Stream<Path> paths = Files.walk(root)) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".java"))
                    .forEach(path -> {
                        try {
                            String content = Files.readString(path);

                            Matcher matcher = fieldPattern.matcher(content);
                            List<String> fields = new ArrayList<>();
                            while (matcher.find()) {
                                String modifier = matcher.group(1) != null ? matcher.group(1) : "default";
                                String staticModifier = matcher.group(2) != null ? matcher.group(2).trim() : "";
                                String finalModifier = matcher.group(3) != null ? matcher.group(3).trim() : "";
                                String type = matcher.group(4).trim();
                                String name = matcher.group(5).trim();

                                String fullField = String.join(" ", List.of(
                                        modifier, staticModifier, finalModifier, type, name
                                )).replaceAll("\\s+", " ").trim();

                                fields.add(fullField);
                            }

                            if (!fields.isEmpty()) {
                                Path relativePath = root.relativize(path.getParent());
                                String packageName = relativePath.toString()
                                        .replace(FileSystems.getDefault().getSeparator(), ".");
                                if (packageName.isEmpty()) packageName = "(default)";

                                String className = path.getFileName().toString().replace(".java", "");

                                result
                                        .computeIfAbsent(packageName, k -> new HashMap<>())
                                        .put(className, fields);
                            }
                        } catch (IOException e) {
                            System.err.println(e.getMessage());
                        }
                    });

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static void printPkgStructure(Map<String, Map<String, List<String>>> structure) {
        for (String pkg : structure.keySet()) {
            System.out.println(pkg);
            Map<String, List<String>> classes = structure.get(pkg);
            for (String clazz : classes.keySet()) {
                System.out.println("\t" + clazz + ".java");
                for (String method : classes.get(clazz)) {
                    System.out.println("\t\t" + method);
                }
            }
        }
    }

    public static void printClazzFields(Map<String, Map<String, List<String>>> structure) {
        for (String pkg : structure.keySet()) {
            Map<String, List<String>> fields = structure.get(pkg);
            for (String clazz : fields.keySet()) {
                System.out.println(pkg + "." + clazz + ".java");
                for (String field : fields.get(clazz)) {
                    System.out.println("\t" + field);
                }
            }
        }
    }
}