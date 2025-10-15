package com.br.Pokando.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Tag_categoria")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;

}
