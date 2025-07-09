package com.br.Pokando.controller;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.DefaultRequest;
import com.br.Pokando.dto.DefaultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
public abstract class CRUDDefaultControllerAdapter<E, K,
        DTO_RESPONSE extends DefaultResponse,
        DTO_CREATE_REQUEST extends DefaultRequest,
        DTO_UPDATE_REQUEST>
        extends CRUDControllerAdapter<E, K,
        DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST>
        implements IController<K, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST> {

    public CRUDDefaultControllerAdapter(IService service, IMapper mapper) {
        super(service, mapper);
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


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DTO_RESPONSE> findById(@PathVariable K id) {
        var entity = service.findBy(id);
        var response = mapper.toDto(entity);
        return okResponse(response);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable K id) {
        service.deleteById(id);
        return voidResponse();
    }


    @PutMapping("/{id}")
    @Override
    public ResponseEntity<DTO_RESPONSE> update(@PathVariable K id, DTO_UPDATE_REQUEST request) {
        var entity = service.findBy(id);
        var updated = mapper.update(request, entity);
        var response = mapper.toDto(updated);
        return okResponse(response);
    }

}
