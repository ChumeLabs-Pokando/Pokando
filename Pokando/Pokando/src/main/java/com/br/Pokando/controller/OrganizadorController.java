package com.br.Pokando.controller;


import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.OrganizadorRequest;
import com.br.Pokando.dto.OrganizadorResponse;
import com.br.Pokando.model.Organizador;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organizador")
public class OrganizadorController extends CRUDDefaultControllerAdapter<Organizador, Long, OrganizadorResponse, OrganizadorRequest, OrganizadorRequest> {

    public OrganizadorController(IService<Organizador, Long, OrganizadorResponse, OrganizadorRequest, OrganizadorRequest> service, IMapper<Organizador, OrganizadorResponse, OrganizadorRequest, OrganizadorRequest> mapper) {
        super(service, mapper);
    }



}
