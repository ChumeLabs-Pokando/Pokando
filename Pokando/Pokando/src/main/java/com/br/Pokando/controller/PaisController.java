package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Mapper.PaisMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.Service.PaisService;
import com.br.Pokando.dto.PaisRequest;
import com.br.Pokando.dto.PaisResponse;
import com.br.Pokando.model.Pais;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController 
        extends CRUDDefaultControllerAdapter<Pais, Long, PaisResponse, PaisRequest, PaisRequest> {


    public PaisController(PaisService service, PaisMapper mapper) {
        super(service, mapper);
    }

}