package com.trepudox.pessprof.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profissao")
@Data
public class Profissao {

    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double salario;

    @OneToMany()
    @JsonIgnoreProperties({"profissao"})
    private List<Pessoa> pessoas;

}
