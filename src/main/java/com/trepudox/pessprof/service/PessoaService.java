package com.trepudox.pessprof.service;

import com.trepudox.pessprof.model.Pessoa;
import com.trepudox.pessprof.model.Profissao;

import java.util.List;

public interface PessoaService {

    Pessoa findById(Long id);

    List<Pessoa> findAllByNome(String nome);

    List<Profissao> findAll();

    Pessoa create(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    void deleteById(Long id);

}
