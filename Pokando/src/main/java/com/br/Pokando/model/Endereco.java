/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.br.Pokando.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 04766167198
 */
@Entity
@Table(name = "Endereco")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue
    private Long id;
     @Column(name = "logradouro", nullable = false)
    private String logradouro;
     @Column(name = "cidade", nullable = false)
    private String cidade;
     @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "cep", nullable = false, length = 8)
    private String cep;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "complemento", nullable = true)
    private String complemento;
    
    
}
