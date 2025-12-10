package com.br.Pokando.security.jwt;


import com.br.Pokando.security.dto.AuthResponse;
import com.br.Pokando.security.service.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author 1513003
 */
@Component
@RequiredArgsConstructor
public class TokenRedirectSuccessHandler implements AuthenticationSuccessHandler {

    private final AuthService autenticacaoService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {
        // 1. Gera o JWT interno (AutenticacaoService é seu gerador de token)
        var jwtToken = autenticacaoService.getToken(authentication); // Supondo que você tem o campo accessToken

        // 2. Cria a URL de redirecionamento para o Frontend, anexando o token
        // 4. Retorna o token como JSON
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_OK);

        AuthResponse tokenReponse = new AuthResponse(
                jwtToken,
                "Bearer",
                3600L // Exemplo: 1 hora
        );

        // Estrutura de resposta simples para o frontend
        String responseBody = objectMapper.writeValueAsString(tokenReponse);
        response.getWriter().write(responseBody);
    }
}