package com.br.Pokando.controller;

import com.br.Pokando.Mapper.EventoMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.ApiDataResponse;
import com.br.Pokando.dto.EventoDetalhadoResponse;
import com.br.Pokando.dto.EventoRequest;
import com.br.Pokando.dto.EventoResponse;

import com.br.Pokando.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evento")
public class EventoController
        extends CRUDDefaultControllerAdapter<Evento, Long, EventoResponse, EventoRequest, EventoRequest> {

    private final EventoMapper eventoMapper;

    @Autowired
    public EventoController(
            IService<Evento, Long, EventoResponse, EventoRequest, EventoRequest> service,
            EventoMapper eventoMapper
    ) {
        super(service, eventoMapper);
        this.eventoMapper = eventoMapper;
    }


}
