package com.br.Pokando.dto;

import com.br.Pokando.model.Status;
import com.br.Pokando.security.enumeration.SocialAuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponse {

    private String login;
    private String nome;
    private String email;
    private boolean bloqueado;
    private Status status;
    private SocialAuthProvider authProvider;

    // Lista de Strings simples (ex: "ROLE_ADMIN"), em vez de objetos complexos
    private List<String> perfis;
}