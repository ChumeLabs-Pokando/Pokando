package com.br.Pokando.dto;

import com.br.Pokando.model.StatusEvento;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EventoRequest extends DefaultRequest{
    @NotNull(message = "O campo Nome deve ser informado!")
    private String nome;

    private String descricao;

    @NotNull(message = "O campo Status deve ser informado!")
    private StatusEvento status;
    @NotNull(message = "O campo Data deve ser informado!")
    private Date dataHora;
    @NotNull(message = "O campo autorizado deve ser informado!")
    private boolean autorizado;
    @NotNull(message = "O campo do limite de inscrições deve ser informado!")
    private double limiteInscricoes;
    @NotNull(message = "Cliente não pode ser nulo.")
    private List<Long> clienteId;
    @NotNull(message = "Organizador não pode ser nulo.")
    private List<Long> organizadorId;
    @NotNull(message = "Ingresso não pode ser nulo.")
    private List<Long> ingressoId;

    public EventoRequest(Long id) {
        super(id);

    }

}
