package ru.skblab.validation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skblab.validation.models.Person;
import javax.validation.Valid;

@RestController
public class ValidationController {


    @Operation(summary = "Check validation")
    @PostMapping("/validate")
    public void validation(@Valid @RequestBody Person person){
        System.out.println(person);
    }
}
