/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.br.Pokando.model;

import jakarta.persistence.*;
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
@AllArgsConstructor
public class Endereco {


    @Id
    @GeneratedValue
    private Long id;
     @Column(name = "logradouro", nullable = false)
    private String logradouro;
    @OneToOne(optional = false)
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;
     @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "cep", nullable = false, length = 8)
    private String cep;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "complemento", nullable = true)
    private String complemento;
    @ManyToOne(optional = false)
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
    @OneToOne(optional = false)
    @JoinColumn(name = "endereco_geografico_id", nullable = false)
    private Endereco_geografico endereco_geografico;

    public Endereco() {
    }

    public Endereco(Long id) {
        this.id = id;
    }



}
