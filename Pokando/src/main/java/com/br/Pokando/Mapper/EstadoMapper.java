package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.exception.ResourceNotFoundException;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Estado;
import com.br.Pokando.model.Pais;
import com.br.Pokando.repository.EstadoRepository;
import com.br.Pokando.repository.PaisRepository;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstadoMapper implements IMapper<Estado, EstadoResponse, EstadoRequest, EstadoRequest>{


    private final PaisMapper paisMapper;
    private final PaisRepository paisRepository;

    public EstadoMapper(PaisMapper paisMapper, PaisRepository paisRepository) {
        this.paisMapper = paisMapper;
        this.paisRepository = paisRepository;
    }

    @Override
    public EstadoResponse toDto(
            Estado entity
    ) {
        EstadoResponse dto = new EstadoResponse(entity.getId());
        dto.setNome(entity.getNome());
        dto.setSigla(entity.getSigla());

        if (entity.getPais() != null) {
            dto.setPais(paisMapper.toDto(entity.getPais()));
        }
        return dto;
    }

    @Override
    public List<EstadoResponse> toListDto(
            List<Estado> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }


    public Estado toEntity(EstadoRequest request, PaisRepository paisRepository) {
        var entity = new Estado();
        entity.setNome(request.getNome());
        entity.setSigla(request.getSigla());

        if (request.getPais() != null) {
            var pais = paisRepository
                    .findById(request.getPais().getId())
                    .orElseThrow(() -> new RuntimeException("Pais não encontrado"));
            entity.setPais(pais);
        }
        return entity;
    }
    @Override
    public Estado toEntity(EstadoRequest request) {
        var entity = new Estado();
        entity.setNome(request.getNome());
        entity.setSigla(request.getSigla());

        if (request.getPais() != null && request.getPais().getId() != null) {
            Pais pais = paisRepository.findById(request.getPais().getId())
                    .orElseThrow(() -> new RuntimeException("Pais não encontrado"));
            entity.setPais(pais);
        }
        return entity;
    }

    @Override
    public Estado update(EstadoRequest request, Estado entity) {
        entity.setNome(request.getNome());
        entity.setSigla(request.getSigla());

        if (request.getPais() != null && request.getPais().getId() != null) {
            Pais pais = paisRepository.findById(request.getPais().getId())
                    .orElseThrow(() -> new RuntimeException("Pais não encontrado"));
            entity.setPais(pais);
        }
        return entity;
    }
}
