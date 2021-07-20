package com.trepudox.pessprof.service.impl;

import com.trepudox.pessprof.exception.profissao.ProfissaoNotFoundException;
import com.trepudox.pessprof.model.Profissao;
import com.trepudox.pessprof.repository.ProfissaoRepository;
import com.trepudox.pessprof.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissaoServiceImpl implements ProfissaoService {

    @Autowired
    private ProfissaoRepository profissaoRepository;

    @Override
    public List<Profissao> findAll() {
        return null;
    }

    @Override
    public List<Profissao> findAllByNome(String nome) {
        return null;
    }

    @Override
    public Profissao findById(Long id) {
        return profissaoRepository.findById(id)
                .orElseThrow(() -> new ProfissaoNotFoundException("Nenhuma profissão foi encontrada com esse ID."));
    }

    @Override
    public Profissao create(Profissao profissao) {
        return null;
    }

    @Override
    public Profissao update(Profissao profissao) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
