/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.dto;

import com.br.Pokando.model.Cidade;
import com.br.Pokando.model.Estado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author felip
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
//Response é oque eu vou devolver pro front, da pra tratar o que vai ser ocultado(no caso dados mais sensiveis)
public class EnderecoResponse extends DefaultResponse{



    private String logradouro;
   
    private CidadeResponse cidade;
   
    private String numero;
    
    private String cep;
    
    private String bairro;
    
    private String complemento;

    private EstadoResponse estado;

    private Endereco_geograficoResponse endereco_geografico;

    public EnderecoResponse(Long id) {
        super(id);
    }
    public EnderecoResponse(Long id, String logradouro, CidadeResponse cidade, String numero, String cep, String bairro, String complemento, EstadoResponse estado, Endereco_geograficoResponse endereco_geografico) {
        super(id);
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.complemento = complemento;
        this.estado = estado;
        this.endereco_geografico = endereco_geografico;

    }


}
