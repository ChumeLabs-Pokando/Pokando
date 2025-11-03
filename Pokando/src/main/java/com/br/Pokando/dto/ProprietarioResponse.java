package com.br.Pokando.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProprietarioResponse extends DefaultResponse {

    private String nome;

    private String nickname;

    private String email;

    private String senha;

    private List<UserAcessoResponse> userAcessoResponse;

    private Date dataNascimento;

    private String foto;

    private String cpf;

    private String cnpj;


    public ProprietarioResponse(Long id) {
        super(id);
    }



    public ProprietarioResponse(Long id, String nome, String nickname, String email, String senha, List<UserAcessoResponse> userAcessoResponse, Date dataNascimento, String foto, String cpf, String cnpj) {
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
