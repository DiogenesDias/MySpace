package com.dio.master.infra.resources.properties;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@Accessors(fluent = true)
public class PropertiesOmdb {

    @Value("${property.omdb.url}")
    private String propertyBaseURL;

    @Value("${property.omdb.timeout.connect}")
    private Integer propertyTimeoutConnect;

    @Value("${property.omdb.timeout.response}")
    private Integer propertyTimeoutResponse;
}