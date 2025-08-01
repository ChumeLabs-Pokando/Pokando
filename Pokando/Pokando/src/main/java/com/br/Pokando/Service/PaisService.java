package com.br.Pokando.Service;


import com.br.Pokando.Mapper.PaisMapper;
import com.br.Pokando.dto.PaisRequest;
import com.br.Pokando.dto.PaisResponse;
import com.br.Pokando.model.Pais;
import com.br.Pokando.repository.PaisRepository;
import org.springframework.stereotype.Service;

@Service
public class PaisService
        extends ServiceAdapter<Pais, Long, PaisResponse, PaisRequest,PaisRequest>{


    public PaisService(PaisRepository repository, PaisMapper mapper) {
        super(repository, mapper);
    }
}
