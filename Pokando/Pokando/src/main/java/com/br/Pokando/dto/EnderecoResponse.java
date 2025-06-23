/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author felip
 */
@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Reponse é oque eu vou devolver pro front, da pra tratar o que vai ser ocultado(no caso dados mais sensiveis)
public class EnderecoResponse {
    
    private String logradouro;
   
    private String cidade;
   
    private String numero;
    
    private String cep;
    
    private String bairro;
    
    private String complemento;
    
    
}
