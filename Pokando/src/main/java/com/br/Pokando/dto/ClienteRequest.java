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
public class ClienteRequest extends DefaultRequest{

    @NotNull(message = "O campo Nome deve ser informado!")
    private String nome;
    @NotNull(message = "O campo Nickname deve ser informado!")
    private String nickname;
    @NotBlank
    @Size(max = 255)
    private String cpf;
    @NotBlank
    @Size(max = 255)
    private String cnpj;
    @NotNull(message = "O campo email deve ser informado!")
    private String email;
    @NotNull(message = "O campo senha deve ser informado!")
    private String senha;
    @NotNull(message = "UserAcesso não pode ser nulo.")
    private List<Long> userAcessosIds;
    @NotNull(message = "O campo dataNascimento deve ser informado!")
    private Date dataNascimento;
    @NotNull(message = "O campo foto deve ser informado!")
    private String foto;

    private List<Long> eventoClienteId;

    private List<Long> eventoOrganizadorId;

    public ClienteRequest(Long id) {
        super(id);

    }

}
