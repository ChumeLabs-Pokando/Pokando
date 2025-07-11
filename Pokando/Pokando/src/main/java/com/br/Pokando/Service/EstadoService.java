package com.br.Pokando.Service;


import com.br.Pokando.Mapper.EstadoMapper;
import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Estado;
import com.br.Pokando.repository.EstadoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService
        extends ServiceAdapter<Estado, Long, EstadoResponse, EstadoRequest,EstadoRequest>{


    public EstadoService(EstadoRepository repository, EstadoMapper mapper) {
        super(repository, mapper);
    }
}
