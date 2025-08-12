package com.br.Pokando.controller;


import com.br.Pokando.Mapper.User_acessoMapper;
import com.br.Pokando.Service.User_acessoService;
import com.br.Pokando.dto.User_acessoRequest;
import com.br.Pokando.dto.User_acessoResponse;
import com.br.Pokando.model.User_acesso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-acesso")
public class User_acessoController
        extends CRUDDefaultControllerAdapter<User_acesso, Long, User_acessoResponse, User_acessoRequest, User_acessoRequest> {


    public User_acessoController(User_acessoService service, User_acessoMapper mapper) {
        super(service, mapper);
    }

}