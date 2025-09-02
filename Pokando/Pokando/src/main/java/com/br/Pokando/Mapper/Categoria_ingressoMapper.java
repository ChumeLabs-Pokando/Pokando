package com.br.Pokando.Mapper;

import com.br.Pokando.dto.Categoria_ingressoRequest;
import com.br.Pokando.dto.Categoria_ingressoResponse;
import com.br.Pokando.model.Categoria_ingresso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Categoria_ingressoMapper implements IMapper<Categoria_ingresso, Categoria_ingressoResponse, Categoria_ingressoRequest, Categoria_ingressoRequest>{

    @Override
    public Categoria_ingressoResponse toDto(
            Categoria_ingresso entity
    ) {
        Categoria_ingressoResponse dto = new Categoria_ingressoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getPreco(),
                entity.isMeiaEntrada()
        );
        return dto;
    }

    @Override
    public List<Categoria_ingressoResponse> toListDto(
            List<Categoria_ingresso> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Categoria_ingresso toEntity(Categoria_ingressoRequest request) {
        return new Categoria_ingresso(
                null,
                request.getNome(),
                request.getPreco(),
                request.isMeiaEntrada()
        );
    }

    public Categoria_ingresso toEntity(Categoria_ingressoResponse response) {
        return new Categoria_ingresso(
                response.getId(),
                response.getNome(),
                response.getPreco(),
                response.isMeiaEntrada()
        );
    }

    @Override
    public Categoria_ingresso update(Categoria_ingressoRequest request, Categoria_ingresso entity) {
       
        entity.setNome(request.getNome());
        entity.setPreco(request.getPreco());
        entity.setMeiaEntrada(request.isMeiaEntrada());
        return entity;
    }
}
