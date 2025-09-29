package com.br.Pokando.controller;


import com.br.Pokando.Mapper.UserAcessoMapper;
import com.br.Pokando.Service.UserAcessoService;
import com.br.Pokando.dto.UserAcessoRequest;
import com.br.Pokando.dto.UserAcessoResponse;
import com.br.Pokando.model.UserAcesso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-acesso")
public class UserAcessoController
        extends CRUDDefaultControllerAdapter<UserAcesso, Long, UserAcessoResponse, UserAcessoRequest, UserAcessoRequest> {


    public UserAcessoController(UserAcessoService service, UserAcessoMapper mapper) {
        super(service, mapper);
    }

}