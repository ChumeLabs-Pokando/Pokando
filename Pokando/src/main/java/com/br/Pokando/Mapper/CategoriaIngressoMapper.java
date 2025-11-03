package com.br.Pokando.Mapper;

import com.br.Pokando.dto.CategoriaIngressoRequest;
import com.br.Pokando.dto.CategoriaIngressoResponse;
import com.br.Pokando.dto.IngressoResponse;
import com.br.Pokando.model.CategoriaIngresso;
import com.br.Pokando.model.Ingresso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaIngressoMapper implements IMapper<CategoriaIngresso, CategoriaIngressoResponse, CategoriaIngressoRequest, CategoriaIngressoRequest>{

    @Override
    public CategoriaIngressoResponse toDto(
            CategoriaIngresso entity
    ) {
        CategoriaIngressoResponse dto = new CategoriaIngressoResponse(
                entity.getId(),
                entity.getNome(),
                entity.getPreco(),
                entity.isMeiaEntrada()
        );
        return dto;
    }
//@Override
//public CategoriaIngressoResponse toDto(CategoriaIngresso entity) {
//    CategoriaIngressoResponse dto = new CategoriaIngressoResponse(entity.getId());
//    dto.setNome(entity.getNome());
//    dto.setPreco(entity.getPreco());
//    dto.setMeiaEntrada(entity.isMeiaEntrada());
//
//
//    return dto;
//}



    @Override
    public List<CategoriaIngressoResponse> toListDto(
            List<CategoriaIngresso> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaIngresso toEntity(CategoriaIngressoRequest request) {
        return new CategoriaIngresso(
                null,
                request.getNome(),
                request.getPreco(),
                request.isMeiaEntrada()
        );
    }

    public CategoriaIngresso toEntity(CategoriaIngressoResponse response) {
        return new CategoriaIngresso(
                response.getId(),
                response.getNome(),
                response.getPreco(),
                response.isMeiaEntrada()
        );
    }

    @Override
    public CategoriaIngresso update(CategoriaIngressoRequest request, CategoriaIngresso entity) {
       
        entity.setNome(request.getNome());
        entity.setPreco(request.getPreco());
        entity.setMeiaEntrada(request.isMeiaEntrada());
        return entity;
    }
}
