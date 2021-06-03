package ru.skblav.part3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.skblav.part3.model.Counter;


/**
 * Класс конфигурации, для показа вытягивания из контекста бина.
 */
@Configuration
public class ConfigurationApp {


    @Bean
    public Counter counter() {
        return new Counter();
    }


}
