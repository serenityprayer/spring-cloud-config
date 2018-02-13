package com.github.serenity.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.cloud.config.server.environment.NativeEnvironmentRepository;
import org.springframework.cloud.config.server.environment.SearchPathLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
@ConditionalOnMissingBean({EnvironmentRepository.class})
@ConditionalOnProperty("spring.cloud.config.server.databases")
public class DatabasesRepositoryConfiguration {

    @Autowired
    private ConfigurableEnvironment environment;

    // @Bean
    public SearchPathLocator searchPathLocator() {
        return new NativeEnvironmentRepository(environment);
    }

    @Bean
    public EnvironmentRepository openEnvironmentRepository() {
        return new DatabasesEnvironmentRepository();
    }
}
