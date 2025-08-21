package com.br.Pokando.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest extends DefaultRequest{

    @NotNull(message = "O campo Nome deve ser informado!")
    private String nome;
    @NotNull(message = "O campo Nickname deve ser informado!")
    private String nickname;
    @NotNull(message = "O campo email deve ser informado!")
    private String email;
    @NotNull(message = "O campo senha deve ser informado!")
    private String senha;
    @NotNull(message = "UserAcesso não pode ser nulo.")
    private User_acessoRequest user_acesso;
    @NotNull(message = "O campo dataNascimento deve ser informado!")
    private Date dataNascimento;
    @NotNull(message = "O campo foto deve ser informado!")
    private String foto;

    public UsuarioRequest(Long id) {
        super(id);

    }

}
