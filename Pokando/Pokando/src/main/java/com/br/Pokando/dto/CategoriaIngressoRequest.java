package com.br.Pokando.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@AllArgsConstructor
public class CategoriaIngressoRequest extends DefaultRequest{

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

    public CategoriaIngressoRequest(Long id) {
        super(id);

    }

  

   
}
