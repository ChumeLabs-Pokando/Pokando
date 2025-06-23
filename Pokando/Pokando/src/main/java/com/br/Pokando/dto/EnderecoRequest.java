/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.dto;

import jakarta.persistence.Column;
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
// Request é o que eu vou receber do Front para gravar e gerenciar no back e no bd...
public class EnderecoRequest {
    
  
    private String logradouro;
   
    private String cidade;
   
    private String numero;
    
    private String cep;
    
    private String bairro;
    
    private String complemento;
    
}
