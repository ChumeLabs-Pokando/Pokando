package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Estado;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoMapper implements IMapper<Estado, EstadoResponse, EstadoRequest, EstadoRequest>{

    @Override
    public EstadoResponse toDto(
            Estado entity
    ) {
        EstadoResponse dto = new EstadoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getSigla()
        );
        return dto;
    }

    @Override
    public List<EstadoResponse> toListDto(
            List<Estado> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Estado toEntity(EstadoRequest request) {
        return new Estado(
                null,
                request.getNome(),
                request.getSigla()
        );
    }

    public Estado toEntity(EstadoResponse response) {
        return new Estado(
                response.getId(),
                response.getNome(),
                response.getSigla()
        );
    }

    @Override
    public Estado update(EstadoRequest request, Estado entity) {
        entity.setNome(request.getNome());
        entity.setSigla(request.getSigla());
        return entity;
    }
}
