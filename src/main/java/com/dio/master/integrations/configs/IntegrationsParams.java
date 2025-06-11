package com.dio.master.integrations.configs;

import org.apache.logging.log4j.util.Strings;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class IntegrationsParams {

    private final String prefixHeader;
    private final String prefixPathParams;
    private final String prefixQueryParams;

    protected String baseURL;

    public IntegrationsParams() {
        prefixHeader = "header_";
        prefixPathParams = "pathParams_";
        prefixQueryParams = "queryParams_";
        baseURL = Strings.EMPTY;
    }

    public Map<String, String> headers() {
        try {
            Map<String, String> headers = new HashMap<>();

            for (Map.Entry<String, String> field : retrieveFields().entrySet()) {
                if (field.getKey().startsWith(prefixHeader)) {
                    headers.put(
                            field.getKey().substring(prefixHeader.length()),
                            field.getValue());
                }
            }
            return headers;
        } catch (Exception exception) {
            return new HashMap<>();
        }
    }

    public Map<String, String> pathParams() {
        try {
            Map<String, String> queryParams = new HashMap<>();

            for (Map.Entry<String, String> field : retrieveFields().entrySet()) {
                if (field.getKey().startsWith(prefixPathParams)) {
                    queryParams.put(
                            field.getKey().substring(prefixPathParams.length()),
                            field.getValue());
                }
            }
            return queryParams;

        } catch (Exception exception) {
            return new HashMap<>();
        }
    }

    public Map<String, String> queryParams() {
        try {
            Map<String, String> queryParams = new HashMap<>();

            for (Map.Entry<String, String> field : retrieveFields().entrySet()) {
                if (field.getKey().startsWith(prefixQueryParams)) {
                    queryParams.put(
                            field.getKey().substring(prefixQueryParams.length()),
                            field.getValue());
                }
            }
            return queryParams;

        } catch (Exception exception) {
            return new HashMap<>();
        }
    }

    public Map<String, String> retrieveFields() {
        try {
            Map<String, String> fields = new HashMap<>();

            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(this);

                if (Objects.nonNull(value))
                    fields.put(field.getName(), value.toString());
            }
            return fields;

        } catch (Exception exception) {
            return new HashMap<>();
        }
    }
}