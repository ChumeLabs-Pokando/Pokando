package com.br.Pokando.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

/**
 * Configurações utilitárias para clientes HTTP.
 * * @author Prof
 */
@Configuration
public class ClientConfig {

    /**
     * Este Bean é usado pelo SocialUserService para fazer requisições HTTP,
     * como baixar a foto de perfil do Google.
     */
    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder.build();
    }

    // A configuração do 'RegisteredClientRepository' foi REMOVIDA daqui.
    // Motivo: Nós já implementamos a busca de clientes no banco de dados
    // na classe 'ClientRegistrationRepositoryImplementation'.
}