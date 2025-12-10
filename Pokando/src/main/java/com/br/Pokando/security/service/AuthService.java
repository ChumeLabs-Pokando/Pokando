package com.br.Pokando.security.service;

import com.br.Pokando.dto.UsuarioRegisterRequest;
import com.br.Pokando.exception.UsuarioNotFoundException;
import com.br.Pokando.model.Perfil;
import com.br.Pokando.model.Status;
import com.br.Pokando.model.Usuario;
import com.br.Pokando.repository.UsuarioRepository;
import com.br.Pokando.security.adapter.TokenBlacklistRepository;
import com.br.Pokando.security.dto.LoginRequest;
import com.br.Pokando.security.model.PasswordResetToken;
import com.br.Pokando.security.repository.PasswordResetTokenRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication; // <--- O IMPORT CORRETO É ESSE
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Serviço responsável pela lógica de autenticação e geração de tokens.
 * @author Prof
 */
@Service
public class AuthService {

    private static final long EXPIRATION_TIME_MINUTES = 15;

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private TokenBlacklistRepository tokenBlacklistRepository;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    private JwtDecoder jwtDecoder;

    /**
     * Gera o token JWT a partir de uma autenticação bem-sucedida.
     * Este é o método que o TokenRedirectSuccessHandler estava tentando chamar.
     */
    public String getToken(Authentication authentication) {
        String username;

        // 1. Extrai o nome de usuário (Subject) dependendo do tipo de login
        if (authentication instanceof OAuth2AuthenticationToken) {
            // Login Social (Google, etc)
            OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
            username = oidcUser.getEmail();
        } else {
            // Login Local (Formulário)
            username = authentication.getName();
        }

        // Busca usuário no banco para pegar a chave de segurança (Token Security Key)
        var usuario = usuarioRepository.findById(username)
                .orElseThrow(UsuarioNotFoundException::new);

        String tskClaim = usuario.getTokenSecurityKey();
        if (tskClaim == null) {
            usuario.generateNewTokenSecurityKey();
            usuarioRepository.save(usuario);
            tskClaim = usuario.getTokenSecurityKey();
        }

        // Caso especial para OAuth2User genérico, se necessário
        if (authentication.getPrincipal() instanceof OAuth2User oauth2User) {
            username = (String) oauth2User.getAttributes().getOrDefault("email", username);
        }

        // 2. Cria as claims do JWT
        Instant now = Instant.now();
        long expiry = 3600L; // 1 hora

        // Coleta as roles/authorities
        String authorities = authentication.getAuthorities().stream()
                .map(scope -> scope.getAuthority())
                .collect(Collectors.joining(" "));

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("http://localhost:8080")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(username)
                .claim("scope", authorities)
                .claim("tsk", tskClaim) // Chave para invalidação de token
                .build();

        // 3. Codifica e retorna o token
        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    // Sobrecarga para login via formulário (LoginRequest)
    public String getToken(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.username(), request.password())
            );
            return getToken(authentication);
        } catch (AuthenticationException ex) {
            throw new UsuarioNotFoundException(); // Ou lançar BadCredentialsException
        }
    }

    public String register(UsuarioRegisterRequest user) {
        // Conversão manual simples para evitar dependência de Mapper complexo se não tiver
        Usuario entity = Usuario.builder()
                .login(user.getLogin())
                .nome(user.getNome())
                .email(user.getEmail())
                .senha(passwordEncoder.encode(user.getSenha()))
                .status(Status.ATIVO)
                .bloqueado(false)
                .build();

        // Adiciona perfil padrão se necessário
        Perfil perfil = new Perfil();
        perfil.setId(1L); // Assumindo ID 1 como USER
        entity.add(perfil);

        usuarioRepository.save(entity);
        return "Usuário registrado com sucesso";
    }

    public void logout(String token) {
        try {
            Jwt jwt = jwtDecoder.decode(token);
            String jti = jwt.getId();
            Instant expiration = jwt.getExpiresAt();
            if (jti != null && expiration != null) {
                tokenBlacklistRepository.blacklistToken(jti, expiration);
            }
        } catch (JwtException e) {
            // Token inválido, ignora
        }
    }

    // ... (Métodos de Reset de Senha mantidos conforme lógica original, se necessário) ...
}