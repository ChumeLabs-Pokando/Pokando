/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Mapper;

import com.br.Pokando.dto.UsuarioRequest;
import com.br.Pokando.dto.UsuarioResponse;
import com.br.Pokando.model.User_acesso;
import com.br.Pokando.model.Usuario;
import com.br.Pokando.repository.User_acessoRepository;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 05029689150
 */
public class UsuarioMapper implements IMapper<Usuario, UsuarioResponse, UsuarioRequest, UsuarioRequest>{
    
     private final User_acessoMapper userAcessoMapper;
    private final User_acessoRepository userAcessoRepository;

    public UsuarioMapper(User_acessoMapper userAcessoMapper, User_acessoRepository userAcessoRepository) {
        this.userAcessoMapper = userAcessoMapper;
        this.userAcessoRepository = userAcessoRepository;
    }
    
    @Override
    public UsuarioResponse toDto(Usuario entity) {
        UsuarioResponse dto = new UsuarioResponse(entity.getId());


        dto.setNome(entity.getNome());
        dto.setNickname(entity.getNickname());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setFoto(entity.getFoto());

        if (entity.getUser_acesso() != null) {
            dto.setUser_acesso(userAcessoMapper.toDto(entity.getUser_acesso()));
        }
             
        return dto;
    }

     public Usuario toEntity(
            UsuarioRequest dto,
            User_acessoRepository userAcessoRepository
            
          
    ) {
        var entity = new Usuario();
   
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setFoto(dto.getFoto());

        if (dto.getUser_acesso()!= null) {
            var userA = userAcessoRepository
                    .findById(dto.getUser_acesso().getId())
                    .orElseThrow(() -> new RuntimeException("Acesso não encontrado"));
            entity.setUser_acesso(userA);
        }
        
        return entity;
    }

    @Override
    public Usuario toEntity(UsuarioRequest request) {
        var entity = new Usuario(request.getId());
        
     
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setFoto(request.getFoto());

        if (request.getUser_acesso()!= null && request.getUser_acesso().getId() != null) {
            User_acesso userA = userAcessoRepository.findById(request.getUser_acesso().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario Geografico não encontrado"));
            entity.setUser_acesso(userA);
        }
        
        return entity;
    }
    
    @Override
    public Usuario update(UsuarioRequest request, Usuario entity) {
        
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setFoto(request.getFoto());


        if (request.getUser_acesso() != null && request.getUser_acesso().getId() != null) {
            User_acesso endGeo = userAcessoRepository.findById(request.getUser_acesso().getId())
                    .orElseThrow(() -> new RuntimeException("Acesso não encontrado"));
            entity.setUser_acesso(endGeo);
        }
       
        return entity;
    }
    

    public List<UsuarioResponse> toListDto(List<Usuario> items) {
        return items.stream()
                .map(item -> toDto(item))
                .collect(Collectors.toList());
    }
}
