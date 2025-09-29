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

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizadorRequest  extends DefaultRequest{

    @NotNull(message = "O campo NOME deve ser informado!")
    @NotEmpty(message = "O campo NOME não deve estar vazio!")
    @NotBlank(message = "O campo NOME não deve conter somente ESPAÇO VAZIO!")
    @Size(min = 1, max = 255, message = "Limite de caracteres para o campo NOME.")
    private String nome;
    @NotNull
    @NotEmpty
    @NotBlank
    private String nickname;
    @NotNull(message = "O campo email deve ser informado!")
    @NotEmpty(message = "O campo email não deve estar vazio!")
    @NotBlank(message = "O campo email não deve conter somente ESPAÇO VAZIO!")
    @Size(min = 1, max = 255)
    private String email;
    @NotNull
    @NotEmpty
    @NotBlank
    private String senha;
    @NotNull
    @NotEmpty
    @NotBlank
    private UserAcessoRequest userAcessoRequest;
    @NotNull
    @NotEmpty
    @NotBlank
    private Date dataNascimento;
    @NotNull
    @NotEmpty
    @NotBlank
    private String foto;
    @NotNull(message = "O campo CPF deve ser informado!")
    @NotEmpty(message = "O campo CPF não deve estar vazio!")
    @NotBlank(message = "O campo CPF não deve conter somente ESPAÇO VAZIO!")
    @Size(min = 1, max = 255)
    private String cpf;
    @NotNull(message = "O campo cnpj deve ser informado!")
    @NotEmpty(message = "O campo cnpj não deve estar vazio!")
    @NotBlank(message = "O campo cnpj não deve conter somente ESPAÇO VAZIO!")
    @Size(min = 1, max = 255)
    private String cnpj;




    public OrganizadorRequest(Long id) {
        super(id);

    }
}
