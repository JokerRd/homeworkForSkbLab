package ru.skblab.aop.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.aop.aspects.Counter;

@RestController
public class ApiController {
    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Counter(id = "first", maxRequest = 7)
    @Operation(summary = "first api method")
    @GetMapping("/first")
    public String firstApi() {
        log.info("First Api");
        return "first";
    }

    @Counter(id = "second")
    @Operation(summary = "second api method")
    @PostMapping("/second")
    public String secondApi() {
        log.info("Second Api");
        return "second";
    }
}
