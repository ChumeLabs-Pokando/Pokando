package com.br.Pokando.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestUpdate extends DefaultRequest{


    private String nome;

    private String nickname;

    @Size(max = 255)
    private String cpf;

    @Size(max = 255)
    private String cnpj;

    private String email;

    private String senha;

    private List<Long> userAcessosIds;

    private Date dataNascimento;

    private String foto;

    private List<Long> eventoClienteId;

    private List<Long> eventoOrganizadorId;

    public ClienteRequestUpdate(Long id) {
        super(id);

    }

}
