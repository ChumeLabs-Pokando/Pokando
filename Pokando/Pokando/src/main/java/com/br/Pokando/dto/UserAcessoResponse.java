package com.br.Pokando.dto;


import com.br.Pokando.model.heranca.Cliente;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAcessoResponse extends DefaultResponse{

    private String nome;

    public UserAcessoResponse(Long id) {
        super(id);
    }

    public UserAcessoResponse(Long id, String nome) {
        super(id);
        this.nome = nome;
    }

}
