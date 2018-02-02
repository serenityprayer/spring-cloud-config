package com.github.serenity.repository;


import com.github.serenity.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config, Integer> {

    Config findByProperty(String property);
}