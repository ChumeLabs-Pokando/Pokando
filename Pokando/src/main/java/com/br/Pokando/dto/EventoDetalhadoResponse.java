package com.br.Pokando.dto;

import com.br.Pokando.model.StatusEvento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class EventoDetalhadoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private Date dataHora;
    private boolean autorizado;
    private double limiteInscricoes;
    private StatusEvento statusEvento;

    private List<OrganizadorDetalhadoResponse> organizadores;
}
