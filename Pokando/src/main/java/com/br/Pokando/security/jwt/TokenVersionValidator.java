package com.br.Pokando.security.jwt;


import com.br.Pokando.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

/**
 *
 * @author 1513003
 */
@Component
@RequiredArgsConstructor
public class TokenVersionValidator implements OAuth2TokenValidator<Jwt> {

    private final UsuarioRepository userRepository;

    // Define o erro customizado que será retornado (401)
    private static final OAuth2Error INVALID_TOKEN_VERSION
            = new OAuth2Error("invalid_token", "O token é inválido: A senha foi alterada. Faça login novamente.", null);

    @Override
    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        String username = jwt.getSubject();
        String tokenKey = jwt.getClaimAsString("tsk"); // TSK = Token Security Key

        if (username == null || tokenKey == null) {
            return OAuth2TokenValidatorResult.failure(INVALID_TOKEN_VERSION);
        }

        // 1. Busca o usuário no banco de dados
        return userRepository.findById(username)
                .map(user -> {
                    // 2. Comparação Crítica
                    if (tokenKey.equals(user.getTokenSecurityKey())) {
                        return OAuth2TokenValidatorResult.success(); // Sucesso
                    } else {
                        return OAuth2TokenValidatorResult.failure(INVALID_TOKEN_VERSION); // Falha
                    }
                })
                // Se o usuário não existir, também falha
                .orElseGet(() -> OAuth2TokenValidatorResult.failure(INVALID_TOKEN_VERSION));
    }
}