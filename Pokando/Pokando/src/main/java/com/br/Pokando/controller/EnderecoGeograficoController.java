package com.br.Pokando.controller;


import com.br.Pokando.Mapper.EnderecoGeograficoMapper;
import com.br.Pokando.Service.EnderecoGeograficoService;
import com.br.Pokando.dto.EnderecoGeograficoRequest;
import com.br.Pokando.dto.EnderecoGeograficoResponse;
import com.br.Pokando.model.EnderecoGeografico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco-geografico")
public class EnderecoGeograficoController extends CRUDDefaultControllerAdapter<EnderecoGeografico, Long, EnderecoGeograficoResponse, EnderecoGeograficoRequest, EnderecoGeograficoRequest> {

    public EnderecoGeograficoController(EnderecoGeograficoService service, EnderecoGeograficoMapper mapper) {
        super(service, mapper);
    }
}
