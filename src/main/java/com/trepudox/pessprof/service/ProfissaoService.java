package com.trepudox.pessprof.service;

import com.trepudox.pessprof.model.Profissao;

import java.util.List;

public interface ProfissaoService {

    Profissao findById(Long id);

    List<Profissao> findAllByNome(String nome);

    List<Profissao> findAll();

    Profissao create(Profissao profissao);

    Profissao update(Profissao profissao);

    void deleteById(Long id);

}
