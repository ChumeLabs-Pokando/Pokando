/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Service;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Mapper.UsuarioMapper;
import com.br.Pokando.dto.UsuarioRequest;
import com.br.Pokando.dto.UsuarioResponse;
import com.br.Pokando.model.Usuario;
import com.br.Pokando.repository.User_acessoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 05029689150
 */
@Service
public class UsuarioService extends ServiceAdapter<Usuario, Long, UsuarioResponse, UsuarioRequest, UsuarioRequest> {

    private final User_acessoRepository userAcessoRepository;


    public UsuarioService(User_acessoRepository userAcessoRepository, JpaRepository<Usuario, Long> repository, IMapper<Usuario, UsuarioResponse, UsuarioRequest, UsuarioRequest> mapper) {
        super(repository, mapper);
        this.userAcessoRepository = userAcessoRepository;
    }

    @Override
    @Transactional
    public Usuario create(UsuarioRequest request) {
        var entity = ((UsuarioMapper) mapper).toEntity(request, userAcessoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar usuario salvo"));
    }

}
