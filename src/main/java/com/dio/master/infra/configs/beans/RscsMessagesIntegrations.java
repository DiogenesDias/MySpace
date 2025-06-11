package com.dio.master.infra.configs.beans;

import com.dio.master.infra.resources.messages.PropMessagesOmdb;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class RscsMessagesIntegrations implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        try {
            RscsMessagesIntegrations.applicationContext = applicationContext;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static PropMessagesOmdb Omdb() {
        /**/
        return RscsMessagesIntegrations.applicationContext.getBean(PropMessagesOmdb.class);
    }
}