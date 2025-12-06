package com.br.Pokando.repository;

import com.br.Pokando.model.Evento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByNomeContainingIgnoreCase(String nome);
}
