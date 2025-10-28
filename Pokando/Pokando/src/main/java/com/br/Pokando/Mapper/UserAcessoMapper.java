package com.br.Pokando.Mapper;

import com.br.Pokando.dto.*;
import com.br.Pokando.model.UserAcesso;
import com.br.Pokando.model.heranca.Cliente;
import com.br.Pokando.repository.ClienteRepository;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserAcessoMapper implements IMapper<UserAcesso, UserAcessoResponse, UserAcessoRequest, UserAcessoRequest> {

    private final ClienteRepository clienteRepository;

    
    private final ClienteMapper clienteMapper;

    @Autowired
    public UserAcessoMapper(@Lazy ClienteMapper clienteMapper, ClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

//    @Override
//    public UserAcessoResponse toDto(UserAcesso entity) {
//        UserAcessoResponse dto = new UserAcessoResponse(entity.getId());
//        dto.setNome(entity.getNome());
//
//        if (entity.getClientes() != null) {
//            dto.setClientes(
//                    entity.getClientes().stream()
//                            .map(clienteMapper::toDto)
//                            .collect(Collectors.toList())
//            );
//        }
//
//        return dto;
//    }

    @Override
    public UserAcessoResponse toDto(UserAcesso entity) {
        UserAcessoResponse dto = new UserAcessoResponse(entity.getId());
        dto.setNome(entity.getNome());

        return dto;
    }

    public UserAcesso toEntity(UserAcessoRequest dto, ClienteRepository clienteRepository) {
        var entity = new UserAcesso();
        entity.setNome(dto.getNome());

        if (dto.getClientesIds() != null && !dto.getClientesIds().isEmpty()) {
            List<Cliente> clientes = dto.getClientesIds().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> clienteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setClientes(clientes);
        }

        return entity;
    }

    @Override
    public UserAcesso toEntity(UserAcessoRequest dto) {
        UserAcesso entity = new UserAcesso(dto.getId());
        entity.setNome(dto.getNome());

        if (dto.getClientesIds() != null) {
            List<Cliente> cliente = dto.getClientesIds().stream()
                    .map(id -> clienteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setClientes(cliente);
        }

        return entity;
    }

    @Override
    public UserAcesso update(UserAcessoRequest request, UserAcesso entity) {
        entity.setNome(request.getNome());

        if (request.getClientesIds() != null) {
            List<Cliente> cliente = request.getClientesIds().stream()
                    .map(id -> clienteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setClientes(cliente);
        }

        return entity;
    }

    public List<UserAcessoResponse> toListDto(List<UserAcesso> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }
}
