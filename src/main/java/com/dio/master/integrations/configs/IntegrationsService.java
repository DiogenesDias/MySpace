package com.dio.master.integrations.configs;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class IntegrationsService<T> {

    private ObjectMapper mapper;
    private HttpResponse<String> httpResponse;

    public T execute(IntegrationsParams params) {

        mapper = new ObjectMapper();
        IntegrationsRequests httpRequest = new IntegrationsRequests(params);
        IntegrationsClients httpClient = new IntegrationsClients(httpRequest.get());
        this.httpResponse = httpClient.execute();
        return null;
    }

    public Class<T> clazzResponse() {
        Type typeArgument = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];

        return (Class<T>) typeArgument;
    }

    public Class<T> clazzResponseFromList() {
        Type typeList = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];

        Type typeArgument = ((ParameterizedType) typeList)
                .getActualTypeArguments()[0];

        return (Class<T>) typeArgument;
    }

    public T requestObject() {
        try {
            return convertFromJsonToObject(
                    httpResponse.body(),
                    this.clazzResponse());
        } catch (Exception exception) {
            return null;
        }
    }

    public List<T> requestObjects() {
        return convertFromJsonToObjects(
                httpResponse.body(),
                this.clazzResponseFromList());
    }

    private List<T> convertFromJsonToObjects(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json,
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception exception) {
            return Collections.singletonList(convertFromJsonToObject(json, clazz));
        }
    }

    private T convertFromJsonToObject(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception exception) {
            return null;
        }
    }
}