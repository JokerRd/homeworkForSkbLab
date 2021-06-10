package ru.skblab.configandevents.publisher;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import ru.skblab.configandevents.api.SmsSender;
import ru.skblab.configandevents.configuration.SimpleConfig;
import ru.skblab.configandevents.events.ConfigEvent;

@Component
public class ConfigEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final SimpleConfig config;
    private final SmsSender sender;

    public ConfigEventPublisher(ApplicationEventPublisher applicationEventPublisher,
                                SimpleConfig config,
                                SmsSender sender) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.config = config;
        this.sender = sender;
    }

    public void publishCustomEvent() {
        ConfigEvent configEvent = new ConfigEvent(this, config, sender);
        applicationEventPublisher.publishEvent(configEvent);
    }

}
