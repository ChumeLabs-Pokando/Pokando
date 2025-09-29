package com.br.Pokando.dto;


import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizadorResponse extends DefaultResponse {


    private String nome;

    private String nickname;

    private String email;

    private String senha;

    private UserAcessoResponse userAcessoResponse;

    private Date dataNascimento;

    private String foto;

    private String cpf;

    private String cnpj;


    public OrganizadorResponse(Long id) {
        super(id);
    }



    public OrganizadorResponse(Long id, String nome, String nickname, String email, String senha, UserAcessoResponse userAcessoResponse, Date dataNascimento, String foto, String cpf, String cnpj) {
        super(id);
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.userAcessoResponse = userAcessoResponse;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }
}
