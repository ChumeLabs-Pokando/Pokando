package com.br.Pokando.Service;


import com.br.Pokando.Mapper.OrganizadorMapper;
import com.br.Pokando.dto.OrganizadorRequest;
import com.br.Pokando.dto.OrganizadorResponse;
import com.br.Pokando.model.Organizador;
import com.br.Pokando.repository.EventoRepository;
import com.br.Pokando.repository.OrganizadorRepository;

import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizadorService  extends ServiceAdapter<Organizador, Long, OrganizadorResponse, OrganizadorRequest,OrganizadorRequest>{

    private final UserAcessoRepository userAcessoRepository;
    private final EventoRepository eventoRepository;

    public OrganizadorService(OrganizadorRepository repository, OrganizadorMapper mapper, UserAcessoRepository userAcessoRepository, EventoRepository eventoRepository) {
        super(repository, mapper);
        this.userAcessoRepository = userAcessoRepository;
        this.eventoRepository = eventoRepository;
    }


    @Override
    @Transactional
    public Organizador create(OrganizadorRequest request) {
        var entity = ((OrganizadorMapper) mapper).toEntity(request, userAcessoRepository, eventoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Organizador salvo"));
    }
}
