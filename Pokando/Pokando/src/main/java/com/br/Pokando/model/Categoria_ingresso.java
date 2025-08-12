package com.br.Pokando.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Categoria_ingresso")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria_ingresso {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "preco")
    private double preco;
    @Column(name = "meiaEntrada", nullable = false)
    private boolean meiaEntrada;

}
