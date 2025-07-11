/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author 05029689150
 */
@Entity
@Table(name = "Cargo")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    
}
