package com.br.Pokando.dto;


import com.br.Pokando.model.StatusEvento;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@SuperBuilder
@Getter
@Setter
public class EventoResponse extends DefaultResponse{

    private String nome;

    private String descricao;

    private Date dataHora;

    private boolean autorizado;

    private double limiteInscricoes;

    private StatusEvento statusEvento;

    private List<Long> clienteIds;
    private List<Long> organizadorIds;
    private List<Long> ingressoIds;


    public EventoResponse(Long id) {
        super(id);
    }

    public EventoResponse(String nome, String descricao, Date dataHora, boolean autorizado, double limiteInscricoes, StatusEvento statusEvento, List<Long> clienteIds, List<Long> organizadorIds, List<Long> ingressoIds) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.autorizado = autorizado;
        this.limiteInscricoes = limiteInscricoes;
        this.statusEvento = statusEvento;
        this.clienteIds = clienteIds;
        this.organizadorIds = organizadorIds;
        this.ingressoIds = ingressoIds;
    }
}
