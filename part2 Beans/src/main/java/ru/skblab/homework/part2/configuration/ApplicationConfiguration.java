package ru.skblab.homework.part2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.skblab.homework.part2.model.LiveAndDeath;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Primary
@Configuration
public class ApplicationConfiguration {

    @Bean(initMethod = "birth", destroyMethod = "death")
    public LiveAndDeath liveAndDeath() {
        return new LiveAndDeath();
    }

    @Bean
    public AtomicInteger counter() {
        return new AtomicInteger(50);
    }

    @Bean
    public AtomicBoolean party() {
        return new AtomicBoolean(true);
    }



}
