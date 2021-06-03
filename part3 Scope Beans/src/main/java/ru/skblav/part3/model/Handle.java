package ru.skblav.part3.model;

/**
 * Интерфейс обработчика
 */
public interface Handle {

    /**
     * Метод, обрабатывающий входную строку.
     *
     * @param expression - входная строка.
     *
     * @return -  строка результата обработки.
     */
    String handle(String expression);
}
