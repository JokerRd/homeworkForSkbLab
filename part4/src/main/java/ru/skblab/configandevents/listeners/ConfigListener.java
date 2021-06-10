package ru.skblab.configandevents.listeners;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.skblab.configandevents.events.ConfigEvent;


@Component
public class ConfigListener{

    @EventListener
    public void handleConfigEvent(ConfigEvent event){
        System.out.println(event.getSimpleConfig());
        event.getSender().send("+79999999999", "Call me");
    }

}
