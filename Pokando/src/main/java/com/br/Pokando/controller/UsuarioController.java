package com.br.Pokando.controller;

import com.br.Pokando.Mapper.UsuarioMapper;
import com.br.Pokando.Service.UsuarioService;
import com.br.Pokando.dto.UsuarioResponse;
import com.br.Pokando.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar() {
        // 1. Busca todos os usuários do banco (Entidades)
        List<Usuario> usuarios = service.listarTodos();

        // 2. Converte para DTOs (UsuarioResponse) usando seu Mapper manual
        // Isso garante que a senha e o token não sejam enviados
        return ResponseEntity.ok(mapper.toListDto(usuarios));
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.salvar(usuario));
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> me(Authentication authentication) {
        String nome = "";
        String email = "";
        String foto = "";

        if (authentication != null) {
            // Cenário 1: Login Local (JWT)
            if (authentication.getPrincipal() instanceof Jwt jwt) {
                // O "subject" do token contém o login/email
                email = jwt.getSubject();

                // CORREÇÃO AQUI:
                // O método loadUserByUsername retorna 'UserDetails', mas nós sabemos
                // que é um 'Usuario'. Fazemos o cast (Usuario) para acessar o getNome().
                Usuario usuario = (Usuario) service.loadUserByUsername(email);

                if (usuario != null) {
                    nome = usuario.getNome();
                    // Se você tiver um campo de foto no banco, pode pegar aqui:
                    // foto = usuario.getFoto();
                }
            }
            // Cenário 2: Login Social (Google)
            else if (authentication.getPrincipal() instanceof OidcUser oidcUser) {
                nome = oidcUser.getFullName();
                email = oidcUser.getEmail();
                foto = oidcUser.getPicture();
            }
        }

        // Retorna o JSON simplificado para o topo da página no Front-end
        return ResponseEntity.ok(Map.of(
                "nome", nome != null ? nome : "Usuário",
                "email", email != null ? email : "",
                "foto", foto != null ? foto : ""
        ));
    }
}