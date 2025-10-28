package com.br.Pokando.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

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

    private List<EventoResponse> eventoResponse;

    public ClienteResponse(Long id) {
        super(id);
    }

    public ClienteResponse(String nome, List<EventoResponse> eventoResponse, String foto, Date dataNascimento, List<UserAcessoResponse> userAcessoResponse, String senha, String email, String nickname) {
        this.nome = nome;
        this.eventoResponse = eventoResponse;
        this.foto = foto;
        this.dataNascimento = dataNascimento;
        this.userAcessoResponse = userAcessoResponse;
        this.senha = senha;
        this.email = email;
        this.nickname = nickname;
    }
}
