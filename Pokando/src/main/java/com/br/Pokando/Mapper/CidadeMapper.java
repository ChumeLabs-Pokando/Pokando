package com.br.Pokando.Mapper;

import com.br.Pokando.dto.CidadeResponse;
import com.br.Pokando.dto.CidadeRequest;

import com.br.Pokando.exception.ResourceNotFoundException;
import com.br.Pokando.model.Cidade;

import com.br.Pokando.model.Estado;
import com.br.Pokando.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CidadeMapper implements IMapper<Cidade, CidadeResponse, CidadeRequest, CidadeRequest>{

    private final EstadoMapper estadoMapper;
    private final EstadoRepository estadoRepository;

    public CidadeMapper(EstadoMapper estadoMapper, EstadoRepository estadoRepository) {
        this.estadoMapper = estadoMapper;
        this.estadoRepository = estadoRepository;
    }

    @Override
    public CidadeResponse toDto(Cidade entity) {
        CidadeResponse dto = new CidadeResponse(entity.getId());

        dto.setNome(entity.getNome());

        if (entity.getEstado() != null) {
            dto.setEstado(estadoMapper.toDto(entity.getEstado()));
        }

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
        var entity = new Cidade(request.getId());
        entity.setNome(request.getNome());


        if (request.getEstado() != null && request.getEstado().getId() != null) {
            Estado estado = estadoRepository.findById(request.getEstado().getId())
                    .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
            entity.setEstado(estado);
        }

        return entity;
    }

    public Cidade toEntity(
            CidadeRequest dto,
            EstadoRepository estadoRepository


    ) {
        var entity = new Cidade();
        entity.setNome(dto.getNome());

        if (dto.getEstado() != null) {
            var estado = estadoRepository
                    .findById(dto.getEstado().getId())
                    .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
            entity.setEstado(estado);
        }

        return entity;
    }

    @Override
    public Cidade update(CidadeRequest request, Cidade entity) {
        entity.setNome(request.getNome());


        if (request.getEstado() != null && request.getEstado().getId() != null) {
            var estado = estadoRepository.findById(request.getEstado().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Estado não encontrado"));
            entity.setEstado(estado);
        }


        return entity;
    }
}

