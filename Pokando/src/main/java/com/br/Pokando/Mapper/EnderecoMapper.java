/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 *
 * @author felip
 */

// "componentModel" = mapeia e cria um bean pro spring poder instaciar ...
// "unmappedTargetPolicy" = se o target não encontrar um objeto que não foi mapeado ele devolve um erro...
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EnderecoMapper {
    
    
    //"Mapping" = o target define qual atributo eu vou gerenciar e o ignore ele ignora se esse atributo foi gravado no bd...
   // @Mapping(target = "complemento", ignore = true)
    //tranforma o JSON do front em uma entity pra gravar no banco...
    // da pra usar nos List<> tbm
    Endereco converterParaEntity(EnderecoRequest enderecoRequest);
    
    // Pega uma entity/model e transforma em JSON para mostrar no front..
    EnderecoResponse converterParaResponse(Endereco endereco);
    
}
