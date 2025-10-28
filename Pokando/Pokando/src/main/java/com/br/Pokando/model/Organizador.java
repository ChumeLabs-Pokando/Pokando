package com.br.Pokando.model;


import com.br.Pokando.model.heranca.Cliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("ORGANIZADOR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organizador extends Cliente {

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @Column(name = "rg", unique = true)
    private String rg;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "organizador_evento",
            joinColumns = @JoinColumn(name = "organizador_id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private List<Evento> evento = new ArrayList<>();

    public Organizador(Long id) {
        super(id);
    }

    public Organizador(Long id, String nome, String nickname, String email, String senha,
                       List<UserAcesso> userAcesso, Date dataNascimento, String foto,
                       List<Evento> evento, String cpf, String cnpj, String rg) {
        super(id, nome, nickname, email, senha, userAcesso, dataNascimento, foto);
        this.evento = evento;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.rg = rg;
    }
}
