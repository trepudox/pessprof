package com.trepudox.pessprof.service;

import com.trepudox.pessprof.model.Pessoa;
import com.trepudox.pessprof.model.Profissao;

import java.util.List;

public interface PessoaService {

    List<Pessoa> findAll();

    List<Pessoa> findAllByNome(String nome);

    Pessoa findById(Long id);

    Pessoa create(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    void deleteById(Long id);

}
