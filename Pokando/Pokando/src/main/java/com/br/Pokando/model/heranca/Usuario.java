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

import java.util.Date;
//import java.util.List;

/**
 *
 * @author 05029689150
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public abstract class Usuario implements IBaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "")
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
    private UserAcesso userAcesso;
    @Column(name = "datanascimento", nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    @Column(name = "foto", nullable = false)
    private String foto;

    public Usuario(Long id) {
        this.id = id;
    }

}
