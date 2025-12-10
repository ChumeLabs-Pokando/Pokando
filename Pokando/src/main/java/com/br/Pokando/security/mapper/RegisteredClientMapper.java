package com.br.Pokando.security.mapper;

import com.br.Pokando.security.model.RegisteredClientEntity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * Mapper responsável por converter a Entidade do Banco (RegisteredClientEntity)
 * para a configuração de Cliente OAuth2 do Spring (ClientRegistration).
 * * @author Prof
 */
@Component
public class RegisteredClientMapper {

    /**
     * Converte a entidade do banco em um ClientRegistration utilizável.
     */
    public ClientRegistration toClientRegistration(RegisteredClientEntity entity) {

        // 1. Identifica o provedor (google, facebook, etc)
        String registrationId = entity.getRegistrationId();

        // 2. Obtém o builder base já com as URLs do provedor configuradas
        ClientRegistration.Builder builder = getBuilderByProvider(registrationId);

        // 3. Preenche com as credenciais do seu banco de dados
        builder
                .clientId(entity.getClientId())
                .clientSecret(entity.getClientSecret());

        // 4. Configura Métodos de Autenticação (Basic é o padrão seguro)
        // Se o banco tiver nulo, usa o padrão.
        if (entity.getClientAuthenticationMethods() != null) {
            // Pega o primeiro método da lista (ex: "client_secret_basic")
            String method = entity.getClientAuthenticationMethods().split(",")[0];
            builder.clientAuthenticationMethod(new ClientAuthenticationMethod(method));
        }

        // 5. Configura Tipo de Concessão (Authorization Code é o padrão para login social)
        if (entity.getAuthorizationGrantTypes() != null) {
            String grant = entity.getAuthorizationGrantTypes().split(",")[0];
            builder.authorizationGrantType(new AuthorizationGrantType(grant));
        }

        // 6. Configura Redirect URIs
        if (entity.getRedirectUris() != null) {
            Set<String> uris = StringUtils.commaDelimitedListToSet(entity.getRedirectUris());
            // Adiciona a primeira encontrada (o builder aceita apenas uma como template principal geralmente)
            builder.redirectUri(uris.stream().findFirst().orElse(null));
        }

        // 7. Configura Escopos (Scopes)
        if (entity.getScopes() != null) {
            Set<String> scopes = StringUtils.commaDelimitedListToSet(entity.getScopes());
            builder.scope(scopes);
        }

        // Define o nome de exibição (ex: "Google")
        builder.clientName(entity.getClientName());

        return builder.build();
    }

    /**
     * "Truque do Professor":
     * O Spring Security já tem as URLs do Google, GitHub, Facebook e Okta pré-configuradas
     * na classe CommonOAuth2Provider. Vamos usar isso para não ter que hardcodar URLs!
     */
    private ClientRegistration.Builder getBuilderByProvider(String registrationId) {
        // Normaliza para maiúsculo para tentar achar no Enum (GOOGLE, GITHUB, ETC)
        String providerKey = registrationId.toUpperCase();

        try {
            // Tenta usar as configurações padrão do Spring (Google, Facebook, GitHub, Okta)
            CommonOAuth2Provider provider = CommonOAuth2Provider.valueOf(providerKey);
            return provider.getBuilder(registrationId);
        } catch (IllegalArgumentException e) {
            // Se não for um dos "famosos", teríamos que configurar as URLs manualmente aqui.
            // Para seu caso (Google), isso vai cair no 'try' com sucesso.
            throw new IllegalArgumentException("Provedor não suportado automaticamente: " + registrationId
                    + ". Para provedores customizados, você precisa configurar as URLs authorizationUri e tokenUri manualmente neste Mapper.");
        }
    }
}