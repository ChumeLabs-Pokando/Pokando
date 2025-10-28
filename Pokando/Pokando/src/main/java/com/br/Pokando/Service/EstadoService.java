package com.br.Pokando.Service;


import com.br.Pokando.Mapper.EstadoMapper;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.Estado;

import com.br.Pokando.repository.EstadoRepository;
import com.br.Pokando.repository.PaisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoService
        extends ServiceAdapter<Estado, Long, EstadoResponse, EstadoRequest,EstadoRequest>{

    private final PaisRepository paisRepository;

    public EstadoService(EstadoRepository repository, EstadoMapper mapper, PaisRepository paisRepository) {
        super(repository, mapper);
        this.paisRepository = paisRepository;
    }


    @Override
    @Transactional
    public Estado create(EstadoRequest request) {
        var entity = ((EstadoMapper) mapper).toEntity(request, paisRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar estado salvo"));
    }
}
