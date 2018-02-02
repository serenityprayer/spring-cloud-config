package com.github.serenity;

import com.github.serenity.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
public class HelloController {

    @Value("${info.from}")
    private String from;

    @Autowired
    ConfigRepository configRepository;

    @GetMapping("hello")
    public String hello() {
        return "hello, I am from " + from;
    }

    @GetMapping("config")
    public String config(Integer id) {
        return configRepository.findOne(id).getValue();
    }

}
