package ru.skblav.part3.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Класс для показа "prototype" и @LookUp
 */
@Component
@Scope("prototype")
public class SecretMessage {

    public String receiveSecretMessage() {
        return "Coming soon";
    }
}
