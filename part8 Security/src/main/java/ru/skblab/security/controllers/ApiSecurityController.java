package ru.skblab.security.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
public class ApiSecurityController {

    @GetMapping("/public/api")
    @Operation(summary = "For all", parameters = {})
    public String publicMethod() {
        return "Hello";
    }

    @RolesAllowed("ROLE_ADMIN")
    @GetMapping("/admin/api")
    @Operation(summary = "For admin", parameters = {})
    public String adminMethod(Principal user) {
        return String.format("Name: %s%n" +
                                 "Role: %s%n", user.getName(), "Admin");
    }

    @RolesAllowed("ROLE_SUPPORT")
    @GetMapping("support/api")
    @Operation(summary = "For support")
    public String  supportMethod(Principal user) {
        return String.format("Name: %s%n" +
                "Role: %s%n", user.getName(), "Support");
    }

}
