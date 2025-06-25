package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Estado;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public class EstadoMapper implements IMapper<Estado, EstadoResponse, EstadoRequest, EstadoRequest>{

    @Override
    public EstadoResponse toDto(Estado entity) {
        return new EstadoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getSigla()

        );
    }

    @Override
    public Estado toEntity(EstadoRequest request) {
        return new Estado(null, request.getNome(), request.getSigla());
    }

    @Override
    public Estado update(EstadoRequest request, Estado entity) {
        entity.setNome(request.getNome());
        entity.setSigla(request.getSigla());
        return entity;
    }

    @Override
    public List<EstadoResponse> toListDto(List<Estado> items) {
        return items.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
    }
}
