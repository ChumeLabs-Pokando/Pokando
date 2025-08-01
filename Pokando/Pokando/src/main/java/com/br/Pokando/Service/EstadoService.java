package com.br.Pokando.Service;


import com.br.Pokando.Mapper.EnderecoMapper;
import com.br.Pokando.Mapper.EstadoMapper;
import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Estado;
import com.br.Pokando.repository.EnderecoRepository;
import com.br.Pokando.repository.Endereco_geograficoRepository;
import com.br.Pokando.repository.EstadoRepository;
import com.br.Pokando.repository.PaisRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
