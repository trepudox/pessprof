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
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNasc;

    @ManyToOne()
    @JsonIgnoreProperties({"pessoas"})
    private Profissao profissao;

}
