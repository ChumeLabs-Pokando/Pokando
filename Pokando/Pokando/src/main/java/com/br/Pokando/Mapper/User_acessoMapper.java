package com.br.Pokando.Mapper;

import com.br.Pokando.dto.User_acessoRequest;
import com.br.Pokando.dto.User_acessoResponse;
import com.br.Pokando.model.User_acesso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class User_acessoMapper implements IMapper<User_acesso, User_acessoResponse, User_acessoRequest, User_acessoRequest>{
    
    @Override
    public User_acessoResponse toDto(
            User_acesso entity
    ) {
        User_acessoResponse dto = new User_acessoResponse(
                entity.getId(),
                entity.getNome()
        );
        return dto;
    }

    @Override
    public List<User_acessoResponse> toListDto(
            List<User_acesso> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public User_acesso toEntity(User_acessoRequest request) {
        return new User_acesso(
                null,
                request.getNome()
        );
    }

    public User_acesso toEntity(User_acessoResponse response) {
        return new User_acesso(
                response.getId(),
                response.getNome()
        );
    }

    @Override
    public User_acesso update(User_acessoRequest request, User_acesso entity) {
        entity.setNome(request.getNome());
        return entity;
    }
}
