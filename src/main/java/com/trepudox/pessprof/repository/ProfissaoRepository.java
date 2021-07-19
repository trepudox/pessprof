package com.trepudox.pessprof.repository;

import com.trepudox.pessprof.model.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissaoRepository extends JpaRepository<Profissao, Long> {
    List<Profissao> findAllByNomeContainingIgnoreCase(String nome);
}
