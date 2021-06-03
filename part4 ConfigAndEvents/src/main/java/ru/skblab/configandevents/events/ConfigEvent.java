package ru.skblab.configandevents.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ru.skblab.configandevents.api.SmsSender;
import ru.skblab.configandevents.configuration.SimpleConfig;


public class ConfigEvent extends ApplicationEvent {

    @Getter
    private final SimpleConfig simpleConfig;

    @Getter
    private final SmsSender sender;

    public ConfigEvent(Object source,
                       SimpleConfig simpleConfig,
                       SmsSender sender) {
        super(source);
        this.simpleConfig = simpleConfig;
        this.sender = sender;
    }
}
