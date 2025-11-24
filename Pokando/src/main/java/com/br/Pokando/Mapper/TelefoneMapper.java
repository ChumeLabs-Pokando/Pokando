package com.br.Pokando.Mapper;

import com.br.Pokando.dto.TelefoneRequest;
import com.br.Pokando.dto.TelefoneResponse;

import com.br.Pokando.model.Telefone;

import com.br.Pokando.model.Cliente;
import com.br.Pokando.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelefoneMapper implements IMapper<Telefone, TelefoneResponse, TelefoneRequest, TelefoneRequest>{

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;



    public TelefoneMapper(ClienteMapper clienteMapper, ClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public TelefoneResponse toDto(
            Telefone entity
    ) {
        TelefoneResponse dto = new TelefoneResponse(entity.getId());
        dto.setNumero(entity.getNumero());

        if (entity.getCliente() != null) {
            dto.setCliente(clienteMapper.toDto(entity.getCliente()));
        }
        return dto;
    }

    @Override
    public List<TelefoneResponse> toListDto(
            List<Telefone> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }


    public Telefone toEntity(TelefoneRequest request, ClienteRepository clienteRepository) {
        var entity = new Telefone();
        entity.setNumero(request.getNumero());


        if (request.getClienteRequest() != null) {
            var Cliente = clienteRepository
                    .findById(request.getClienteRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            entity.setCliente(Cliente);
        }


        return entity;
    }
    @Override
    public Telefone toEntity(TelefoneRequest request) {
        var entity = new Telefone();
        entity.setNumero(request.getNumero());


        if (request.getClienteRequest() != null) {
            var Cliente = clienteRepository
                    .findById(request.getClienteRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            entity.setCliente(Cliente);
        }
        return entity;
    }

    @Override
    public Telefone update(TelefoneRequest request, Telefone entity) {
        entity.setNumero(request.getNumero());


        if (request.getClienteRequest() != null && request.getClienteRequest().getId() != null) {
            Cliente cliente = clienteRepository.findById(request.getClienteRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            entity.setCliente(cliente);
        }

        return entity;
    }
}

