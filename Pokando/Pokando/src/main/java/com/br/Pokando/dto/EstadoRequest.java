package com.br.Pokando.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoRequest {

    @NotNull
    @NotEmpty
    @NotBlank
    public String nome;
    @NotNull
    @NotEmpty
    @NotBlank
    public String sigla;

}
