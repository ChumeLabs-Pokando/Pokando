package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.exception.ResourceNotFoundException;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Endereco_geografico;
import com.br.Pokando.model.Estado;
import com.br.Pokando.repository.Endereco_geograficoRepository;
import com.br.Pokando.repository.EstadoRepository;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EnderecoMapper implements IMapper<Endereco, EnderecoResponse, EnderecoRequest, EnderecoRequest>{

    private final EstadoMapper estadoMapper;
    private final EstadoRepository estadoRepository;
    private final Endereco_geograficoMapper enderecoGeograficoMapper;
    private final Endereco_geograficoRepository enderecoGeograficoRepository;

    @Override
    public EnderecoResponse toDto(Endereco entity) {
        EnderecoResponse dto = new EnderecoResponse(entity.getId());

        dto.setLogradouro(entity.getLogradouro());
        dto.setCidade(entity.getCidade());
        dto.setNumero(entity.getNumero());
        dto.setCep(entity.getCep());
        dto.setBairro(entity.getBairro());
        dto.setComplemento(entity.getComplemento());

        if (entity.getEstado() != null) {
            dto.setEstado(estadoMapper.toDto(entity.getEstado()));
        }
        if (entity.getEndereco_geografico() != null) {
            dto.setEndereco_geografico(enderecoGeograficoMapper.toDto(entity.getEndereco_geografico()));
        }

        return dto;
    }




    public EnderecoMapper(EstadoMapper estadoMapper, EstadoRepository estadoRepository, Endereco_geograficoMapper enderecoGeograficoMapper, Endereco_geograficoRepository enderecoGeograficoRepository) {
        this.estadoMapper = estadoMapper;
        this.estadoRepository = estadoRepository;
        this.enderecoGeograficoMapper = enderecoGeograficoMapper;
        this.enderecoGeograficoRepository = enderecoGeograficoRepository;
    }

    public Endereco toEntity(
            EnderecoRequest dto,
            EstadoRepository estadoRepository,
            Endereco_geograficoRepository enderecoGeograficoRepository
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
        if (dto.getEndereco_geografico() != null) {
            var endGeo = enderecoGeograficoRepository
                    .findById(dto.getEndereco_geografico().getId())
                    .orElseThrow(() -> new RuntimeException("Endereco Geografico não encontrado"));
            entity.setEndereco_geografico(endGeo);
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

        if (request.getEstado() != null && request.getEstado().getId() != null) {
            Estado estado = estadoRepository.findById(request.getEstado().getId())
                    .orElseThrow(() -> new RuntimeException("Estado não encontrado"));
            entity.setEstado(estado);
        }

        if (request.getEndereco_geografico() != null && request.getEndereco_geografico().getId() != null) {
            Endereco_geografico endGeo = enderecoGeograficoRepository.findById(request.getEndereco_geografico().getId())
                    .orElseThrow(() -> new RuntimeException("Endereco Geografico não encontrado"));
            entity.setEndereco_geografico(endGeo);
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

        if (request.getEstado() != null && request.getEstado().getId() != null) {
            var estado = estadoRepository.findById(request.getEstado().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Estado não encontrado"));
            entity.setEstado(estado);
        }

        if (request.getEndereco_geografico() != null && request.getEndereco_geografico().getId() != null) {
            Endereco_geografico endGeo = enderecoGeograficoRepository.findById(request.getEndereco_geografico().getId())
                    .orElseThrow(() -> new RuntimeException("Endereco Geografico não encontrado"));
            entity.setEndereco_geografico(endGeo);
        }
        return entity;
    }


    public List<EnderecoResponse> toListDto(List<Endereco> items) {
        return items.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
    }


}

