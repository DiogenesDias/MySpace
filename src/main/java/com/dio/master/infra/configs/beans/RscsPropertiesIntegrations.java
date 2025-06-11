package com.dio.master.infra.configs.beans;

import com.dio.master.infra.resources.properties.PropertiesIntegrations;
import com.dio.master.infra.resources.properties.PropertiesOmdb;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class RscsPropertiesIntegrations implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        try {
            RscsPropertiesIntegrations.applicationContext = applicationContext;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static PropertiesIntegrations Integrations() {
        /**/
        return RscsPropertiesIntegrations.applicationContext.getBean(PropertiesIntegrations.class);
    }

    public static PropertiesOmdb Omdb() {
        /**/
        return RscsPropertiesIntegrations.applicationContext.getBean(PropertiesOmdb.class);
    }
}