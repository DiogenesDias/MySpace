package com.dio.master.integrations.configs;

import com.dio.master.infra.configs.beans.RscsPropertiesIntegrations;
import com.dio.master.integrations.exceptions.model.IntgrConnectionException;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class IntegrationsClients {

    private Duration connectTimeout;
    private final HttpRequest httpRequest;
    private final HttpClient.Builder httpClient;

    public IntegrationsClients(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
        this.httpClient = HttpClient.newBuilder();
        this.httpClient.connectTimeout(Duration.ofMillis(RscsPropertiesIntegrations.Integrations().propertyTimeoutConnect()));
    }

    public HttpResponse<String> execute() {
        try {
            return this.httpClient
                    .build()
                    .send(this.httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception exception) {
            throw new IntgrConnectionException();
        }
    }
}