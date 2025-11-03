package com.br.Pokando.repository;

import com.br.Pokando.model.Pais;
import com.br.Pokando.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
