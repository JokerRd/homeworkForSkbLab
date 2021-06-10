package ru.skblab.configandevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.skblab.configandevents.configuration.SimpleConfig;


@SpringBootApplication
@EnableConfigurationProperties(SimpleConfig.class)
public class ConfigAndEventsApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConfigAndEventsApplication.class, args);
    }



}

