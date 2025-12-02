package com.br.Pokando.dto;

import jakarta.validation.constraints.*;

/**
 *
 * @author 1513003
 */
public abstract class DefaultRequest {


    private Long id;

    public DefaultRequest() {
    }

    public DefaultRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
