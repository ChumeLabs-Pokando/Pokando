package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoGeograficoRequest;
import com.br.Pokando.dto.EnderecoGeograficoResponse;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.EnderecoGeografico;
import com.br.Pokando.model.Estado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnderecoGeograficoMapper implements IMapper<EnderecoGeografico, EnderecoGeograficoResponse, EnderecoGeograficoRequest, EnderecoGeograficoRequest>{

    @Override
    public EnderecoGeograficoResponse toDto(
            EnderecoGeografico entity
    ) {
        EnderecoGeograficoResponse dto = new EnderecoGeograficoResponse(
                entity.getId(),
                entity.getLatitude(),
                entity.getLongitude()
        );
        return dto;
    }

    @Override
    public List<EnderecoGeograficoResponse> toListDto(
            List<EnderecoGeografico> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public EnderecoGeografico toEntity(EnderecoGeograficoRequest request) {
        return new EnderecoGeografico(
                null,
                request.getLatitude(),
                request.getLongitude()
        );
    }

    public EnderecoGeografico toEntity(EnderecoGeograficoResponse response) {
        return new EnderecoGeografico(
                response.getId(),
                response.getLatitude(),
                response.getLongitude()
        );
    }

    @Override
    public EnderecoGeografico update(EnderecoGeograficoRequest request, EnderecoGeografico entity) {
        entity.setLatitude(request.getLatitude());
        entity.setLongitude(request.getLongitude());
        return entity;
    }
}
