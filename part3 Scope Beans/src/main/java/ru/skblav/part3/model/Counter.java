package ru.skblav.part3.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс ведения количества обработок.
 */
public class Counter {

    //cчетчик обработок
    private AtomicInteger countHandle;


    public Counter() {
        countHandle = new AtomicInteger();
    }


    /**
     * метод увеличивающий счетчик на единицу.
     */
    public void increment() {
        countHandle.incrementAndGet();
    }

    /**
     * Метод используется при "смерти" бина обработки
     */
    public void printCountHandle() {
        System.out.println("Count call handler: " + countHandle.get());
    }

    /**
     * Метод, для возврата количества обработок.
     *
     * @return - строка с количеством обработок.
     */
    public String getCountHandle() {
        return "Count call handler: " + countHandle.get();
    }
}
