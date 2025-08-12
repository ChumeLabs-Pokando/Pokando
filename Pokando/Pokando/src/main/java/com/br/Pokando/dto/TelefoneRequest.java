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

    @NotNull(message = "Usuário não pode ser nulo.")
    private UsuarioRequest usuario;

    public TelefoneRequest(Long id) {
        super(id);

    }
}
