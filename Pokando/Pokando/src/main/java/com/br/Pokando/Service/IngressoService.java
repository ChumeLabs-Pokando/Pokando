package com.br.Pokando.Service;

import com.br.Pokando.Mapper.IngressoMapper;
import com.br.Pokando.dto.IngressoRequest;
import com.br.Pokando.dto.IngressoResponse;
import com.br.Pokando.model.Ingresso;
import com.br.Pokando.repository.Categoria_ingressoRepository;
import com.br.Pokando.repository.IngressoRepository;
import com.br.Pokando.repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IngressoService extends ServiceAdapter<Ingresso, Long, IngressoResponse, IngressoRequest,IngressoRequest>{

    private final Categoria_ingressoRepository categoriaIngressoRepository;
    private final PagamentoRepository pagamentoRepository;

    public IngressoService(IngressoRepository repository, IngressoMapper mapper, Categoria_ingressoRepository categoriaIngressoRepository, PagamentoRepository pagamentoRepository) {
        super(repository, mapper);
        this.categoriaIngressoRepository = categoriaIngressoRepository;
        this.pagamentoRepository = pagamentoRepository;
    }


    @Override
    @Transactional
    public Ingresso create(IngressoRequest request) {
        var entity = ((IngressoMapper) mapper).toEntity(request, categoriaIngressoRepository, pagamentoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Ingresso salvo"));
    }
}
