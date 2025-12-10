package com.br.Pokando.security.model;


import com.br.Pokando.model.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author 1513003
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // O token real (e.g., UUID)
    @Column(nullable = false, unique = true)
    private String token;

    // Tempo em que o token expira (e.g., 15 minutos após a criação)
    @Column(nullable = false)
    private Instant expiryDate;

    // Relacionamento com o usuário
    @OneToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Cliente user;
}
