package com.br.Pokando.dto;

import lombok.experimental.SuperBuilder;

/**
 *
 * @author 1513003
 */
@SuperBuilder
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
