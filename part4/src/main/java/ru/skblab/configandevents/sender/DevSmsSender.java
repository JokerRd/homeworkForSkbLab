package ru.skblab.configandevents.sender;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.skblab.configandevents.api.SmsSender;

@Profile("dev")
@Component
public class DevSmsSender implements SmsSender {

    @Override
    public void send(String phoneNumber, String text) {
        System.out.println("DevSmsSender");
        System.out.printf("Sms to number: %s, with message: %s%n", phoneNumber, text);
    }
}
