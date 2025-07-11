package com.br.Pokando.dto;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CargoResponse extends DefaultResponse{

    private String nome;

    public CargoResponse(Long id) {
        super(id);
    }

    public CargoResponse(Long id, String nome) {
        super(id);
        this.nome = nome;

    }

}
