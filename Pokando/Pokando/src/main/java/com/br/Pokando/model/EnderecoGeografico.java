/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 *
 * @author 05029689150
 */
@Entity
@Table(name = "EnderecoGeografico")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
public class EnderecoGeografico {
    private Long id;
    private String longitude;
    private String latitude;

    
     public EnderecoGeografico() {
    }


    
    
    
}
