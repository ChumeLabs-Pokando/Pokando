/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Mapper;

import com.br.Pokando.dto.ClienteRequest;
import com.br.Pokando.dto.ClienteResponse;
import com.br.Pokando.model.UserAcesso;
import com.br.Pokando.model.Cliente;
import com.br.Pokando.repository.UserAcessoRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author 05029689150
 */
@Component
public class ClienteMapper implements IMapper<Cliente, ClienteResponse, ClienteRequest, ClienteRequest>{
    
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
            dto.setUserAcessoResponse(userAcessoMapper.toDto(entity.getUserAcesso()));
        }
             
        return dto;
    }

     public Cliente toEntity(
            ClienteRequest dto,
            UserAcessoRepository userAcessoRepository
            
          
    ) {
        var entity = new Cliente();
   
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setFoto(dto.getFoto());

        if (dto.getUserAcesso()!= null) {
            var userA = userAcessoRepository
                    .findById(dto.getUserAcesso().getId())
                    .orElseThrow(() -> new RuntimeException("Acesso não encontrado"));
            entity.setUserAcesso(userA);
        }
        
        return entity;
    }

    @Override
    public Cliente toEntity(ClienteRequest request) {
        var entity = new Cliente(request.getId());
        
     
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setFoto(request.getFoto());

        if (request.getUserAcesso()!= null && request.getUserAcesso().getId() != null) {
            UserAcesso userA = userAcessoRepository.findById(request.getUserAcesso().getId())
                    .orElseThrow(() -> new RuntimeException("Cliente Geografico não encontrado"));
            entity.setUserAcesso(userA);
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


        if (request.getUserAcesso() != null && request.getUserAcesso().getId() != null) {
            UserAcesso endGeo = userAcessoRepository.findById(request.getUserAcesso().getId())
                    .orElseThrow(() -> new RuntimeException("Acesso não encontrado"));
            entity.setUserAcesso(endGeo);
        }
       
        return entity;
    }
    

    public List<ClienteResponse> toListDto(List<Cliente> items) {
        return items.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
    }
}
