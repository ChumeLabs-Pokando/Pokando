package com.br.Pokando.Service;

import com.br.Pokando.Mapper.CategoriaIngressoMapper;
import com.br.Pokando.dto.CategoriaIngressoRequest;
import com.br.Pokando.dto.CategoriaIngressoResponse;
import com.br.Pokando.model.CategoriaIngresso;
import com.br.Pokando.repository.CategoriaIngressoRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaIngressoService
        extends ServiceAdapter<CategoriaIngresso, Long, CategoriaIngressoResponse, CategoriaIngressoRequest,CategoriaIngressoRequest>{


    public CategoriaIngressoService(CategoriaIngressoRepository repository, CategoriaIngressoMapper mapper) {
        super(repository, mapper);
    }
}