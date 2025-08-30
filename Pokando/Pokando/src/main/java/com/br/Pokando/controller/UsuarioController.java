/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.UsuarioRequest;
import com.br.Pokando.dto.UsuarioResponse;
import com.br.Pokando.model.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 05029689150
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController 
 extends CRUDDefaultControllerAdapter<Usuario, Long, UsuarioResponse, UsuarioRequest, UsuarioRequest> {

    public UsuarioController(IService<Usuario, Long, UsuarioResponse, UsuarioRequest, UsuarioRequest> service, IMapper<Usuario, UsuarioResponse, UsuarioRequest, UsuarioRequest> mapper) {
        super(service, mapper);
    }
}
