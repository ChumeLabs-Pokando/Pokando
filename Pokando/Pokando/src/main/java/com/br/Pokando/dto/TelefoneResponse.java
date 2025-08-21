package com.br.Pokando.dto;


import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
public class TelefoneResponse extends DefaultResponse{

    private String numero;

    private UsuarioResponse usuario;

    public TelefoneResponse(Long id) {
        super(id);
    }

    public TelefoneResponse(String numero, UsuarioResponse usuario) {
        this.numero = numero;
        this.usuario = usuario;
    }
}
