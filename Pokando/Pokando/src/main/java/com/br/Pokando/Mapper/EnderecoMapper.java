package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public class EnderecoMapper implements IMapper<Endereco, EnderecoResponse, EnderecoRequest, EnderecoRequest>{

    @Override
    public EnderecoResponse toDto(Endereco entity) {
        return new EnderecoResponse(
                entity.getLogradouro(),
                entity.getCidade(),
                entity.getNumero(),
                entity.getCep(),
                entity.getBairro(),
                entity.getComplemento()
        );
    }

    @Override
    public Endereco toEntity(EnderecoRequest request) {
        return new Endereco(null, request.getLogradouro(), request.getCidade(),
                request.getNumero(), request.getCep(), request.getBairro(), request.getComplemento());
    }

    @Override
    public Endereco update(EnderecoRequest request, Endereco entity) {
        entity.setLogradouro(request.getLogradouro());
        entity.setCidade(request.getCidade());
        entity.setNumero(request.getNumero());
        entity.setCep(request.getCep());
        entity.setBairro(request.getBairro());
        entity.setComplemento(request.getComplemento());
        return entity;
    }

    @Override
    public List<EnderecoResponse> toListDto(List<Endereco> items) {
        return items.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
    }

}

