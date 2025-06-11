package com.dio.master.infra.configs.datasources;

import com.dio.master.MainApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackageClasses = {MainApplication.class},
        entityManagerFactoryRef = "projectEntityManager"
)
public class SetupDatasources {
    public SetupDatasources() {
    }

    @Bean
    @Primary
    @ConfigurationProperties(
            prefix = "datasources.main"
    )
    public DataSource projectDataSource() {
        /**/
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean projectEntityManager(EntityManagerFactoryBuilder builder, @Qualifier("projectDataSource") DataSource datasource) {
        /**/
        return builder.dataSource(datasource).packages(new Class[]{MainApplication.class}).build();
    }
}