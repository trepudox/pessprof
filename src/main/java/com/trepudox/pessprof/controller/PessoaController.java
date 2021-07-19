package com.trepudox.pessprof.controller;

import com.trepudox.pessprof.model.Pessoa;
import com.trepudox.pessprof.presenter.OKPresenter;
import com.trepudox.pessprof.presenter.ResponsePresenter;
import com.trepudox.pessprof.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Pessoa>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findById(id));
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<Pessoa>> getByNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAllByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.create(pessoa));
    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(pessoa));
    }

    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<ResponsePresenter> delete(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new OKPresenter("Pessoa deletada com sucesso"));
    }

}
