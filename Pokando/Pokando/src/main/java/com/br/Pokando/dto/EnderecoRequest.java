/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.dto;

import com.br.Pokando.model.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author felip
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Request é o que eu vou receber do Front para gravar e gerenciar no back e no bd...
public class EnderecoRequest extends DefaultRequest {


    @NotNull
    @NotEmpty(message = "Logradouro não pode ser Vazio.")
    @NotBlank
    private String logradouro;

    private String cidade;

    private String numero;

    private String cep;

    private String bairro;

    private String complemento;

    @NotNull(message = "Estado não pode ser nulo.")
    private EstadoRequest estado;

    public EnderecoRequest(Long id) {
        super(id);

    }
}
