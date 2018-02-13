package com.github.serenity.base;

import com.alibaba.fastjson.JSONObject;
import com.github.serenity.entity.ConfigProperties;
import com.github.serenity.entity.ConfigRepository;
import com.github.serenity.service.ConfigRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.util.StringUtils;

import java.util.Map;

public class DatabasesEnvironmentRepository implements EnvironmentRepository {

    private static final String defaultLabel = "master";
    @Autowired
    private ConfigRepositoryService configRepositoryService;

    @Override
    public Environment findOne(String application, String profile, String label) {
        if (StringUtils.isEmpty(application) || StringUtils.isEmpty(profile)) {
            return null;
        }
        label = StringUtils.isEmpty(label) ? defaultLabel : label;
        ConfigRepository configRepositories = configRepositoryService.findByApplicationAndProfileAndLabel(application, profile, label);
        if (configRepositories != null) {
            String[] profiles = StringUtils.commaDelimitedListToStringArray(profile);
            Environment environment = new Environment(application, profiles, label, configRepositories.getVersion(), null);
            for (ConfigProperties configProperties : configRepositories.getConfigPropertiesList()) {
                Map<String, Object> content = JSONObject.parseObject(configProperties.getContent());
                environment.add(new PropertySource(configProperties.getPropertiesName(), content));
            }
            return environment;
        }
        return new Environment(application, profile);
    }
}
