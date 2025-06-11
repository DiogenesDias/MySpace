package com.dio.master.infra.configs.resources;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        /* messages */
        @PropertySource("classpath:integrations/messages/integration.messages"),
        @PropertySource("classpath:integrations/messages/omdb.messages"),
        /* properties */
        @PropertySource("classpath:integrations/properties/integration.properties"),
        @PropertySource("classpath:integrations/properties/omdb.properties"),
        /* security */
        @PropertySource("classpath:integrations/security/omdb.security"),
})
public class LoadRscIntegrations {
}