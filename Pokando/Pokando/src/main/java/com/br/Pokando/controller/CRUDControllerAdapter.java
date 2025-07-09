package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.net.URI;
import java.util.List;

/**
 *
 * @author 1513003
 * @param <E>   Classe que representa o objeto que será manipulado na controller
 * @param <K> Classe que representa a chave primária do objeto que será
 * manipulado pelos serviços
 * @param <DTO_RESPONSE> Classe DTO que representa a resposta a ser encaminhada
 * para o cliente requisitante
 * @param <DTO_CREATE_REQUEST> Classe DTO que representa um objeto da classe DTO que
 * contem os atributos para criação de uma entidade no banco de dados do sistema
 * @param <DTO_UPDATE_REQUEST> Classe DTO que representa um objeto da classe DTO que
 * contem os atributos para alteração de dados de uma entidade no banco de dados do sistema
 */
public abstract class CRUDControllerAdapter<E, K, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST>
        implements IController<K, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST> {

    protected final IService<E, K, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST> service;
    protected final IMapper<E, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST> mapper;

    public CRUDControllerAdapter(
            IService<E, K, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST> service,
            IMapper<E, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST> mapper
    ) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Método para criar URI.Método utilizado para criar a URI que será
     * devolvida na resposta ao sistema requisitante.
     *
     * @param response  Objeto da classe de resposta que contem o ID gerado no banco de dados
     * @param uriBuilder    Objeto da classe UriComponentsBuilder utilizado para criar a URI.
     * @return
     */
    protected abstract URI createURI(DTO_RESPONSE response, UriComponentsBuilder uriBuilder);


    @PostMapping
    @Override
    public ResponseEntity<DTO_RESPONSE> create(
            @RequestBody @Valid DTO_CREATE_REQUEST request,
            UriComponentsBuilder uriBuilder) {
        var entity = service.create(request);
        DTO_RESPONSE response = mapper.toDto(entity);
        URI uri = createURI(response, uriBuilder);
        return createdResponse(response, uri);
    }


    @GetMapping
    @Override
    public ResponseEntity<List<DTO_RESPONSE>> list() {
        var items = service.list();
        var dtoItems = mapper.toListDto(items);
        return okListResponse(dtoItems);
    }

}