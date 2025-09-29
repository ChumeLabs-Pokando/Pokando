package com.br.Pokando.Mapper;

import com.br.Pokando.dto.UserAcessoRequest;
import com.br.Pokando.dto.UserAcessoResponse;
import com.br.Pokando.model.UserAcesso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAcessoMapper implements IMapper<UserAcesso, UserAcessoResponse, UserAcessoRequest, UserAcessoRequest>{
    
    @Override
    public UserAcessoResponse toDto(
            UserAcesso entity
    ) {
        UserAcessoResponse dto = new UserAcessoResponse(
                entity.getId(),
                entity.getNome()
        );
        return dto;
    }

    @Override
    public List<UserAcessoResponse> toListDto(
            List<UserAcesso> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public UserAcesso toEntity(UserAcessoRequest request) {
        return new UserAcesso(
                null,
                request.getNome()
        );
    }

    public UserAcesso toEntity(UserAcessoResponse response) {
        return new UserAcesso(
                response.getId(),
                response.getNome()
        );
    }

    @Override
    public UserAcesso update(UserAcessoRequest request, UserAcesso entity) {
        entity.setNome(request.getNome());
        return entity;
    }
}
