package com.joaovsq.transito.transito_api.api.services;

import com.joaovsq.transito.transito_api.domain.model.Proprietario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietarioService {

    public Proprietario create(String nome, String email, String telefone) {

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Nome é obrigatório");
        } else if(email == null || email.equals("")) {
            throw new IllegalArgumentException("Email é obrigatório");
        } else if(telefone == null || telefone.equals("")) {
            throw new IllegalArgumentException("Telefone é obrigatório");
        }

        Proprietario proprietario = new Proprietario();

        proprietario.setId(1L);
        proprietario.setNome(nome);
        proprietario.setEmail(email);
        proprietario.setTelefone(telefone);

        return proprietario;
    }

    public List<Proprietario> list() {
        var nome = "João da Silva";
        var email = "joaoteste@teste.com";
        var telefone = "(11) 99999-9999";

        Proprietario proprietario = this.create(nome, email, telefone);

        return List.of(proprietario);
    }

}
