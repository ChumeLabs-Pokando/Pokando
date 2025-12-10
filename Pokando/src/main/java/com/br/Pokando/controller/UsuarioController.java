package com.br.Pokando.controller;

import com.br.Pokando.Service.UsuarioService;
import com.br.Pokando.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(service.salvar(usuario));
    }

    // --- NOVO MÉTODO PARA O FRONTEND ---
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> me(@AuthenticationPrincipal OidcUser principal) {
        if (principal == null) {
            return ResponseEntity.status(401).build(); // Não autenticado
        }

        // Retorna apenas o que o frontend precisa para mostrar no topo da tela
        return ResponseEntity.ok(Map.of(
                "nome", principal.getFullName(),
                "email", principal.getEmail(),
                "foto", principal.getPicture() // URL da foto do Google
        ));
    }
}