/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Service;

import com.br.Pokando.Mapper.EnderecoMapper;
import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.repository.EnderecoRepository;
import com.br.Pokando.repository.EstadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author felip
 */
@Service
public class EnderecoService extends ServiceAdapter<Endereco, Long, EnderecoResponse, EnderecoRequest, EnderecoRequest> {

    private final EstadoRepository estadoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoMapper enderecoMapper, EstadoRepository estadoRepository) {
        super(enderecoRepository, enderecoMapper);
        this.estadoRepository = estadoRepository;
    }

    @Override
    @Transactional
    public Endereco create(EnderecoRequest request) {
        var entity = ((EnderecoMapper) mapper).toEntity(request, estadoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar endereço salvo"));
    }

}