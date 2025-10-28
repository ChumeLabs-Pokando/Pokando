package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.EventoRequest;
import com.br.Pokando.dto.EventoResponse;
import com.br.Pokando.model.Evento;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController
        extends CRUDDefaultControllerAdapter<Evento, Long, EventoResponse, EventoRequest, EventoRequest> {

    public EventoController(IService<Evento, Long, EventoResponse, EventoRequest, EventoRequest> service, IMapper<Evento, EventoResponse, EventoRequest, EventoRequest> mapper) {
        super(service, mapper);
    }
}
