package com.br.Pokando.dto;

import com.br.Pokando.dto.annotation.OptionalNotBlank;
import com.br.Pokando.model.StatusEvento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class EventoRequestUpdate extends DefaultRequest{
    @OptionalNotBlank
    private String nome;
    @OptionalNotBlank
    private String descricao;

    private StatusEvento status;

    private Date dataHora;

    private Boolean autorizado;

    private Double limiteInscricoes;

    private List<Long> clienteId;

    private List<Long> organizadorId;

    private List<Long> ingressoId;

    public EventoRequestUpdate(Long id) {
        super(id);

    }

}
