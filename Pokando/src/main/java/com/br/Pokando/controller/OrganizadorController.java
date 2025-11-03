package com.br.Pokando.controller;


import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.Service.OrganizadorService;
import com.br.Pokando.dto.ApiDataResponse;
import com.br.Pokando.dto.OrganizadorDetalhadoResponse;
import com.br.Pokando.dto.OrganizadorRequest;
import com.br.Pokando.dto.OrganizadorResponse;
import com.br.Pokando.model.Organizador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organizador")
public class OrganizadorController extends CRUDDefaultControllerAdapter<Organizador, Long, OrganizadorResponse, OrganizadorRequest, OrganizadorRequest> {

    private final OrganizadorService organizadorService;

    public OrganizadorController(IService<Organizador, Long, OrganizadorResponse, OrganizadorRequest, OrganizadorRequest> service, IMapper<Organizador, OrganizadorResponse, OrganizadorRequest, OrganizadorRequest> mapper, OrganizadorService organizadorService) {
        super(service, mapper);
        this.organizadorService = organizadorService;
    }



//    @GetMapping
//    public ResponseEntity<List<OrganizadorResponse>> listar() {
//        return ResponseEntity.ok(organizadorService.listar());
//    }


//    @GetMapping("/{id}")
//    public ResponseEntity<OrganizadorResponse> buscarPorId(@PathVariable Long id) {
//        return ResponseEntity.ok(organizadorService.buscarPorId(id));
//    }


    @GetMapping("/{id}/detalhado")
    public ResponseEntity<OrganizadorDetalhadoResponse> buscarDetalhado(@PathVariable Long id) {
        return ResponseEntity.ok(organizadorService.buscarDetalhado(id));
    }

}
