package com.br.Pokando.controller;


import com.br.Pokando.Mapper.Endereco_geograficoMapper;
import com.br.Pokando.Service.Endereco_geograficoService;
import com.br.Pokando.dto.Endereco_geograficoRequest;
import com.br.Pokando.dto.Endereco_geograficoResponse;
import com.br.Pokando.model.Endereco_geografico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco-geografico")
public class Endereco_geograficoController extends CRUDDefaultControllerAdapter<Endereco_geografico, Long, Endereco_geograficoResponse, Endereco_geograficoRequest, Endereco_geograficoRequest> {

    public Endereco_geograficoController(Endereco_geograficoService service, Endereco_geograficoMapper mapper) {
        super(service, mapper);
    }
}
