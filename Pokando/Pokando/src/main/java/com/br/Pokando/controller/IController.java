package com.br.Pokando.controller;

import com.br.Pokando.dto.ApiDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 *
 * @author 1513003
 * @param <DTO_K> Classe que representa a chave primária do objeto que será
 * manipulado pelos serviços
 * @param <DTO_RESPONSE> Classe DTO que representa a resposta a ser encaminhada
 * para o cliente requisitante
 * @param <DTO_CREATE_REQUEST> Classe DTO que representa um objeto da classe DTO que
 * contem os atributos para criação de uma entidade no banco de dados do sistema
 * @param <DTO_UPDATE_REQUEST> Classe DTO que representa um objeto da classe DTO que
 * contem os atributos para alteração de dados de uma entidade no banco de dados do sistema
 */
public interface IController<DTO_K, DTO_RESPONSE, DTO_CREATE_REQUEST, DTO_UPDATE_REQUEST> {

    ResponseEntity<ApiDataResponse<DTO_RESPONSE>> create(
            DTO_CREATE_REQUEST request,
            UriComponentsBuilder uriBuilder);

    ResponseEntity<ApiDataResponse<List<DTO_RESPONSE>>> list();

    ResponseEntity<ApiDataResponse<DTO_RESPONSE>> findById(DTO_K id);

    ResponseEntity<ApiDataResponse<DTO_RESPONSE>> update(DTO_K id, DTO_UPDATE_REQUEST request);

    ResponseEntity<ApiDataResponse<Void>> delete(DTO_K id);

    default <T> ResponseEntity<ApiDataResponse<T>> okResponse(String mensagem, T body) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiDataResponse<>(
                        mensagem,
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        body
                )
        );
    }

    default <T> ResponseEntity<ApiDataResponse<T>> createdResponse(String mensagem, T body, URI uri) {
        return ResponseEntity.created(uri).body(
                new ApiDataResponse<>(
                        mensagem,
                        HttpStatus.CREATED.value(),
                        HttpStatus.CREATED.getReasonPhrase(),
                        body
                )
        );
    }

    default ResponseEntity<ApiDataResponse<Void>> voidResponse(String mensagem) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiDataResponse<>(
                        mensagem,
                        HttpStatus.OK.value(),
                        HttpStatus.OK.getReasonPhrase(),
                        null
                )
        );
    }
}
