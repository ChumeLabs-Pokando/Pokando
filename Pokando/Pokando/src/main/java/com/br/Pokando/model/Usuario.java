/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

//import com.br.Pokando.model.Evento;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
//import java.util.List;

/**
 *
 * @author 05029689150
 */
@Entity
@Table(name = "Usuario")
@Builder
@Data
@Getter
@Setter
@AllArgsConstructor
public class Usuario{
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "senha", nullable = false)
    private String senha;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_acesso_id", nullable = false)
    private User_acesso user_acesso_id;
    @Column(name = "dataNascimento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @Column(name = "foto", nullable = false)
    private String foto;


    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario() {

    }
}
