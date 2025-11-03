package com.br.Pokando.repository;


import com.br.Pokando.model.UserAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAcessoRepository extends JpaRepository<UserAcesso, Long> {
}
