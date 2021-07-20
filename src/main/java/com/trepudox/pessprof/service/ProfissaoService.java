package com.trepudox.pessprof.service;

import com.trepudox.pessprof.model.Profissao;

import java.util.List;

public interface ProfissaoService {

    List<Profissao> findAll();

    List<Profissao> findAllByNome(String nome);

    Profissao findById(Long id);

    Profissao create(Profissao profissao);

    Profissao update(Profissao profissao);

    void deleteById(Long id);

}
