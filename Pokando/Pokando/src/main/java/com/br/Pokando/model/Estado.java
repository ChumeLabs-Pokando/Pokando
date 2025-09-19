/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author felip
 */
@Entity
@Table(name = "Estado")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", unique = true)
    private String nome;
    @Column(name = "sigla", unique = true, length = 2)
    private String sigla;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

}
