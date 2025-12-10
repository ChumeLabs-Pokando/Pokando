package com.br.Pokando.security.repository;


import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.br.Pokando.model.Usuario;
import com.br.Pokando.security.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 1513003
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    // Método principal de busca
    Optional<PasswordResetToken> findByToken(String token);

    // Método para limpeza (opcional)
    void deleteByExpiryDateBefore(Instant now);

    List<PasswordResetToken> findByUser(Usuario user);

}