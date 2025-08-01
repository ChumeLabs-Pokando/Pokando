/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Service;

import com.br.Pokando.Mapper.EnderecoMapper;
import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.repository.CidadeRepository;
import com.br.Pokando.repository.EnderecoRepository;
import com.br.Pokando.repository.Endereco_geograficoRepository;
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
    private final Endereco_geograficoRepository endereco_geograficoRepository;
    private final CidadeRepository cidadeRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoMapper enderecoMapper, EstadoRepository estadoRepository, Endereco_geograficoRepository endereco_geograficoRepository, CidadeRepository cidadeRepository) {
        super(enderecoRepository, enderecoMapper);
        this.estadoRepository = estadoRepository;
        this.endereco_geograficoRepository = endereco_geograficoRepository;
        this.cidadeRepository = cidadeRepository;
    }

    @Override
    @Transactional
    public Endereco create(EnderecoRequest request) {
        var entity = ((EnderecoMapper) mapper).toEntity(request, cidadeRepository, estadoRepository, endereco_geograficoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar endereço salvo"));
    }

}