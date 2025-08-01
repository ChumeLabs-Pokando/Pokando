package com.br.Pokando.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Pais")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pais {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome", unique = true)
    private String nome;
    @Column(name = "sigla", unique = true, length = 2)
    private String sigla;
}
