package com.br.Pokando.dto;


import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizadorResponse extends DefaultResponse {


    private String nome;

    private String nickname;

    private String email;

    private String senha;

    private List<UserAcessoResponse> userAcessoResponse;

    private Date dataNascimento;

    private String foto;

    private String cpf;

    private String cnpj;

    private List<EventoResponse> eventoResponse;


    public OrganizadorResponse(Long id) {
        super(id);
    }


    public OrganizadorResponse(String nome, String cnpj, String cpf, String foto, Date dataNascimento, List<UserAcessoResponse> userAcessoResponse, String nickname, String senha, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.foto = foto;
        this.dataNascimento = dataNascimento;
        this.userAcessoResponse = userAcessoResponse;
        this.nickname = nickname;
        this.senha = senha;
        this.email = email;
    }
}
