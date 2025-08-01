package com.br.Pokando.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CidadeResponse extends DefaultResponse{

    private String nome;

    public CidadeResponse(Long id) {
        super(id);
    }
    public CidadeResponse(Long id, String nome) {
        super(id);
        this.nome = nome;
    }

}
