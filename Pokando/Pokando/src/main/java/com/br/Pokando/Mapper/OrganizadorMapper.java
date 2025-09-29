package com.br.Pokando.Mapper;


import com.br.Pokando.dto.*;
import com.br.Pokando.dto.OrganizadorResponse;
import com.br.Pokando.model.*;
import com.br.Pokando.model.Organizador;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
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
            dto.setUserAcessoResponse(userAcessoMapper.toDto(entity.getUserAcesso()));
        }
        return dto;
    }

    @Override
    public List<OrganizadorResponse> toListDto(
            List<Organizador> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    public Organizador toEntity(OrganizadorRequest request, UserAcessoRepository userAcessoRepository) {
        var entity = new Organizador();
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setCpf(request.getCpf());
        entity.setCnpj(request.getCnpj());

        if (request.getUserAcessoRequest() != null) {
            var userAcesso = userAcessoRepository
                    .findById(request.getUserAcessoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Acesso de usuario não encontrado"));
            entity.setUserAcesso(userAcesso);
        }
        return entity;
    }

    @Override
    public Organizador toEntity(OrganizadorRequest request) {
        var entity = new Organizador();
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setCpf(request.getCpf());
        entity.setCnpj(request.getCnpj());

        if (request.getUserAcessoRequest() != null && request.getUserAcessoRequest().getId() != null) {
            UserAcesso userAcesso = userAcessoRepository.findById(request.getUserAcessoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Acesso do Usuario não encontrado"));
            entity.setUserAcesso(userAcesso);
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

        if (request.getUserAcessoRequest() != null && request.getUserAcessoRequest().getId() != null) {
            UserAcesso userAcesso = userAcessoRepository.findById(request.getUserAcessoRequest().getId())
                    .orElseThrow(() -> new RuntimeException("Acesso do Usuario não encontrado"));
            entity.setUserAcesso(userAcesso);
        }
        return entity;
    }
    
}
