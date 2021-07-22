package com.trepudox.pessprof.service.impl;

import com.trepudox.pessprof.exception.InvalidFieldException;
import com.trepudox.pessprof.exception.pessoa.PessoaNotFoundException;
import com.trepudox.pessprof.model.Pessoa;
import com.trepudox.pessprof.model.Profissao;
import com.trepudox.pessprof.repository.PessoaRepository;
import com.trepudox.pessprof.service.PessoaService;
import com.trepudox.pessprof.service.ProfissaoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;
    private ProfissaoService profissaoService;

    public PessoaServiceImpl(PessoaRepository pessoaRepository, ProfissaoService profissaoService) {
        this.pessoaRepository = pessoaRepository;
        this.profissaoService = profissaoService;
    }

    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> lista = pessoaRepository.findAll();

        if (lista.isEmpty())
            throw new PessoaNotFoundException("Nenhuma pessoa foi encontrada.");

        return lista;
    }

    @Override
    public List<Pessoa> findAllByNome(String nome) {
        List<Pessoa> lista = pessoaRepository.findAllByNomeContainingIgnoreCase(nome);

        if (lista.isEmpty())
            throw new PessoaNotFoundException("Nenhuma pessoa foi encontrada com esse nome.");

        return lista;
    }

    @Override
    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Nenhuma pessoa foi encontrada com esse ID."));
    }

    @Override
    public Pessoa create(Pessoa pessoa) {
        Pessoa pessoaFinal = validaCampos(pessoa);

        Profissao profissao = profissaoService.findById(pessoa.getProfissao().getId());

        pessoaFinal.setId(0L);
        pessoaFinal.setProfissao(profissao);

        return pessoaRepository.save(pessoaFinal);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        Pessoa pessoaProcurada = findById(pessoa.getId());

        Pessoa pessoaFinal = validaCampos(pessoa);

        pessoaFinal.setId(pessoaProcurada.getId());
        pessoaFinal.setProfissao(pessoaProcurada.getProfissao());

        return pessoaRepository.save(pessoaFinal);
    }

    @Override
    public void deleteById(Long id) {
        Pessoa pessoa = findById(id);

        pessoaRepository.delete(pessoa);
    }

    private static Pessoa validaCampos(Pessoa pessoa) {
        String nome = pessoa.getNome();
        LocalDate dataNasc = pessoa.getDataNasc();

        boolean nomeInvalido = nome == null || nome.isBlank() || !nome.chars()
                .allMatch(c -> Character.isLetter(c) || Character.toString(c).equals(" "));
        boolean dataInvalida = dataNasc == null || dataNasc.isAfter(LocalDate.now());

        if (nomeInvalido)
            throw new InvalidFieldException("Nome deve conter apenas letras e não pode estar em branco!");

        if (dataInvalida)
            throw new InvalidFieldException("Data inválida!");

        return new Pessoa(null, nome.trim(), dataNasc, null);
    }
}
