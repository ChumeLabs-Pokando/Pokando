package com.br.Pokando.dto;

import com.br.Pokando.model.StatusEvento;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
public class EventoResponse extends DefaultResponse{
    private String nome;

    private String descricao;

    private StatusEvento status;

    private Date dataHora;

    private boolean autorizado;

    private double limiteInscricoes;

    private List<ClienteResponse> clienteResponse;

    private List<OrganizadorResponse> organizadorResponse;

    private List<IngressoResponse> ingressoResponse;


    public EventoResponse(Long id) {
        super(id);
    }

    public EventoResponse(String nome, String descricao, StatusEvento status, Date dataHora, boolean autorizado, double limiteInscricoes, List<ClienteResponse> clienteResponse, List<OrganizadorResponse> organizadorResponse, List<IngressoResponse> ingressoResponse) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dataHora = dataHora;
        this.autorizado = autorizado;
        this.limiteInscricoes = limiteInscricoes;
        this.clienteResponse = clienteResponse;
        this.organizadorResponse = organizadorResponse;
        this.ingressoResponse = ingressoResponse;
    }
}
