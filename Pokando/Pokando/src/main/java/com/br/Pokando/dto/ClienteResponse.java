package com.br.Pokando.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class ClienteResponse extends DefaultResponse{

    private String nome;

    private String nickname;

    private String email;

    private String senha;

    private List<UserAcessoResponse> userAcessoResponse;

    private Date dataNascimento;

    private String foto;

    public ClienteResponse(Long id) {
        super(id);
    }

    public ClienteResponse(String nome, String nickname, String email, String senha, List<UserAcessoResponse> userAcessoResponse, Date dataNascimento, String foto) {
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.userAcessoResponse = userAcessoResponse;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
    }
}
