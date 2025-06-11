package com.dio.master.infra.resources.messages;

import lombok.Getter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@Accessors(fluent = true)
public class PropMessagesIntegrations {

    @Value("${message.integrations.timeout}")
    private String messageTimeoutExcedido;
}