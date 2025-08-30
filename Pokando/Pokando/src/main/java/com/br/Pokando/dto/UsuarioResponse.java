package com.br.Pokando.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
public class UsuarioResponse extends DefaultResponse{

    private String nome;

    private String nickname;

    private String email;

    private String senha;

    private User_acessoResponse user_acesso;

    private Date dataNascimento;

    private String foto;

    public UsuarioResponse(Long id) {
        super(id);
    }

    public UsuarioResponse(String nome, String nickname, String email, String senha, User_acessoResponse user_acesso, Date dataNascimento, String foto) {
        this.nome = nome;
        this.nickname = nickname;
        this.email = email;
        this.senha = senha;
        this.user_acesso = user_acesso;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
    }
}
