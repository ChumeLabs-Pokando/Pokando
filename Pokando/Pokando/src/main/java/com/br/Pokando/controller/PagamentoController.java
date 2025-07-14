package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Mapper.PagamentoMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.Service.PagamentoService;
import com.br.Pokando.dto.PagamentoRequest;
import com.br.Pokando.dto.PagamentoResponse;
import com.br.Pokando.model.Pagamento;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController extends CRUDDefaultControllerAdapter<Pagamento, Long, PagamentoResponse, PagamentoRequest, PagamentoRequest> {

    public PagamentoController(PagamentoService service, PagamentoMapper mapper) {
        super(service, mapper);
    }



}
