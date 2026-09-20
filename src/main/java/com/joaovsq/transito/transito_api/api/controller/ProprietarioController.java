package com.joaovsq.transito.transito_api.api.controller;

import com.joaovsq.transito.transito_api.api.services.ProprietarioService;
import com.joaovsq.transito.transito_api.domain.model.Proprietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProprietarioController {

    @Autowired
    private ProprietarioService proprietarioService;

    @GetMapping("/proprietarios")
    public List<Proprietario> list() {
        try{
            return proprietarioService.list();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
