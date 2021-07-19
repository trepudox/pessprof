package com.trepudox.pessprof.controller;

import com.trepudox.pessprof.service.ProfissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoController {

    @Autowired
    private ProfissaoService profissaoService;

}
