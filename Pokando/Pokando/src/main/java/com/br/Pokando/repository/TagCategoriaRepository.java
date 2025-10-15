package com.br.Pokando.repository;

import com.br.Pokando.model.Endereco_geografico;
import com.br.Pokando.model.TagCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagCategoriaRepository  extends JpaRepository<TagCategoria, Long> {
}
