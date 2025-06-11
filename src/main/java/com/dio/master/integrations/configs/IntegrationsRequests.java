package com.dio.master.integrations.configs;

import com.dio.master.infra.configs.beans.RscsPropertiesIntegrations;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

public class IntegrationsRequests {

    protected String baseURL;
    protected Integer resonseTimout;
    protected HttpRequest.Builder httpRequestBuilder;

    protected Map<String, String> headers;
    protected Map<String, String> pathParams;
    protected Map<String, String> queryParams;

    protected IntegrationsRequests(IntegrationsParams objParams) {
        /**/
        this.httpRequestBuilder = HttpRequest.newBuilder();
        this.baseURL = objParams.baseURL;
        this.headers = objParams.headers();
        this.pathParams = objParams.pathParams();
        this.queryParams = objParams.queryParams();
        this.resonseTimout = RscsPropertiesIntegrations.Integrations().propertyTimeoutResponse();
    }

    protected IntegrationsRequests(IntegrationsParams objParams, Integer customResponseTimeout) {
        /**/
        this.httpRequestBuilder = HttpRequest.newBuilder();
        this.baseURL = objParams.baseURL;
        this.resonseTimout = customResponseTimeout;

        this.headers = objParams.headers();
        this.pathParams = objParams.pathParams();
        this.queryParams = objParams.queryParams();
    }

    private StringBuilder setupURL() {
        /**/
        return new StringBuilder(this.baseURL);
    }

    private StringBuilder hasPathParams() {
        /**/
        StringBuilder joining = new StringBuilder();

        if (!this.pathParams.isEmpty())
            joining.append("/");

        return joining;
    }

    private StringBuilder setupPathParams() {
        /**/
        StringBuilder builderPathParams = new StringBuilder();

        if (!this.pathParams.isEmpty()) {
            builderPathParams
                    .append(pathParams.entrySet()
                            .stream()
                            .map(entry ->
                                    entry.getKey() + "/" + entry.getValue())
                            .collect(Collectors.joining("/")));
        }
        return builderPathParams;
    }

    private StringBuilder hasQueryParams() {
        /**/
        StringBuilder joining = new StringBuilder();

        if (!this.queryParams.isEmpty())
            joining.append("?");

        return joining;
    }

    private StringBuilder setupQueryParams() {
        /**/
        StringBuilder builderQueryParams = new StringBuilder();

        if (!this.queryParams.isEmpty()) {
            builderQueryParams
                    .append(queryParams.entrySet()
                            .stream()
                            .map(entry ->
                                    entry.getKey() + "=" + entry.getValue())
                            .collect(Collectors.joining("&")));
        }
        return builderQueryParams;
    }

    private void createURI() {
        /**/
        this.httpRequestBuilder
                .uri(
                        URI.create(
                                new StringBuilder()
                                        .append(this.setupURL())
                                        /**/
                                        .append(this.hasPathParams())
                                        .append(this.setupPathParams())
                                        /**/
                                        .append(this.hasQueryParams())
                                        .append(this.setupQueryParams())
                                        /**/
                                        .toString()
                        )
                );
    }

    private void setupHeaders() {
        /**/
        if (!this.headers.isEmpty()) {
            this.headers.forEach((key, value) ->
                    this.httpRequestBuilder.header(key, value));
        }
    }

    private void setupTimeout() {
        /**/
        this.httpRequestBuilder
                .timeout(Duration.ofMillis(this.resonseTimout));
    }

    public HttpRequest get() {
        /**/
        this.createURI();
        this.setupHeaders();
        this.setupTimeout();

        return this.httpRequestBuilder.build();
    }
}