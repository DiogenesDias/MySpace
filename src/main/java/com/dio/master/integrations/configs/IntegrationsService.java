package com.dio.master.integrations.configs;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.http.HttpResponse;
import java.util.List;

public class IntegrationsService<T> {

    private ObjectMapper mapper;
    private HttpResponse<String> httpResponse;


    public T requestObject(IntegrationsParams params) {
        this.configureParams(params);
        try {
            return mapper.readValue(
                    httpResponse.body(),
                    this.clazzResponse());
        } catch (Exception exception) {
            return null;
        }
    }

    public List<T> requestObjects(IntegrationsParams params) {
        try {
            this.configureParams(params);
            return mapper.readValue(httpResponse.body(),
                    mapper.getTypeFactory().constructCollectionType(List.class, this.clazzResponseFromList()));
        } catch (Exception exception) {
            return null;
        }
    }

    public void configureParams(IntegrationsParams params) {
        mapper = new ObjectMapper();
        IntegrationsRequests httpRequest = new IntegrationsRequests(params);
        IntegrationsClients httpClient = new IntegrationsClients(httpRequest.get());
        this.httpResponse = httpClient.execute();
    }

    @SuppressWarnings("unchecked")
    public Class<T> clazzResponse() {
        Type typeArgument = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];

        if (typeArgument instanceof Class<?>) {
            return (Class<T>) typeArgument;
        } else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public Class<T> clazzResponseFromList() {
        Type superType = getClass().getGenericSuperclass();
        Type typeList = ((ParameterizedType) superType).getActualTypeArguments()[0];
        Type innerType = ((ParameterizedType) typeList).getActualTypeArguments()[0];

        if (innerType instanceof Class<?>) {
            return (Class<T>) innerType;
        } else {
            return null;
        }
    }
}