package com.br.Pokando.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse extends DefaultResponse{

    private String nome;

    private String nickname;

    private String cpf;

    private String cnpj;

    private String email;

    private String senha;

    private List<UserAcessoResponse> userAcessoResponse;

    private Date dataNascimento;

    private String foto;

    private List<Long> eventoClienteId;

    private List<Long> eventoOrganizadorId;

    public ClienteResponse(Long id) {
        super(id);
    }


}
