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
@Table(name = "Endereco_geografico")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoGeografico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "longitude", nullable = false)
    private String longitude;
    @Column(name = "latitude", nullable = false)
    private String latitude;


    
}
