package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.exception.ResourceNotFoundException;
import com.br.Pokando.model.Cidade;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.EnderecoGeografico;
import com.br.Pokando.model.Estado;
import com.br.Pokando.repository.CidadeRepository;
import com.br.Pokando.repository.EnderecoGeograficoRepository;
import com.br.Pokando.repository.EstadoRepository;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EnderecoMapper implements IMapper<Endereco, EnderecoResponse, EnderecoRequest, EnderecoRequest>{

    private final CidadeMapper cidadeMapper;
    private final CidadeRepository cidadeRepository;
    private final EnderecoGeograficoMapper enderecoGeograficoMapper;
    private final EnderecoGeograficoRepository enderecoGeograficoRepository;

    @Override
    public EnderecoResponse toDto(Endereco entity) {
        EnderecoResponse dto = new EnderecoResponse(entity.getId());

        dto.setLogradouro(entity.getLogradouro());
        dto.setNumero(entity.getNumero());
        dto.setCep(entity.getCep());
        dto.setBairro(entity.getBairro());
        dto.setComplemento(entity.getComplemento());

        if (entity.getEnderecoGeografico() != null) {
            dto.setEnderecoGeograficoResponse(enderecoGeograficoMapper.toDto(entity.getEnderecoGeografico()));
        }
        if (entity.getCidade() != null) {
            dto.setCidade(cidadeMapper.toDto(entity.getCidade()));
        }

        return dto;
    }




    public EnderecoMapper(CidadeMapper cidadeMapper, CidadeRepository cidadeRepository, EnderecoGeograficoMapper enderecoGeograficoMapper, EnderecoGeograficoRepository enderecoGeograficoRepository) {
        this.cidadeMapper = cidadeMapper;
        this.cidadeRepository = cidadeRepository;
        this.enderecoGeograficoMapper = enderecoGeograficoMapper;
        this.enderecoGeograficoRepository = enderecoGeograficoRepository;
    }

    public Endereco toEntity(
            EnderecoRequest dto,
            CidadeRepository cidadeRepository,
            EstadoRepository estadoRepository,
            EnderecoGeograficoRepository enderecoGeograficoRepository
    ) {
        var entity = new Endereco();
        entity.setLogradouro(dto.getLogradouro());
        entity.setNumero(dto.getNumero());
        entity.setCep(dto.getCep());
        entity.setBairro(dto.getBairro());
        entity.setComplemento(dto.getComplemento());

        if (dto.getEnderecoGeograficoRequest() != null) {
            var endGeo = enderecoGeograficoRepository
                    .findById(dto.getEnderecoGeograficoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Endereco Geografico não encontrado"));
            entity.setEnderecoGeografico(endGeo);
        }
        if (dto.getCidade() != null) {
            var cidade = cidadeRepository
                    .findById(dto.getCidade().getId())
                    .orElseThrow(() -> new RuntimeException("Cidade não encontrado"));
            entity.setCidade(cidade);
        }

        return entity;
    }

    @Override
    public Endereco toEntity(EnderecoRequest request) {
        var entity = new Endereco(request.getId());
        entity.setLogradouro(request.getLogradouro());
        entity.setNumero(request.getNumero());
        entity.setCep(request.getCep());
        entity.setBairro(request.getBairro());
        entity.setComplemento(request.getComplemento());


        if (request.getEnderecoGeograficoRequest() != null && request.getEnderecoGeograficoRequest().getId() != null) {
            EnderecoGeografico endGeo = enderecoGeograficoRepository.findById(request.getEnderecoGeograficoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Endereco Geografico não encontrado"));
            entity.setEnderecoGeografico(endGeo);
        }
        if (request.getCidade() != null && request.getCidade().getId() != null) {
            Cidade cidade = cidadeRepository.findById(request.getCidade().getId())
                    .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
            entity.setCidade(cidade);
        }

        return entity;
    }


    @Override
    public Endereco update(EnderecoRequest request, Endereco entity) {
        entity.setLogradouro(request.getLogradouro());
        entity.setNumero(request.getNumero());
        entity.setCep(request.getCep());
        entity.setBairro(request.getBairro());
        entity.setComplemento(request.getComplemento());


        if (request.getEnderecoGeograficoRequest() != null && request.getEnderecoGeograficoRequest().getId() != null) {
            EnderecoGeografico endGeo = enderecoGeograficoRepository.findById(request.getEnderecoGeograficoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Endereco Geografico não encontrado"));
            entity.setEnderecoGeografico(endGeo);
        }
        if (request.getCidade() != null && request.getCidade().getId() != null) {
            Cidade cidade = cidadeRepository.findById(request.getCidade().getId())
                    .orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
            entity.setCidade(cidade);

        }

        return entity;
    }


    public List<EnderecoResponse> toListDto(List<Endereco> items) {
        return items.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
    }


}

