package com.joaovsq.transito.transito_api.api.services;

import com.joaovsq.transito.transito_api.domain.model.Proprietario;
import com.joaovsq.transito.transito_api.api.exception.ProprietarioNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProprietarioService {

    private final List<Proprietario> proprietarios = new ArrayList<>();

    public Proprietario create(List<String> dados) {

        if (dados == null || dados.size() < 3) {
            throw new IllegalArgumentException("Informe nome, email e telefone");
        }

        dados.forEach(dado -> {
            if (dado == null || dado.isBlank()) {
                throw new IllegalArgumentException("Dados do proprietário não podem ser nulos ou vazios");
            }
        });

        Proprietario proprietario = new Proprietario();

        proprietario.setId(new Random().nextLong(1, 1000));
        proprietario.setNome(dados.get(0));
        proprietario.setEmail(dados.get(1));
        proprietario.setTelefone(dados.get(2));

        proprietarios.add(proprietario);
        return proprietario;
    }

    public List<Proprietario> list() {

        if (proprietarios.isEmpty()) {
            create(List.of("João da Silva", "joaoteste@teste.com", "(11) 99999-9999"));
        }

        return List.copyOf(proprietarios);
    }

    public Proprietario findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        return this.list().stream()
                .filter(proprietario -> proprietario.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProprietarioNotFoundException(id));
    }

}
