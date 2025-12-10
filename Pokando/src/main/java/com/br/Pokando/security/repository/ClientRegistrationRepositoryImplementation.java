package com.br.Pokando.security.repository;

import com.br.Pokando.security.mapper.RegisteredClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Service;

/**
 * Esta classe atua como a ponte entre o Spring Security e o nosso Banco de Dados.
 * Ela busca as configurações de quem pode logar (ex: Google, GitHub) que estão salvas no banco.
 *
 * @author Prof
 */
// @Service
@RequiredArgsConstructor
public class ClientRegistrationRepositoryImplementation implements ClientRegistrationRepository {

    // 1. O "Bibliotecário" que sabe onde os livros (dados) estão guardados no banco
    private final JpaRegisteredClientRepository registeredClientRepository;

    // 2. O "Tradutor" que converte a Entidade do banco para o objeto que o Spring entende
    private final RegisteredClientMapper registeredClientMapper;

    @Override
    public ClientRegistration findByRegistrationId(String registrationId) {
        /*
         * A Lógica aqui é como um funil:
         * 1. Buscamos no banco pelo ID (ex: "google").
         * 2. O retorno é um Optional (pode existir ou não).
         * 3. Se existir (.map), usamos o tradutor (mapper) para converter.
         * 4. Se não existir (.orElse), retornamos null (o Spring entende isso como "não configurado").
         */
        return registeredClientRepository.findByRegistrationId(registrationId)
                .map(registeredClientMapper::toClientRegistration)
                .orElse(null);
    }
}