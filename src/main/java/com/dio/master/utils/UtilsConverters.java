package com.dio.master.utils;

import com.dio.master.infra.configs.constants.StcProjectPaths;

import java.util.Collections;
import java.util.List;

public class UtilsConverters {

    public static <T> T convertFromJsonToObject(String json, Class<T> clazz) {
        try {
            return UtilsObjects.ObjObjectMapper().readValue(json, clazz);
        } catch (Exception exception) {
            return null;
        }
    }

    public static <T> List<T> convertFromJsonToListObject(String json, Class<T> clazz) {
        try {
            return UtilsObjects.ObjObjectMapper().readValue(json,
                    UtilsObjects.ObjObjectMapper().getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception exception) {
            return Collections.singletonList(convertFromJsonToObject(json, clazz));
        }
    }

    public static String convertPckgToPath(String pckg) {
        String path = pckg.replaceAll("\\.", "/");
        path = StcProjectPaths.PATH_ROOT + path;
        return path;
    }
}