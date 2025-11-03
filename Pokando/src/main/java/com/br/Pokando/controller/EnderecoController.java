/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import org.springframework.web.bind.annotation.*;


/**
 *
 * @author felip
 */
@RestController
@RequestMapping("/endereco")
public class EnderecoController
 extends CRUDDefaultControllerAdapter<Endereco, Long, EnderecoResponse, EnderecoRequest, EnderecoRequest> {

    public EnderecoController(IService<Endereco, Long, EnderecoResponse, EnderecoRequest, EnderecoRequest> service, IMapper<Endereco, EnderecoResponse, EnderecoRequest, EnderecoRequest> mapper) {
        super(service, mapper);
    }
}



