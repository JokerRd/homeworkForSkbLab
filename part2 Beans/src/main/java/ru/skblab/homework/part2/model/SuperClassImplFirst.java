package ru.skblab.homework.part2.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Qualifier("first")
public class SuperClassImplFirst implements SuperClass {

    public void run() {
        System.out.println("I am first");
    }
}
