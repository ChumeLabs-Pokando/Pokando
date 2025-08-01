package com.br.Pokando.Service;


import com.br.Pokando.Mapper.CidadeMapper;
import com.br.Pokando.dto.CidadeRequest;
import com.br.Pokando.dto.CidadeResponse;
import com.br.Pokando.model.Cidade;
import com.br.Pokando.repository.CidadeRepository;
import org.springframework.stereotype.Service;

@Service
public class CidadeService
        extends ServiceAdapter<Cidade, Long, CidadeResponse, CidadeRequest,CidadeRequest>{


    public CidadeService(CidadeRepository repository, CidadeMapper mapper) {
        super(repository, mapper);
    }
}
