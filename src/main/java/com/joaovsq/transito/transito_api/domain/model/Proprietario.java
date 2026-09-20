package com.joaovsq.transito.transito_api.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Proprietario {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
