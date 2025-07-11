package com.br.Pokando.Mapper;

import com.br.Pokando.dto.Endereco_geograficoRequest;
import com.br.Pokando.dto.Endereco_geograficoResponse;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.Endereco_geografico;
import com.br.Pokando.model.Estado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Endereco_geograficoMapper implements IMapper<Endereco_geografico, Endereco_geograficoResponse, Endereco_geograficoRequest, Endereco_geograficoRequest>{

    @Override
    public Endereco_geograficoResponse toDto(
            Endereco_geografico entity
    ) {
        Endereco_geograficoResponse dto = new Endereco_geograficoResponse(
                entity.getId(),
                entity.getLatitude(),
                entity.getLongitude()
        );
        return dto;
    }

    @Override
    public List<Endereco_geograficoResponse> toListDto(
            List<Endereco_geografico> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Endereco_geografico toEntity(Endereco_geograficoRequest request) {
        return new Endereco_geografico(
                null,
                request.getLatitude(),
                request.getLongitude()
        );
    }

    public Endereco_geografico toEntity(Endereco_geograficoResponse response) {
        return new Endereco_geografico(
                response.getId(),
                response.getLatitude(),
                response.getLongitude()
        );
    }

    @Override
    public Endereco_geografico update(Endereco_geograficoRequest request, Endereco_geografico entity) {
        entity.setLatitude(request.getLatitude());
        entity.setLongitude(request.getLongitude());
        return entity;
    }
}
