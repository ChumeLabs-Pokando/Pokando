package com.br.Pokando.security.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication; // <--- O IMPORT CORRETO (Spring Core)
import org.springframework.security.core.AuthenticationException; // <--- O IMPORT CORRETO (Spring Core)
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Provedor de autenticação customizado.
 * @author Prof
 */
@Component
public class PokandoAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public PokandoAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // O método getName() existe na Authentication do Spring, mas não na do Tomcat.
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        // Carrega o usuário do banco
        var userDetails = userDetailsService.loadUserByUsername(username);

        // Verifica a senha
        if (userDetails != null && passwordEncoder.matches(password, userDetails.getPassword())) {
            // Cria o token de autenticação bem-sucedida
            var auth = new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());

            // Vincula o usuário ao contexto de segurança
            SecurityContextHolder.getContext().setAuthentication(auth);

            return auth;
        } else {
            // Lança exceção do Spring Security
            throw new BadCredentialsException("Falha na autenticação: Usuário ou senha inválidos.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}