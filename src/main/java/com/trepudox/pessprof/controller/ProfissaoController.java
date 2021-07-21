package com.trepudox.pessprof.controller;

import com.trepudox.pessprof.model.Profissao;
import com.trepudox.pessprof.presenter.OKPresenter;
import com.trepudox.pessprof.presenter.ResponsePresenter;
import com.trepudox.pessprof.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoController {

    @Autowired
    private ProfissaoService profissaoService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Profissao>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(profissaoService.findAll());
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Profissao> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(profissaoService.findById(id));
    }

    @GetMapping(path = "/nome/{nome}")
    public ResponseEntity<List<Profissao>> getByNome(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(profissaoService.findAllByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Profissao> create(@RequestBody Profissao profissao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(profissaoService.create(profissao));
    }

    @PostMapping(value = "/mirror", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Profissao> mirror(@RequestBody Profissao profissao) {
        return ResponseEntity.status(HttpStatus.OK).body(profissao);
    }

    @PutMapping
    public ResponseEntity<Profissao> update(@RequestBody Profissao profissao) {
        return ResponseEntity.status(HttpStatus.OK).body(profissaoService.update(profissao));
    }

    @DeleteMapping(path = "/id/{id}")
    public ResponseEntity<ResponsePresenter> delete(@PathVariable Long id) {
        profissaoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new OKPresenter("Profissão deletada com sucesso"));
    }

}
