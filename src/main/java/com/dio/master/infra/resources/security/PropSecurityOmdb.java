package com.dio.master.infra.resources.security;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@Accessors(fluent = true)
public class PropSecurityOmdb {

    @Value("${security.omdb.key}")
    private String keyIntegration;
}