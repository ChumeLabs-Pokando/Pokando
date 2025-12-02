package com.br.Pokando.dto;


import com.br.Pokando.dto.annotation.OptionalNotBlank;
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

    @OptionalNotBlank
    private String nome;
    @OptionalNotBlank
    private String nickname;
    @OptionalNotBlank
    @Size(max = 255)
    private String cpf;
    @OptionalNotBlank
    @Size(max = 255)
    private String cnpj;
    @OptionalNotBlank
    private String email;
    @OptionalNotBlank
    @Size(min = 8)
    private String senha;

    private List<Long> userAcessosIds;

    private Date dataNascimento;
    @OptionalNotBlank
    private String foto;

    private List<Long> eventoClienteId;

    private List<Long> eventoOrganizadorId;

    public ClienteRequestUpdate(Long id) {
        super(id);

    }

}
