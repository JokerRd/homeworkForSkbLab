package ru.skblab.aop.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AopConfiguration {

    @Getter
    @Setter
    private int maxRequest;
}
