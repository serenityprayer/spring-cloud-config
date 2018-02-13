package com.github.serenity.service;

import com.github.serenity.entity.ConfigRepository;
import com.github.serenity.repository.ConfigDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigRepositoryService {

    @Autowired
    private ConfigDbRepository configDbRepository;

    public ConfigRepository findByApplicationAndProfileAndLabel(String application, String profile, String label) {
        return configDbRepository.findFirstByApplicationAndProfileAndLabel(application, profile, label);
    }

}
