package ru.skblab.configandevents.sender;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import ru.skblab.configandevents.api.SmsSender;


@ConditionalOnExpression("not '${spring.profiles.active}'.equals('dev')")
@Component
public class ProdSmsSender implements SmsSender {
    @Override
    public void send(String phoneNumber, String text) {
        System.out.println("ProdSmsSender");
        System.out.printf("Sms to number: %s, with message: %s%n", phoneNumber, text);
    }
}
