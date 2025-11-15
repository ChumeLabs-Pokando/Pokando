/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model.heranca;

//import com.br.Pokando.model.Evento;


import com.br.Pokando.model.Evento;
import com.br.Pokando.model.UserAcesso;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario")
@DiscriminatorValue("CLIENTE")
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

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cliente_user_acesso",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "user_acesso_id")
    )
    private List<UserAcesso> userAcesso = new ArrayList<>();


    @Column(name = "data_nascimento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(nullable = false)
    private String foto;
    @ManyToMany
    private List<Evento> acessoCliente;
    @ManyToMany
    private List<Evento> acessoOrganizador;

    public Cliente(Long id) {
        this.id = id;
    }
    public Cliente(Long id, String nome, String nickname, String email,
                   String senha, List<UserAcesso> userAcesso,
                   Date dataNascimento, String foto) {
        this.id = id;
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.userAcesso = userAcesso;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
    }

}

