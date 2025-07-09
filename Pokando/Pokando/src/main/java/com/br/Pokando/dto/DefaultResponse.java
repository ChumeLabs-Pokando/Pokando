package com.br.Pokando.dto;

/**
 *
 * @author 1513003
 */
public abstract class DefaultResponse {

    private Long id;

    public DefaultResponse() {
    }


    public DefaultResponse(Long id) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }


}
