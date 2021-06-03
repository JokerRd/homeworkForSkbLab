package ru.skblab.configandevents.api;


public interface SmsSender {
    void send(String phoneNumber, String text);
}
