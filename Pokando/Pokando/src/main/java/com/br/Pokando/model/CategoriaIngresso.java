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
public class CategoriaIngresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "preco")
    private double preco;
    @Column(name = "meia_entrada", nullable = false)
    private boolean meiaEntrada;

}
