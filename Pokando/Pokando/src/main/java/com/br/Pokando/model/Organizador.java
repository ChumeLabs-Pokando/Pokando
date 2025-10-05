package com.br.Pokando.model;


import com.br.Pokando.model.heranca.Cliente;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "Organizador")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ORGANIZADOR")
public class Organizador extends Cliente {

    @Column(name = "cpf", unique = true)
    private String cpf;
    @Column(name = "cnpj", unique = true)
    private String cnpj;
    @Column(name = "rg", unique = true)
    private String rg;

    public Organizador(Long id) {
        super(id);

    }

    public Organizador(Long id, String nome, String nickname, String email, String senha, List<UserAcesso> userAcesso, Date dataNascimento, String foto, String cpf, String cnpj, String rg) {
        super(id, nome, nickname, email, senha, userAcesso, dataNascimento, foto);
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.rg = rg;
    }
}
