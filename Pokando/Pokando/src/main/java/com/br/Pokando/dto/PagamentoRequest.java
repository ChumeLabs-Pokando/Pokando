package com.br.Pokando.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoRequest extends DefaultRequest {

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String cpf;

    private String email;


    private String nomeCartao;

    @NotBlank
    private String numeroCartao;

    @NotNull
    private Date validadeCartao;

    public PagamentoRequest(Long id) {
        super(id);
    }
}