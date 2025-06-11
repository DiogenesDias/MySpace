package com.dio.master.infra.configs.beans;

import com.dio.master.infra.resources.security.PropSecurityOmdb;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class RscsSecurityIntegrations implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        /**/
        try {
            RscsSecurityIntegrations.applicationContext = applicationContext;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static PropSecurityOmdb Omdb() {
        /**/
        return RscsSecurityIntegrations.applicationContext.getBean(PropSecurityOmdb.class);
    }
}