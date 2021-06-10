package ru.skblab.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * Контроллер для отображения заголовков.
 */
@RestController
public class HeadersController {

    @Operation(summary = "Get headers from request")
    @GetMapping(value = "/headers")
    public Model headers(@ApiIgnore @RequestHeader Map<String, String> headers, @ApiIgnore Model model){
        model.addAttribute("headers", headers);
        return model;
    }
}
