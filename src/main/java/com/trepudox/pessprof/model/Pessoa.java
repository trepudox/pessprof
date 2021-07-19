package com.trepudox.pessprof.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNasc;

    @ManyToOne(optional = false, targetEntity = Profissao.class)
    @JsonIgnoreProperties({"pessoas"})
    private Profissao profissao;

}
