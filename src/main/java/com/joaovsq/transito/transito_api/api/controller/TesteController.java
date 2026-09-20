package com.joaovsq.transito.transito_api.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public String testar() {
        return "API funcionando!";
    }

}
