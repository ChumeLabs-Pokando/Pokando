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
public class IngressoResponse extends DefaultResponse{

    private double quantidade;

    private boolean status;

    private boolean presenca;

    private LocalDate dataPedido;

    private LocalDate dataPagamento;

    private boolean gratuito;

   private CategoriaIngressoResponse categoriaIngressoResponse;

    private PagamentoResponse pagamentoResponse;

    private List<EventoResponse> eventoResponse;

    public IngressoResponse(Long id) {
        super(id);
    }

    public IngressoResponse(double quantidade, boolean status, boolean presenca, LocalDate dataPedido, LocalDate dataPagamento, boolean gratuito, CategoriaIngressoResponse categoriaIngressoResponse, PagamentoResponse pagamentoResponse, List<EventoResponse> eventoResponse) {
        this.quantidade = quantidade;
        this.status = status;
        this.presenca = presenca;
        this.dataPedido = dataPedido;
        this.dataPagamento = dataPagamento;
        this.gratuito = gratuito;
    }
}
