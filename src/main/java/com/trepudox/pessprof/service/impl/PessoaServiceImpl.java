package com.trepudox.pessprof.service.impl;

import com.trepudox.pessprof.model.Pessoa;
import com.trepudox.pessprof.model.Profissao;
import com.trepudox.pessprof.repository.PessoaRepository;
import com.trepudox.pessprof.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa findById(Long id) {
        return null;
    }

    @Override
    public List<Pessoa> findAllByNome(String nome) {
        return null;
    }

    @Override
    public List<Profissao> findAll() {
        return null;
    }

    @Override
    public Pessoa create(Pessoa pessoa) {
        return null;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
