package com.br.Pokando.Service;


import com.br.Pokando.Mapper.CidadeMapper;
import com.br.Pokando.dto.CidadeRequest;
import com.br.Pokando.dto.CidadeResponse;
import com.br.Pokando.model.Cidade;
import com.br.Pokando.repository.CidadeRepository;
import com.br.Pokando.repository.EstadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CidadeService
        extends ServiceAdapter<Cidade, Long, CidadeResponse, CidadeRequest,CidadeRequest>{
    private final EstadoRepository estadoRepository;

    public CidadeService(CidadeRepository CidadeRepository, CidadeMapper CidadeMapper, EstadoRepository estadoRepository) {
        super(CidadeRepository, CidadeMapper);
        this.estadoRepository = estadoRepository;
    }

    @Override
    @Transactional
    public Cidade create(CidadeRequest request) {
        var entity = ((CidadeMapper) mapper).toEntity(request, estadoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar endereço salvo"));
    }
}
