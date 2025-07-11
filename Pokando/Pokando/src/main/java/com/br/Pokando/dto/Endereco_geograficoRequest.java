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
public class Endereco_geograficoRequest extends DefaultRequest{

    @NotNull
    @NotEmpty
    @NotBlank
    public String longitude;
    @NotNull
    @NotEmpty
    @NotBlank
    public String latitude;

    public Endereco_geograficoRequest(Long id) {
        super(id);

    }
}
