package com.trepudox.pessprof.controller;

import com.trepudox.pessprof.model.Pessoa;
import com.trepudox.pessprof.presenter.OKPresenter;
import com.trepudox.pessprof.presenter.ResponsePresenter;
import com.trepudox.pessprof.service.PessoaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Page<Pessoa>> getAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll(pageable));
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findById(id));
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<Page<Pessoa>> getByNome(Pageable pageable, @PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAllByNome(pageable, nome));
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.create(pessoa));
    }

    @PostMapping(value = "/mirror", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Pessoa> mirror(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(pessoa));
    }

    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<ResponsePresenter> delete(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new OKPresenter("Pessoa deletada com sucesso."));
    }

}
