package com.br.Pokando.dto;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizadorDetalhadoResponse extends DefaultResponse {

    private Long id;
    private String nome;
    private String email;
    private List<EventoDetalhadoResponse> eventos;
}
