package com.br.Pokando.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaisResponse extends DefaultResponse{

    private String nome;

    private String sigla;

    public PaisResponse(Long id) {
        super(id);
    }
    public PaisResponse(Long id, String nome, String sigla) {
        super(id);
        this.nome = nome;
        this.sigla = sigla;
    }

}
