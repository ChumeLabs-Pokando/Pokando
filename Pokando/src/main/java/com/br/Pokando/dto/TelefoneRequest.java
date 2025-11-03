package com.br.Pokando.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneRequest  extends DefaultRequest {

    @NotNull(message = "Numero do telefone não pode ser nulo.")
    private String numero;

    @NotNull(message = "Cliente não pode ser nulo.")
    private ClienteRequest clienteRequest;

//    @NotNull(message = "Organizador não pode ser nulo.")
//    private OrganizadorRequest organizadorRequest;
//
//    @NotNull(message = "Proprietario não pode ser nulo.")
//    private ProprietarioRequest proprietarioRequest;

    public TelefoneRequest(Long id) {
        super(id);

    }
}
