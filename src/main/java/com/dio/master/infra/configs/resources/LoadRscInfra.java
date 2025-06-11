package com.dio.master.infra.configs.resources;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource({"classpath:infra/properties/swagger.properties"}),

        @PropertySource({"classpath:infra/properties/system.properties"}),
        @PropertySource({"classpath:infra/security/system.security"}),
})
public class LoadRscInfra {
}