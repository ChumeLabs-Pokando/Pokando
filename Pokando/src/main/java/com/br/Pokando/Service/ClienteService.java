/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Service;

import com.br.Pokando.Mapper.ClienteMapper;
import com.br.Pokando.dto.ClienteRequest;
import com.br.Pokando.dto.ClienteRequestUpdate;
import com.br.Pokando.dto.ClienteResponse;

import com.br.Pokando.model.Cliente;
import com.br.Pokando.repository.ClienteRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 05029689150
 */
@Service
public class ClienteService extends ServiceAdapter<Cliente, Long, ClienteResponse, ClienteRequest, ClienteRequest> {


    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        super(repository,mapper);


    }

    @Override
    @Transactional
    public Cliente create(ClienteRequest request) {
        var entity = ((ClienteMapper) mapper).toEntity(request);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Cliente salvo"));
    }

}
