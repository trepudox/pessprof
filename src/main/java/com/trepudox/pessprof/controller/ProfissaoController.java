package com.trepudox.pessprof.controller;

import com.trepudox.pessprof.model.Profissao;
import com.trepudox.pessprof.repository.ProfissaoRepository;
import com.trepudox.pessprof.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoController {

    @Autowired
//    private ProfissaoService profissaoService;
    private ProfissaoRepository profissaoRepository;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Profissao>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(profissaoRepository.findAll());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Profissao> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(profissaoRepository.findById(id).get());
    }

}
