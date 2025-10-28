package com.br.Pokando.Service;

import com.br.Pokando.Mapper.CategoriaIngressoMapper;
import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.dto.CategoriaIngressoRequest;
import com.br.Pokando.dto.CategoriaIngressoResponse;
import com.br.Pokando.model.CategoriaIngresso;
import com.br.Pokando.repository.CategoriaIngressoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService extends ServiceAdapter<CategoriaIngresso, Long, CategoriaIngressoResponse, CategoriaIngressoRequest,CategoriaIngressoRequest>{


    public PagamentoService(JpaRepository<CategoriaIngresso, Long> repository, IMapper<CategoriaIngresso, CategoriaIngressoResponse, CategoriaIngressoRequest, CategoriaIngressoRequest> mapper) {
        super(repository, mapper);
    }
}
