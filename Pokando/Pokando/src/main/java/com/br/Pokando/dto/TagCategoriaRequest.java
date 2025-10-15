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
public class TagCategoriaRequest extends DefaultRequest{

    @NotNull
    @NotEmpty
    @NotBlank
    private String nome;

    public TagCategoriaRequest(Long id) {
        super(id);

    }

}
