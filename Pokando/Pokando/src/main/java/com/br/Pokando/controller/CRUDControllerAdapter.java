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
    @Override
    protected URI createURI(DTO_RESPONSE response, UriComponentsBuilder uriBuilder) {
        return uriBuilder
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
    }


    @Operation(summary = "Recurso utilizado para cadastrar dados de um objeto no sistema")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Objeto criado com sucesso",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = DTO_CREATE_REQUEST.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Um ou mais dados informados são inválidos ou estão ausentes"
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Falha na tentativa de criação do objeto. Tente novamente"
            )
    })
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

    @Operation(summary = "Recurso responsável por recuperar uma lista de objetos cadastrados no sistema")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista dos objetos encontrados",
                    content = @Content
            )
    })
    @GetMapping
    @Override
    public ResponseEntity<List<DTO_RESPONSE>> list() {
        var items = service.list();
        var dtoItems = mapper.toListDto(items);
        return okListResponse(dtoItems);
    }

    @Operation(summary = "Recurso responsável por recuperar um objeto cadastrado, pela chave primária")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Dados encontrados com sucesso",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DTO_RESPONSE.class)
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Dados não encontrados",
                    content = @Content
            )
    })
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DTO_RESPONSE> findById(K id) {
        var entity = service.findBy(id);
        var response = mapper.toDto(entity);
        return okResponse(response);
    }

    @Operation(summary = "Recurso responsável por excluir um objeto cadastrado no sistema pela chave primária")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Dados removidos com sucesso",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Dados não encontrados",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Não é possível deletar o objeto."
            )
    })
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(K id) {
        service.deleteById(id);
        return voidResponse();
    }

    @Operation(summary = "Recurso responsável por recuperar e alterar os dados de um objeto pela chave primária")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Dados alterados com sucesso",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Dados não encontrados",
                    content = @Content
            )
    })
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<DTO_RESPONSE> update(K id, DTO_UPDATE_REQUEST request) {
        var entity = service.findBy(id);
        var updated = mapper.update(request, entity);
        var response = mapper.toDto(updated);
        return okResponse(response);
    }

}
