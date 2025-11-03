package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.IngressoRequest;
import com.br.Pokando.dto.IngressoResponse;
import com.br.Pokando.model.Ingresso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingresso")
public class IngressoController extends CRUDDefaultControllerAdapter<Ingresso, Long, IngressoResponse, IngressoRequest, IngressoRequest> {

    public IngressoController(IService<Ingresso, Long, IngressoResponse, IngressoRequest, IngressoRequest> service, IMapper<Ingresso, IngressoResponse, IngressoRequest, IngressoRequest> mapper) {
        super(service, mapper);
    }

}