package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Mapper.CidadeMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.Service.CidadeService;
import com.br.Pokando.dto.CidadeRequest;
import com.br.Pokando.dto.CidadeResponse;
import com.br.Pokando.model.Cidade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController
        extends CRUDDefaultControllerAdapter<Cidade, Long, CidadeResponse, CidadeRequest, CidadeRequest> {


    public CidadeController(CidadeService service, CidadeMapper mapper) {
        super(service, mapper);
    }

}