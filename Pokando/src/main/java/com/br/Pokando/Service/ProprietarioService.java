package com.br.Pokando.Service;

import com.br.Pokando.Mapper.ProprietarioMapper;
import com.br.Pokando.dto.ProprietarioRequest;
import com.br.Pokando.dto.ProprietarioResponse;
import com.br.Pokando.model.Proprietario;
import com.br.Pokando.repository.ProprietarioRepository;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProprietarioService extends ServiceAdapter<Proprietario, Long, ProprietarioResponse, ProprietarioRequest,ProprietarioRequest>{

    private final UserAcessoRepository userAcessoRepository;

    public ProprietarioService(ProprietarioRepository repository, ProprietarioMapper mapper, UserAcessoRepository userAcessoRepository) {
        super(repository, mapper);
        this.userAcessoRepository = userAcessoRepository;
    }


    @Override
    @Transactional
    public Proprietario create(ProprietarioRequest request) {
        var entity = ((ProprietarioMapper) mapper).toEntity(request, userAcessoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Proprietario salvo"));
    }
}