package com.br.Pokando.controller;

import com.br.Pokando.Mapper.CategoriaIngressoMapper;
import com.br.Pokando.Service.CategoriaIngressoService;
import com.br.Pokando.dto.CategoriaIngressoRequest;
import com.br.Pokando.dto.CategoriaIngressoResponse;
import com.br.Pokando.model.CategoriaIngresso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria-ingresso")
public class CategoriaIngressoController
        extends CRUDDefaultControllerAdapter<CategoriaIngresso, Long, CategoriaIngressoResponse, CategoriaIngressoRequest, CategoriaIngressoRequest> {


    public CategoriaIngressoController(CategoriaIngressoService service, CategoriaIngressoMapper mapper) {
        super(service, mapper);
    }

}