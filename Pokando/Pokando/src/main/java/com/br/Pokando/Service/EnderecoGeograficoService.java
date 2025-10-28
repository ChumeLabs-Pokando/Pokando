package com.br.Pokando.Service;

import com.br.Pokando.Mapper.EnderecoGeograficoMapper;
import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.dto.EnderecoGeograficoRequest;
import com.br.Pokando.dto.EnderecoGeograficoResponse;
import com.br.Pokando.model.EnderecoGeografico;
import com.br.Pokando.repository.EnderecoGeograficoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EnderecoGeograficoService extends ServiceAdapter<EnderecoGeografico, Long, EnderecoGeograficoResponse, EnderecoGeograficoRequest, EnderecoGeograficoRequest>{

    public EnderecoGeograficoService(EnderecoGeograficoRepository repository, EnderecoGeograficoMapper mapper) {
        super(repository, mapper);
    }
}
