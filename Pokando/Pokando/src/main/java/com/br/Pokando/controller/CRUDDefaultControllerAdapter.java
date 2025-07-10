package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.ApiDataResponse;
import com.br.Pokando.dto.DefaultRequest;
import com.br.Pokando.dto.DefaultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 *
 * @author 1513003
 * @param <E>   Classe que representa o objeto que será manipulado na controller
 * @param <K> Classe que representa a chave primária do objeto que será
 * manipulado pelos serviços
 * @param <DTO_RESPONSE> Subclasse DTO que herda da classe DefaultResponse e que representa a resposta a ser encaminhada
 * para o cliente requisitante
 * @param <DTO_CREATE_REQUEST> Classe DTO que herda da classe DefaulRequest e que representa um objeto da classe DTO que
 * contem os atributos para criação de uma entidade no banco de dados do sistema
 * @param <DTO_UPDATE_REQUEST> Classe DTO que representa um objeto da classe DTO que
 * contem os atributos para alteração de dados de uma entidade no banco de dados do sistema
 */
public abstract class CRUDDefaultControllerAdapter<
        E, K,
        DTO_RESPONSE extends DefaultResponse,
        DTO_CREATE_REQUEST extends DefaultRequest,
        DTO_UPDATE_REQUEST>
        extends CRUDControllerAdapter<E, K, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST>
        implements IController<K, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST> {

    public CRUDDefaultControllerAdapter(IService service, IMapper mapper) {
        super(service, mapper);
    }

    protected URI createURI(DTO_RESPONSE response, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/{id}").buildAndExpand(response.getId()).toUri();
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ApiDataResponse<DTO_RESPONSE>> findById(@PathVariable K id) {
        var entity = service.findBy(id);
        var response = mapper.toDto(entity);

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        "Consulta realizada com sucesso",
                        200,
                        "OK",
                        response
                )
        );
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ApiDataResponse<Void>> delete(@PathVariable K id) {
        service.deleteById(id);
        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        "Recurso removido com sucesso",
                        200,
                        "OK",
                        null
                )
        );
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ApiDataResponse<DTO_RESPONSE>> update(
            @PathVariable K id,
            @RequestBody DTO_UPDATE_REQUEST request
    ) {
        var entity = service.findBy(id);
        var updated = mapper.update(request, entity);
        var response = mapper.toDto(updated);

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        "Atualização realizada com sucesso",
                        200,
                        "OK",
                        response
                )
        );
    }
}
