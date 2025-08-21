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

    private EstadoResponse estado;

    public CidadeResponse(Long id) {
        super(id);
    }
    public CidadeResponse(Long id, String nome, EstadoResponse estado) {
        super(id);
        this.nome = nome;
        this.estado = estado;
    }

}
