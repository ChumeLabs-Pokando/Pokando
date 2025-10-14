package com.br.Pokando.model;

import com.br.Pokando.model.heranca.Cliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "User_Acesso")
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", unique = true, nullable = false)
    private String nome;
    @ManyToMany(mappedBy = "userAcesso")
    private List<Cliente> clientes;

    public UserAcesso(Long id) {
        this.id = id;
    }

}
