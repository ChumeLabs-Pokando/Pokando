package com.br.Pokando.controller;



import com.br.Pokando.Mapper.TelefoneMapper;
import com.br.Pokando.Service.TelefoneService;
import com.br.Pokando.dto.TelefoneRequest;
import com.br.Pokando.dto.TelefoneResponse;
import com.br.Pokando.model.Telefone;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telefone")
public class TelefoneController  extends CRUDDefaultControllerAdapter<Telefone, Long, TelefoneResponse, TelefoneRequest, TelefoneRequest> {

    public TelefoneController(TelefoneService service, TelefoneMapper mapper) {
        super(service, mapper);
    }



}
