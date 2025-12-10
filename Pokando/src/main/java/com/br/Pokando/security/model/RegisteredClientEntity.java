package com.br.Pokando.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 1513003
 */
@Entity
@Table(name = "oauth2_registered_client")
@Getter
@Setter
public class RegisteredClientEntity {
    @Id
    @Column(length = 100)
    private String id; // O ID interno, gerado pelo Spring Security

    @Column(name = "client_id", unique = true, nullable = false, length = 100)
    private String clientId;

    @Column(name = "client_id_issued_at")
    private Instant clientIdIssuedAt;

    @Column(name = "client_secret", length = 200)
    private String clientSecret;

    @Column(name = "client_secret_expires_at")
    private Instant clientSecretExpiresAt;

    @Column(name = "client_name", nullable = false, length = 200)
    private String clientName;

    // Métodos de autenticação (e.g., client_secret_basic)
    @Column(name = "client_authentication_methods", length = 1000)
    private String clientAuthenticationMethods;

    // Tipos de concessão (e.g., authorization_code, client_credentials)
    @Column(name = "authorization_grant_types", length = 1000)
    private String authorizationGrantTypes;

    // URIs de redirecionamento
    @Column(name = "redirect_uris", length = 1000)
    private String redirectUris;

    // Escopos (e.g., openid, profile, email)
    @Column(name = "scopes", length = 1000)
    private String scopes;

    // Configurações adicionais (usado pelo Spring Authorization Server)
    @Column(name = "client_settings", length = 2000)
    private String clientSettings;

    // Configurações de token (usado pelo Spring Authorization Server)
    @Column(name = "token_settings", length = 2000)
    private String tokenSettings;

    // Campo customizado para o registrationId (e.g., 'facebook')
    // Usamos o campo client_name para o nome amigável
    @Column(name = "registration_id", unique = true, nullable = false, length = 100)
    private String registrationId;

    // Assumimos que a coluna 'client_name' será usada para armazenar o nome amigável
    // e 'registration_id' para o ID de registro usado no /oauth2/authorization/{id}
}