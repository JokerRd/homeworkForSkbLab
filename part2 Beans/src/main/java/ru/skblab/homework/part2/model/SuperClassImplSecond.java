package ru.skblab.homework.part2.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("second")
public class SuperClassImplSecond implements SuperClass {
    public void run() {
        System.out.println("I am second");
    }
}
