package com.github.youssfbr.cancerdemama.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaixaEtaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "faixa_i")
    private Integer faixaI;

    @Column(name = "faixa_n")
    private Integer faixaN;

    private String descricao;
}
