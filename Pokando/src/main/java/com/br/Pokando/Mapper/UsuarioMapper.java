package com.br.Pokando.Mapper;

import com.br.Pokando.dto.UsuarioResponse;
import com.br.Pokando.model.Perfil;
import com.br.Pokando.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component // <--- Transforma isso num Bean do Spring
public class UsuarioMapper {

    // Converte UM usuário
    public UsuarioResponse toDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        // Lógica manual para converter a lista de Objetos Perfil em lista de Strings
        // Ex: [Perfil(id=1, nome="ROLE_USER")] vira ["ROLE_USER"]
        List<String> perfisNomes = null;
        if (usuario.getPerfis() != null) {
            perfisNomes = usuario.getPerfis().stream()
                    .map(Perfil::getNome) // Pega apenas o nome de cada perfil
                    .collect(Collectors.toList());
        }

        // Construindo o DTO manualmente
        return UsuarioResponse.builder()
                .login(usuario.getLogin())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .bloqueado(usuario.isBloqueado())
                .status(usuario.getStatus())
                .authProvider(usuario.getAuthProvider())
                .perfis(perfisNomes) // Passamos a lista convertida
                .build();
    }

    // Converte UMA LISTA de usuários
    public List<UsuarioResponse> toListDto(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(this::toDto) // Chama o método de cima para cada item da lista
                .collect(Collectors.toList());
    }
}