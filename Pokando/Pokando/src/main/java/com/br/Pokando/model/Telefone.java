package com.br.Pokando.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Telefone")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome")
    private String numero;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
