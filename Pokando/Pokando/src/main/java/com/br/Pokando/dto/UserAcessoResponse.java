package com.br.Pokando.dto;


import lombok.*;


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
