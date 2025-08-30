package com.br.Pokando.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria_ingressoRequest extends DefaultRequest{

    @NotNull
    @NotEmpty
    @NotBlank
    private String nome;
    @NotNull
    @NotEmpty
    @NotBlank
    private double preco;
    @NotNull
    @NotEmpty
    @NotBlank
    private boolean meiaEntrada;

    public Categoria_ingressoRequest(Long id) {
        super(id);

    }

}
