package com.br.Pokando.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizadorRequest  extends DefaultRequest{

    @NotBlank(message = "O campo NOME deve ser informado!")
    @Size(max = 255)
    private String nome;

    @NotBlank
    private String nickname;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    @NotNull(message = "UserAcesso não pode ser nulo.")
    private List<Long> userAcessosIds;

    @NotNull(message = "Data de nascimento não pode ser nula.")
    private Date dataNascimento;

    private String foto;

    @NotBlank
    @Size(max = 255)
    private String cpf;

    @NotBlank
    @Size(max = 255)
    private String cnpj;

    @NotNull(message = "evento não pode ser nulo.")
    private List<Long> eventoId;

    public OrganizadorRequest(Long id) {
        super(id);
    }
}
