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
public class User_acesso {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome", unique = true, nullable = false)
    private String nome;
}
