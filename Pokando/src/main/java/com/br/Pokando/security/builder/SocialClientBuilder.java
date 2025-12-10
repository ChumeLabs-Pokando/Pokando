package com.br.Pokando.security.builder;

import com.br.Pokando.security.dto.ProviderRegistrationRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration; // <--- Importante
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;

public class SocialClientBuilder {

    public static ClientRegistration buildClient(ProviderRegistrationRequest request, String ipServerAndPort, String contextPath) {

        // 1. Define a URL de redirecionamento (Callback)
        // O padrão do Spring Security Client é: {baseUrl}/login/oauth2/code/{registrationId}
        String redirectUri = String.format("http://%s%s/login/oauth2/code/%s",
                ipServerAndPort,
                contextPath,
                request.registrationId());

        // 2. Constrói o ClientRegistration (Usado para login com Google/Facebook)
        return ClientRegistration.withRegistrationId(request.registrationId())
                .clientId(request.clientId())
                .clientSecret(request.clientSecret())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri(redirectUri)
                .scope("openid", "profile", "email")

                // Configurações específicas do provedor (Exemplo para Google)
                // Em um cenário real, você buscaria isso do banco ou teria um switch/case
                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .clientName(request.providerName())
                .build();
    }
}