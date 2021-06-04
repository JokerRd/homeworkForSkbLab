package ru.skblab.nohttpbrokerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.skblab.nohttpbrokerservice.configuration.KafkaConfiguration;

@SpringBootApplication
public class NoHttpBrokerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoHttpBrokerServiceApplication.class, args);
    }

}
