package com.trepudox.pessprof.controller;

import com.trepudox.pessprof.model.Pessoa;
import com.trepudox.pessprof.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
//    private PessoaService pessoaService;
    private PessoaRepository pessoaRepository;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Pessoa>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.findAll());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.findById(id).get());
    }

}
