package com.br.Pokando.controller;

import com.br.Pokando.Mapper.EventoMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.ApiDataResponse;
import com.br.Pokando.dto.EventoRequest;
import com.br.Pokando.dto.EventoResponse;
import com.br.Pokando.dto.EventoResumoResponse;
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

    @GetMapping("/{id}/detalhe")
    public ResponseEntity<EventoResumoResponse> getDetalhe(@PathVariable Long id) {
        Evento ev = service.findBy(id);
        return ResponseEntity.ok(eventoMapper.toDetalhadoResponse(ev));
    }

//    @GetMapping
//    public ResponseEntity<ApiDataResponse<List<EventoResponse>>> listar() {
//        var lista = service.list()
//                .stream()
//                .map(eventoMapper::toDto)
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(
//                new ApiDataResponse<>(
//                        "Consulta realizada com sucesso",
//                        200,
//                        "OK",
//                        lista
//                )
//        );
//    }
}
