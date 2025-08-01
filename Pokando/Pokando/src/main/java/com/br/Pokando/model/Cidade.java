package com.br.Pokando.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Cidade")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome", unique = true)
    private String nome;
}
