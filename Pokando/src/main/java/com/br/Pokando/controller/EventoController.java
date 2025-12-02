package com.br.Pokando.controller;

import com.br.Pokando.Mapper.EventoMapper;
import com.br.Pokando.Service.EventoService;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.ApiDataResponse;
import com.br.Pokando.dto.EventoRequest;
import com.br.Pokando.dto.EventoRequestUpdate;
import com.br.Pokando.dto.EventoResponse;

import com.br.Pokando.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController
        extends CRUDDefaultControllerAdapter<Evento, Long, EventoResponse, EventoRequest, EventoRequestUpdate> {

    private final EventoMapper eventoMapper;
    private final EventoService eventoService;

    @Autowired
    public EventoController(
            IService<Evento, Long, EventoResponse, EventoRequest, EventoRequestUpdate> service,
            EventoMapper eventoMapper, EventoService eventoService
    ) {
        super(service, eventoMapper);
        this.eventoMapper = eventoMapper;
        this.eventoService = eventoService;
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<ApiDataResponse<List<EventoResponse>>> pesquisar(@RequestParam String nome) {

        var response = eventoService.buscarPorNome(nome);

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        "Pesquisa realizada com sucesso",
                        200,
                        "OK",
                        response
                )
        );


    }

}
