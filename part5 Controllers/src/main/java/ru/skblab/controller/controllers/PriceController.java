package ru.skblab.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.controller.model.Info;
import ru.skblab.controller.model.Price;
import java.util.Random;

/**
 * Контроллер для получения модели с ценой.
 */
@RestController
public class PriceController {

    @Operation(summary = "Send template price and get update")
    @PostMapping(value = "/price")
    public Price getPriceWithId(@RequestBody Price price){
        Random random = new Random();
        Info info = new Info(random.nextLong(), price.getInfo().getDate());
        return new Price(price.getPrice(), info);
    }
}
