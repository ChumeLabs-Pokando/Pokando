package com.br.Pokando.Mapper;


import com.br.Pokando.dto.*;
import com.br.Pokando.dto.TagCategoriaResponse;
import com.br.Pokando.dto.TagCategoriaResponse;
import com.br.Pokando.model.*;
import com.br.Pokando.model.TagCategoria;
import com.br.Pokando.model.TagCategoria;
import com.br.Pokando.model.TagCategoria;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagCategoriaMapper implements IMapper<TagCategoria, TagCategoriaResponse, TagCategoriaRequest, TagCategoriaRequest>{
    @Override
    public TagCategoriaResponse toDto(
            TagCategoria entity
    ) {
        TagCategoriaResponse dto = new TagCategoriaResponse(
                entity.getId(),
                entity.getNome()
        );
        return dto;
    }

    @Override
    public List<TagCategoriaResponse> toListDto(
            List<TagCategoria> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public TagCategoria toEntity(TagCategoriaRequest request) {
        return new TagCategoria(
                null,
                request.getNome()
        );
    }

    public TagCategoria toEntity(TagCategoriaResponse response) {
        return new TagCategoria(
                response.getId(),
                response.getNome()
        );
    }
    @Override
    public TagCategoria update(TagCategoriaRequest request, TagCategoria entity) {
        entity.setNome(request.getNome());
        return entity;
    }
    
    
}
