package com.trepudox.pessprof.service.impl;

import com.trepudox.pessprof.exception.InvalidFieldException;
import com.trepudox.pessprof.exception.profissao.ProfissaoNotFoundException;
import com.trepudox.pessprof.model.Profissao;
import com.trepudox.pessprof.repository.ProfissaoRepository;
import com.trepudox.pessprof.service.ProfissaoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissaoServiceImpl implements ProfissaoService {

    private ProfissaoRepository profissaoRepository;

    public ProfissaoServiceImpl(ProfissaoRepository profissaoRepository) {
        this.profissaoRepository = profissaoRepository;
    }

    @Override
    public List<Profissao> findAll() {
        List<Profissao> lista = profissaoRepository.findAll();

        if (lista.isEmpty())
            throw new ProfissaoNotFoundException("Nenhuma profissão foi encontrada.");

        return lista;
    }

    @Override
    public List<Profissao> findAllByNome(String nome) {
        List<Profissao> lista = profissaoRepository.findAllByNomeContainingIgnoreCase(nome);

        if (lista.isEmpty())
            throw new ProfissaoNotFoundException("Nenhuma profissão foi encontrada com esse nome.");

        return lista;
    }

    @Override
    public Profissao findById(Long id) {
        return profissaoRepository.findById(id)
                .orElseThrow(() -> new ProfissaoNotFoundException("Nenhuma profissão foi encontrada com esse ID."));
    }

    @Override
    public Profissao create(Profissao profissao) {
        Profissao profissaoFinal = validaCampos(profissao);

        profissaoFinal.setId(0L);
        profissaoFinal.setPessoas(List.of());

        return profissaoRepository.save(profissaoFinal);
    }

    @Override
    public Profissao update(Profissao profissao) {
        Profissao profissaoProcurada = findById(profissao.getId());

        Profissao profissaoFinal = validaCampos(profissao);

        profissaoFinal.setId(profissaoProcurada.getId());

        return profissaoRepository.save(profissaoFinal);
    }

    @Override
    public void deleteById(Long id) {
        Profissao profissao = findById(id);

        profissaoRepository.delete(profissao);
    }

    private static Profissao validaCampos(Profissao profissao) {
        String nome = profissao.getNome();
        Double salario = profissao.getSalario();

        boolean nomeInvalido = nome == null || nome.isBlank();
        boolean salarioInvalido = salario == null || salario < 0;

        if (nomeInvalido)
            throw new InvalidFieldException("Nome não pode estar vazio!");

        if (salarioInvalido)
            throw new InvalidFieldException("Salário não pode estar vazio e tem que ser maior ou igual a 0!");

        return new Profissao(null, nome, salario, null);
    }
}
