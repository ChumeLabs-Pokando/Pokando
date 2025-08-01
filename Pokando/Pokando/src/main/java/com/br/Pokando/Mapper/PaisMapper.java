package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.dto.PaisRequest;
import com.br.Pokando.dto.PaisResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Pais;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaisMapper implements IMapper<Pais, PaisResponse, PaisRequest, PaisRequest>{

    @Override
    public PaisResponse toDto(
            Pais entity
    ) {
        PaisResponse dto = new PaisResponse(
                entity.getId(),
                entity.getNome(),
                entity.getSigla()
        );
        return dto;
    }

    @Override
    public List<PaisResponse> toListDto(
            List<Pais> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Pais toEntity(PaisRequest request) {
        return new Pais(
                null,
                request.getNome(),
                request.getSigla()
        );
    }

    public Pais toEntity(PaisResponse response) {
        return new Pais(
                response.getId(),
                response.getNome(),
                response.getSigla()
        );
    }

    @Override
    public Pais update(PaisRequest request, Pais entity) {
        entity.setNome(request.getNome());
        entity.setSigla(request.getSigla());
        return entity;
    }
}

