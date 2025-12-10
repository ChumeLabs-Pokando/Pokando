package com.br.Pokando.security.controller;

import com.br.Pokando.dto.UsuarioRegisterRequest;
import com.br.Pokando.security.dto.AuthResponse;
import com.br.Pokando.security.dto.LoginRequest;
import com.br.Pokando.security.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth") // Define a base como /auth
public class AuthenticationController {

    private final AuthService authService;

    // Endpoint para criar conta localmente
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UsuarioRegisterRequest user) {
        // O AuthService já tem o método register pronto
        String result = authService.register(user);
        return ResponseEntity.ok(result);
    }

    // Endpoint para fazer login e pegar o Token JWT
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody @Valid LoginRequest loginRequest) {

        // O AuthService já tem a lógica para validar senha e gerar token
        String jwtToken = authService.getToken(loginRequest);

        AuthResponse response = new AuthResponse(
                jwtToken,
                "Bearer",
                3600L // 1 hora
        );

        return ResponseEntity.ok(response);
    }
}