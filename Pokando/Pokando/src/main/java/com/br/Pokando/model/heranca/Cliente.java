/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model.heranca;

//import com.br.Pokando.model.Evento;


import com.br.Pokando.model.UserAcesso;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "senha", nullable = false)
    private String senha;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cliente_user_acesso",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "user_acesso_id")
    )
    private List<UserAcesso> userAcesso = new ArrayList<>();
    @Column(name = "datanascimento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @Column(name = "foto", nullable = false)
    private String foto;

    public Cliente(Long id) {
        this.id = id;
    }

}
