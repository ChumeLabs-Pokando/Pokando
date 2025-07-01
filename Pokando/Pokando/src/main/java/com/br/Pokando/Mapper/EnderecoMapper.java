package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Estado;
import com.br.Pokando.repository.EstadoRepository;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EnderecoMapper implements IMapper<Endereco, EnderecoResponse, EnderecoRequest, EnderecoRequest>{

    private final EstadoMapper estadoMapper;

    @Override
    public EnderecoResponse toDto(
            Endereco entity
    ) {
        EnderecoResponse dto = new EnderecoResponse(
                entity.getId()
        );
        entity.setLogradouro(dto.getLogradouro());
        entity.setCidade(dto.getCidade());
        entity.setNumero(dto.getNumero());
        entity.setCep(dto.getCep());
        entity.setBairro(dto.getBairro());
        entity.setComplemento(dto.getComplemento());

        if (entity.getEstado() != null) {
            dto.setEstado(estadoMapper
                    .toDto(entity.getEstado()));
        }


        return dto;
    }





    public EnderecoMapper(EstadoMapper estadoMapper) {
        this.estadoMapper = estadoMapper;

    }

    public Endereco toEntity(
            EnderecoRequest dto,
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
                    .findById(dto.getEstado().getId())
                    .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
            entity.setEstado(estado);
        }

        return entity;
    }

    @Override
    public Endereco toEntity(EnderecoRequest request) {
        var entity = new Endereco(request.getId());
        entity.setLogradouro(request.getLogradouro());
        entity.setCidade(request.getCidade());
        entity.setNumero(request.getNumero());
        entity.setCep(request.getCep());
        entity.setBairro(request.getBairro());
        entity.setComplemento(request.getComplemento());

        if (request.getEstado() != null) {
            var estado = estadoMapper.toEntity(request.getEstado());
            entity.setEstado(estado);
        }


        return entity;
    }




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
    public Produto update(ProdutoRequest request, Produto entity) {
        entity.setNome(request.getNome());
        entity.setDescricao(request.getDescricao());
        entity.setEstoqueMinimo(request.getEstoqueMinimo());
        if (request.getSubGrupo() != null) {
            var subgrupo = subgrupoMapper.toEntity(request.getSubGrupo());
            entity.setSubgrupo(subgrupo);
        }

        if (request.getUnidadeMedida() != null) {
            var unidadeMedida = unidadeMedidaMapper.toEntity(request.getUnidadeMedida());
            entity.setUnidadeMedida(unidadeMedida);
        }

        if (request.getMarca() != null) {
            var marca = marcaMapper.toEntity(request.getMarca());
            entity.setMarca(marca);
        }
        return entity;
    }


    public List<EnderecoResponse> toListDto(List<Endereco> items) {
        return items.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
    }


}

