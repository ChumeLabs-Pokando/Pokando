package com.br.Pokando.Service;

import com.br.Pokando.Mapper.Endereco_geograficoMapper;
import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.dto.Endereco_geograficoRequest;
import com.br.Pokando.dto.Endereco_geograficoResponse;
import com.br.Pokando.model.Endereco_geografico;
import com.br.Pokando.repository.Endereco_geograficoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class Endereco_geograficoService extends ServiceAdapter<Endereco_geografico, Long, Endereco_geograficoResponse, Endereco_geograficoRequest, Endereco_geograficoRequest>{

    public Endereco_geograficoService(Endereco_geograficoRepository repository, Endereco_geograficoMapper mapper) {
        super(repository, mapper);
    }
}
