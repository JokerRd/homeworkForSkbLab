package ru.skblav.part3.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Locale;


/**
 * Класс обработчика, живет во время запроса.
 */
@Component
@RequestScope(proxyMode = ScopedProxyMode.DEFAULT)
public class SimpleHandler implements Handle, DisposableBean {

    //следит за количеством обработок
    private final Counter counter;

    @Lookup
    public SecretMessage createSecretMessage() {
        return null;
    }


    public SimpleHandler(Counter counter) {
        this.counter = counter;
    }


    public String handle(String expression) {
        if (expression.equals("secret")) {
            return createSecretMessage().receiveSecretMessage();
        }
        System.out.println("Handling " + expression);
        counter.increment();
        return "Processing complete " + expression.toUpperCase(Locale.ROOT);
    }

    /**
     * Позволяет отследить время жизни обьекта.
     */
    @Override
    public void destroy() {
        counter.printCountHandle();
    }
}
