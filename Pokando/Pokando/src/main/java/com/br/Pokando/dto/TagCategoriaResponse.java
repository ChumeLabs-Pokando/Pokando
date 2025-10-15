package com.br.Pokando.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagCategoriaResponse  extends DefaultResponse{

    private String nome;

    public TagCategoriaResponse(Long id) {
        super(id);
    }
    public TagCategoriaResponse(Long id, String nome) {
        super(id);
        this.nome = nome;
    }

}
