package com.br.Pokando.model;


import com.br.Pokando.model.heranca.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("PROPRIETARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proprietario extends Cliente {

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String cnpj;

    @Column(unique = true)
    private String rg;

    public Proprietario(Long id) {
        super(id);
    }

    public Proprietario(Long id, String nome, String nickname, String email, String senha,
                        List<UserAcesso> userAcesso, Date dataNascimento, String foto,
                        String cpf, String cnpj, String rg) {
        super(id, nome, nickname, email, senha, userAcesso, dataNascimento, foto);
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.rg = rg;
    }
}
