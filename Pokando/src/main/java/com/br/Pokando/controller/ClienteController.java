/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.ClienteRequest;
import com.br.Pokando.dto.ClienteRequestUpdate;
import com.br.Pokando.dto.ClienteResponse;

import com.br.Pokando.model.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 05029689150
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController 
 extends CRUDDefaultControllerAdapter<Cliente, Long, ClienteResponse, ClienteRequest, ClienteRequestUpdate> {

    public ClienteController(IService<Cliente, Long, ClienteResponse, ClienteRequest, ClienteRequestUpdate> service, IMapper<Cliente, ClienteResponse, ClienteRequest, ClienteRequestUpdate> mapper) {
        super(service, mapper);
    }
}
