package com.joaovsq.transito.transito_api.api.controller;

import com.joaovsq.transito.transito_api.api.services.ProprietarioService;
import com.joaovsq.transito.transito_api.domain.model.Proprietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    private ProprietarioService proprietarioService;

    @GetMapping
    public List<Proprietario> list() {
        try{
            return proprietarioService.list();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Proprietario findById(@PathVariable Long id) {
        try {
            return proprietarioService.findById(id);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @PostMapping("/create")
    public Proprietario create(@RequestBody List<String> dados) {
        try {
            return proprietarioService.create(dados);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
