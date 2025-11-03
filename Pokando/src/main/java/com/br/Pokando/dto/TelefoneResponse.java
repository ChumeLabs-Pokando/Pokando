package com.br.Pokando.dto;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class TelefoneResponse extends DefaultResponse{

    private String numero;

    private ClienteResponse cliente;

//    private OrganizadorResponse organizador;
//
//    private ProprietarioResponse proprietario;

    public TelefoneResponse(Long id) {
        super(id);
    }

    public TelefoneResponse(String numero, ClienteResponse cliente) {
        this.numero = numero;
        this.cliente = cliente;

    }
}
