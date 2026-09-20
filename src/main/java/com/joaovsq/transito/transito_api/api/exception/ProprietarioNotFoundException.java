package com.joaovsq.transito.transito_api.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProprietarioNotFoundException extends RuntimeException {

    public ProprietarioNotFoundException(Long id) {
        super("Proprietário não encontrado: " + id);
    }
}
