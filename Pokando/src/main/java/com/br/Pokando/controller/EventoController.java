package com.br.Pokando.controller;

import com.br.Pokando.Mapper.EventoMapper;
import com.br.Pokando.Service.EventoService;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.ApiDataResponse;
<<<<<<< HEAD
import com.br.Pokando.dto.EventoDetalhadoResponse;
=======
>>>>>>> 211da5c12b015a4a9553d1a5f02ad45943d4b0dc
import com.br.Pokando.dto.EventoRequest;
import com.br.Pokando.dto.EventoResponse;

import com.br.Pokando.model.Evento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 211da5c12b015a4a9553d1a5f02ad45943d4b0dc
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
>>>>>>> 211da5c12b015a4a9553d1a5f02ad45943d4b0dc

@RestController
@RequestMapping("/evento")
public class EventoController
        extends CRUDDefaultControllerAdapter<Evento, Long, EventoResponse, EventoRequest, EventoRequest> {

    private final EventoMapper eventoMapper;
    private final EventoService eventoService;

    @Autowired
    public EventoController(
<<<<<<< HEAD
            IService<Evento, Long, EventoResponse, EventoRequest, EventoRequest> service,
            EventoMapper eventoMapper
=======
            IService<Evento, Long, EventoResponse, EventoRequest, EventoRequestUpdate> service,
            EventoMapper eventoMapper, EventoService eventoService
>>>>>>> 211da5c12b015a4a9553d1a5f02ad45943d4b0dc
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
