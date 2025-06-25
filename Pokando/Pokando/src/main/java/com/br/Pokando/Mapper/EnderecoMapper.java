package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.repository.EstadoRepository;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public class EnderecoMapper implements IMapper<Endereco, EnderecoResponse, EnderecoRequest, EnderecoRequest>{

    private final EstadoMapper estadoMapper;

    public EnderecoMapper(EstadoMapper estadoMapper) {
        this.estadoMapper = estadoMapper;

    }


    @Override
    public EnderecoResponse toDto(Endereco entity) {

        EnderecoResponse dto = new EnderecoResponse(
                entity.getId()
        );
        dto.setLogradouro(entity.getLogradouro());
        dto.setCidade(entity.getCidade());
        dto.setNumero(entity.getNumero());
        dto.setCep(entity.getCep());
        dto.setBairro(entity.getBairro());
        dto.setComplemento(entity.getComplemento());


        if (entity.getEstado() != null) {
            dto.setEstado(estadoMapper.toDto(entity.getEstado()));
        }
        return dto;
    }


    public Endereco toEntity(EnderecoRequest dto,
                             EstadoRepository estadoRepository

    ) {
        var entity = new Endereco();
        entity.setLogradouro(dto.getLogradouro());
        entity.setCidade(dto.getCidade());
        entity.setNumero(dto.getNumero());
        entity.setCep(dto.getCep());
        entity.setBairro(dto.getBairro());
        entity.setComplemento(dto.getComplemento());

        if (dto.getEstado() != null) {
            var estado = estadoRepository
                    .findById(dto.getEstado().getId());
            entity.setEstado(estado);
        }
        return entity;
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

