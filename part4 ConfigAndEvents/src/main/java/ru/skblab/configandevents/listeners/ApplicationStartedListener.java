package ru.skblab.configandevents.listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.skblab.configandevents.publisher.ConfigEventPublisher;

@Component
public class ApplicationStartedListener {

    private final ConfigEventPublisher configEventPublisher;

    public ApplicationStartedListener(ConfigEventPublisher configEventPublisher) {
        this.configEventPublisher = configEventPublisher;
    }

    @EventListener
    public void handleApplicationStarted(ApplicationStartedEvent event){
        configEventPublisher.publishCustomEvent();
    }
}
