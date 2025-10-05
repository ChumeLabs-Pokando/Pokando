package com.br.Pokando.Mapper;


import com.br.Pokando.dto.*;
import com.br.Pokando.dto.OrganizadorResponse;
import com.br.Pokando.model.*;
import com.br.Pokando.model.Organizador;
import com.br.Pokando.model.heranca.Cliente;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OrganizadorMapper implements IMapper<Organizador, OrganizadorResponse, OrganizadorRequest, OrganizadorRequest>{

    private final UserAcessoMapper userAcessoMapper;
    private final UserAcessoRepository userAcessoRepository;

    public OrganizadorMapper(UserAcessoMapper userAcessoMapper, UserAcessoRepository userAcessoRepository) {
        this.userAcessoMapper = userAcessoMapper;
        this.userAcessoRepository = userAcessoRepository;
    }


    @Override
    public OrganizadorResponse toDto(
            Organizador entity
    ) {
        OrganizadorResponse dto = new OrganizadorResponse(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNickname(entity.getNickname());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setFoto(entity.getFoto());
        dto.setCpf(entity.getCpf());
        dto.setCnpj(entity.getCnpj());

        if (entity.getUserAcesso() != null) {
            dto.setUserAcessoResponse(
                    entity.getUserAcesso().stream()
                            .map(userAcessoMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }



    public Organizador toEntity(OrganizadorRequest dto, UserAcessoRepository userAcessoRepository) {
        var entity = new Organizador();
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setCpf(dto.getCpf());
        entity.setCnpj(dto.getCnpj());

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
    public Organizador toEntity(OrganizadorRequest dto) {
        var entity = new Organizador();
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setCpf(dto.getCpf());
        entity.setCnpj(dto.getCnpj());

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
    public Organizador update(OrganizadorRequest request, Organizador entity) {
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setCpf(request.getCpf());
        entity.setCnpj(request.getCnpj());

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
    
public List<OrganizadorResponse> toListDto(List<Organizador> items) {
    return items.stream().map(this::toDto).collect(Collectors.toList());
}}