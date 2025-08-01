package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.dto.CidadeRequest;
import com.br.Pokando.dto.CidadeResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Cidade;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CidadeMapper implements IMapper<Cidade, CidadeResponse, CidadeRequest, CidadeRequest>{

    @Override
    public CidadeResponse toDto(
            Cidade entity
    ) {
        CidadeResponse dto = new CidadeResponse(
                entity.getId(),
                entity.getNome()

        );
        return dto;
    }

    @Override
    public List<CidadeResponse> toListDto(
            List<Cidade> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Cidade toEntity(CidadeRequest request) {
        return new Cidade(
                null,
                request.getNome()

        );
    }

    public Cidade toEntity(CidadeResponse response) {
        return new Cidade(
                response.getId(),
                response.getNome()

        );
    }

    @Override
    public Cidade update(CidadeRequest request, Cidade entity) {
        entity.setNome(request.getNome());
        return entity;
    }
}

