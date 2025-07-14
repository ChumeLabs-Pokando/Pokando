package com.br.Pokando.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoResponse extends DefaultResponse{


    private String nomeCompleto;

    private String cpf;

    private String email;

    private String nomeCartao;

    private String numeroCartao;

    private Date validadeCartao;

    public PagamentoResponse(Long id) {
        super(id);

    }

    public PagamentoResponse(Long id, String nomeCompleto, String cpf, String email, String nomeCartao,String numeroCartao, Date validadeCartao) {
        super(id);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.nomeCartao = nomeCartao;
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
    }
}
