package com.github.serenity.repository;

import com.github.serenity.entity.ConfigRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigDbRepository extends JpaRepository<ConfigRepository, Long> {

    ConfigRepository findFirstByApplicationAndProfileAndLabel(String application, String profile, String label);
}
