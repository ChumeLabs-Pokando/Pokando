/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Service;

import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Mapper.ClienteMapper;
import com.br.Pokando.dto.ClienteRequest;
import com.br.Pokando.dto.ClienteResponse;

import com.br.Pokando.model.heranca.Cliente;
import com.br.Pokando.repository.ClienteRepository;
import com.br.Pokando.repository.EventoRepository;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 05029689150
 */
@Service
public class ClienteService extends ServiceAdapter<Cliente, Long, ClienteResponse, ClienteRequest, ClienteRequest> {

    private final UserAcessoRepository userAcessoRepository;


    public ClienteService(UserAcessoRepository userAcessoRepository, ClienteRepository repository, ClienteMapper mapper) {
        super(repository,mapper);
        this.userAcessoRepository = userAcessoRepository;

    }

    @Override
    @Transactional
    public Cliente create(ClienteRequest request) {
        var entity = ((ClienteMapper) mapper).toEntity(request, userAcessoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Cliente salvo"));
    }

}
