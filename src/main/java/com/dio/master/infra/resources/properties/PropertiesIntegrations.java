package com.dio.master.infra.resources.properties;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@Accessors(fluent = true)
public class PropertiesIntegrations {

    @Value("${property.integration.timeout.response.default}")
    private Integer propertyTimeoutResponse;

    @Value("${property.integration.timeout.connect.default}")
    private Integer propertyTimeoutConnect;
}