package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.ProprietarioRequest;
import com.br.Pokando.dto.ProprietarioResponse;
import com.br.Pokando.model.Proprietario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController extends CRUDDefaultControllerAdapter<Proprietario, Long, ProprietarioResponse, ProprietarioRequest, ProprietarioRequest> {

    public ProprietarioController(IService<Proprietario, Long, ProprietarioResponse, ProprietarioRequest, ProprietarioRequest> service, IMapper<Proprietario, ProprietarioResponse, ProprietarioRequest, ProprietarioRequest> mapper) {
        super(service, mapper);
    }



}
