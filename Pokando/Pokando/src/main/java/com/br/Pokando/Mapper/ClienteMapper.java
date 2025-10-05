/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Mapper;
import java.util.Objects;
import com.br.Pokando.dto.ClienteRequest;
import com.br.Pokando.dto.ClienteResponse;
import com.br.Pokando.model.UserAcesso;

import com.br.Pokando.model.heranca.Cliente;
import com.br.Pokando.repository.UserAcessoRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * @author 05029689150
 */
@Component
public class ClienteMapper implements IMapper<Cliente, ClienteResponse, ClienteRequest, ClienteRequest> {

    private final UserAcessoMapper userAcessoMapper;
    private final UserAcessoRepository userAcessoRepository;

    public ClienteMapper(UserAcessoMapper userAcessoMapper, UserAcessoRepository userAcessoRepository) {
        this.userAcessoMapper = userAcessoMapper;
        this.userAcessoRepository = userAcessoRepository;
    }

    @Override
    public ClienteResponse toDto(Cliente entity) {
        ClienteResponse dto = new ClienteResponse(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNickname(entity.getNickname());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setFoto(entity.getFoto());

        if (entity.getUserAcesso() != null) {
            dto.setUserAcessoResponse(
                    entity.getUserAcesso().stream()
                            .map(userAcessoMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public Cliente toEntity(ClienteRequest dto, UserAcessoRepository userAcessoRepository) {
        var entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setFoto(dto.getFoto());

        if (dto.getUserAcessosIds() != null && !dto.getUserAcessosIds().isEmpty()) {
            List<UserAcesso> acessos = dto.getUserAcessosIds().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setUserAcesso(acessos);
        }

        return entity;
    }

    @Override
    public Cliente toEntity(ClienteRequest dto) {
        Cliente entity = new Cliente(dto.getId());
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setFoto(dto.getFoto());

        if (dto.getUserAcessosIds() != null) {
            List<UserAcesso> acessos = dto.getUserAcessosIds().stream()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setUserAcesso(acessos);
        }

        return entity;
    }


    @Override
    public Cliente update(ClienteRequest request, Cliente entity) {
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setFoto(request.getFoto());

        if (request.getUserAcessosIds() != null) {
            List<UserAcesso> acessos = request.getUserAcessosIds().stream()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setUserAcesso(acessos);
        }

        return entity;
    }


    public List<ClienteResponse> toListDto(List<Cliente> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }
}
