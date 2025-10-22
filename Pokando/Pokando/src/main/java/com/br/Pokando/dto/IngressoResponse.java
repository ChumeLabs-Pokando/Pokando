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

   private Categoria_ingressoResponse categoriaIngresso;

    private PagamentoResponse pagamento;

    private List<EventoResponse> eventoResponse;


}
