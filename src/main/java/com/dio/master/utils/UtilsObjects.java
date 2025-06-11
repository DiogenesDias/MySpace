package com.dio.master.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class UtilsObjects {

    private static ObjectMapper objectMapper;

    public static ObjectMapper ObjObjectMapper() {
        if (Objects.isNull(objectMapper)) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }

    public static DateTimeFormatter formatterLocaldateDefault() {
        /**/
        return DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public static DateTimeFormatter formatterLocaldatetimeServer() {
        /**/
        return DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm", Locale.ENGLISH);
    }
}