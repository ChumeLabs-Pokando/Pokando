package com.br.Pokando.security.repository;



import java.util.Optional;

import com.br.Pokando.security.model.RegisteredClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author 1513003
 */
// @Repository
public interface JpaRegisteredClientRepository extends JpaRepository<RegisteredClientEntity, String> {

    // Método de busca usado pelo SocialProviderService
    Optional<RegisteredClientEntity> findByRegistrationId(String registrationId);

    // Método de deleção usado pelo SocialProviderService
    void deleteByRegistrationId(String registrationId);
}