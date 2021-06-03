package ru.skblav.part3.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import ru.skblav.part3.model.Counter;
import ru.skblav.part3.model.Handle;

import javax.annotation.Resource;


/**
 * Контроллер, запрос на /start - пользователь передает любую строку, класс обработчика
 * совершает какую либо обработку и возвращает результат.
 * Запрос на /count - возвращает количество обработок, от всех запросов на сервер.
 */
@RestController
public class SimpleController {

    //бин со скоупом request
    @Resource(name = "simpleHandler")
    @Lazy
    private Handle handler;

    // синглтон
    private final Counter counter;

    public SimpleController(Counter counter) {
        this.counter = counter;
    }

    /**
     * Передает входной параметр в обработчик, обработчик производит действие и возвращает результат.
     *
     * @param param - какая либо строк введенная пользователем, как входной параметр при запросе.
     *
     * @return - возвращает результат обработки входной строки.
     */
    @GetMapping("/start")
    public String getResult(@RequestParam(value = "param", defaultValue = "null") String param ) {
        System.out.println(handler.hashCode());
        return handler.handle(param);
    }

    /**
     * Метод, по запросу возварщает количество использований обработчиком.
     *
     * @return - строку с количеством использования обработчика.
     */
    @GetMapping("/count")
    public String getCount() {
        return counter.getCountHandle();
    }


}
