package com.br.Pokando.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngressoResponse extends DefaultResponse{

    private double quantidade;

    private boolean status;

    private boolean presenca;

    private LocalDate dataPedido;

    private LocalDate dataPagamento;

    private boolean gratuito;

   private Categoria_ingressoResponse categoriaIngressoResponse;

    private PagamentoResponse pagamentoResponse;

    private List<EventoResponse> eventoResponse;

    public IngressoResponse(double quantidade, PagamentoResponse pagamentoResponse, List<EventoResponse> eventoResponse, Categoria_ingressoResponse categoriaIngressoResponse, boolean gratuito, LocalDate dataPagamento, LocalDate dataPedido, boolean presenca, boolean status) {
        this.quantidade = quantidade;
        this.pagamentoResponse = pagamentoResponse;
        this.eventoResponse = eventoResponse;
        this.categoriaIngressoResponse = categoriaIngressoResponse;
        this.gratuito = gratuito;
        this.dataPagamento = dataPagamento;
        this.dataPedido = dataPedido;
        this.presenca = presenca;
        this.status = status;
    }

    public IngressoResponse(Long id, double quantidade, PagamentoResponse pagamentoResponse, List<EventoResponse> eventoResponse, Categoria_ingressoResponse categoriaIngressoResponse, boolean gratuito, LocalDate dataPagamento, LocalDate dataPedido, boolean presenca, boolean status) {
        super(id);
        this.quantidade = quantidade;
        this.pagamentoResponse = pagamentoResponse;
        this.eventoResponse = eventoResponse;
        this.categoriaIngressoResponse = categoriaIngressoResponse;
        this.gratuito = gratuito;
        this.dataPagamento = dataPagamento;
        this.dataPedido = dataPedido;
        this.presenca = presenca;
        this.status = status;
    }
}
