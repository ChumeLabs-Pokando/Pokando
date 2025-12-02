package com.br.Pokando.dto;

import com.br.Pokando.dto.annotation.OptionalNotBlank;
import com.br.Pokando.model.StatusEvento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EventoRequestUpdate extends DefaultRequest{
    @OptionalNotBlank
    private String nome;
    @OptionalNotBlank
    private String descricao;

    private StatusEvento status;
    @OptionalNotBlank
    private Date dataHora;
    @Size(min = 1, max = 5)
    private boolean autorizado;
    @Size(min = 1)
    private double limiteInscricoes;

    private List<Long> clienteId;

    private List<Long> organizadorId;

    private List<Long> ingressoId;

    public EventoRequestUpdate(Long id) {
        super(id);

    }

}
