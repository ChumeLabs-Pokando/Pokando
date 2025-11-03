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
public class EstadoResponse extends DefaultResponse{

    private String nome;

    private String sigla;

    private PaisResponse pais;

    public EstadoResponse(Long id) {
        super(id);
    }
    public EstadoResponse(Long id, String nome, String sigla, PaisResponse pais) {
        super(id);
        this.nome = nome;
        this.sigla = sigla;
        this.pais = pais;
    }

}
