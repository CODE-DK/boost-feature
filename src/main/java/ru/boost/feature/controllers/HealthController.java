package ru.boost.feature.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthController {

    @GetMapping("/")
    public String getHealth() {
        log.info("I'm alive!!");
        return "OK";
    }

    @GetMapping("/environment")
    public String getEnvironment() {
        log.info("Report environment");
        return System.getenv().toString();
    }
}
