package com.trepudox.pessprof.service;

import com.trepudox.pessprof.model.Pessoa;
import com.trepudox.pessprof.model.Profissao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PessoaService {

    Page<Pessoa> findAll(Pageable pageable);

    Page<Pessoa> findAllByNome(Pageable pageable, String nome);

    Pessoa findById(Long id);

    Pessoa create(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    void deleteById(Long id);

}
