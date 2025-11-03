package com.br.Pokando.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngressoRequest  extends DefaultRequest{


    @NotNull(message = "quantidade não pode ser nulo.")
    @Size(min = 1, max = 4)
    private double quantidade;
    @NotNull
    private boolean status;
    @NotNull
    private boolean presenca;
    @NotNull
    private LocalDate dataPedido;
    @NotNull
    private LocalDate dataPagamento;
    @NotNull
    private boolean gratuito;
    @NotNull(message = "Cartegoria do ingresso não pode ser nulo.")
    private CategoriaIngressoRequest categoriaIngressoRequest;
    @NotNull(message = "pagamento não pode ser nulo.")
    private PagamentoRequest pagamentoRequest;
    @NotNull(message = "evento não pode ser nulo.")
    private List<Long> eventoId;

}
