package com.br.Pokando.repository;

import com.br.Pokando.model.Cargo;
import com.br.Pokando.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
