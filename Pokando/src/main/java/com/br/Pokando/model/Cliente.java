/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

//import com.br.Pokando.model.Evento;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
//import java.util.List;

/**
 *
 * @author 05029689150
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "cnpj", unique = true, nullable = true)
    private String cnpj;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)  
    private String senha;

    @Column(name = "data_nascimento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(nullable = false)
    private String foto;
    @ManyToMany
    @JoinTable(
            name = "cliente_acesso_cliente_evento",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> acessoClienteEvento;
    @ManyToMany
    @JoinTable(
            name = "cliente_acesso_organizador_evento",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> acessoOrganizadorEvento;

    public Cliente(Long id) {
        this.id = id;
    }
    public Cliente(Long id, String nome, String nickname, String email,
                   String senha,
                   Date dataNascimento, String foto) {
        this.id = id;
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;

        this.dataNascimento = dataNascimento;
        this.foto = foto;
    }

}

