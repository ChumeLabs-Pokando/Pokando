package com.br.Pokando.Service;


import com.br.Pokando.Mapper.OrganizadorMapper;
import com.br.Pokando.dto.OrganizadorDetalhadoResponse;
import com.br.Pokando.dto.OrganizadorRequest;
import com.br.Pokando.dto.OrganizadorResponse;
import com.br.Pokando.model.Organizador;
import com.br.Pokando.repository.EventoRepository;
import com.br.Pokando.repository.OrganizadorRepository;

import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizadorService  extends ServiceAdapter<Organizador, Long, OrganizadorResponse, OrganizadorRequest,OrganizadorRequest>{

    private final UserAcessoRepository userAcessoRepository;
    private final EventoRepository eventoRepository;
    private final OrganizadorRepository repo;
    private final OrganizadorMapper mapper;

    public OrganizadorService(OrganizadorRepository repository, OrganizadorMapper mapper, UserAcessoRepository userAcessoRepository, EventoRepository eventoRepository, OrganizadorRepository repo, OrganizadorMapper mapper1) {
        super(repository, mapper);
        this.userAcessoRepository = userAcessoRepository;
        this.eventoRepository = eventoRepository;
        this.repo = repo;
        this.mapper = mapper1;
    }


    @Override
    @Transactional
    public Organizador create(OrganizadorRequest request) {

        var organizador = mapper.toEntity(request);

        if (request.getUserAcessosIds() != null) {
            var acessos = userAcessoRepository.findAllById(request.getUserAcessosIds());
            organizador.setUserAcesso(acessos);
        }

        if (request.getEventoId() != null) {
            var eventos = eventoRepository.findAllById(request.getEventoId());
            organizador.setEvento(eventos);
        }

        return repository.save(organizador);
    }

    @Override
    @Transactional
    public Organizador update(Long id, OrganizadorRequest request) {

        var organizador = findBy(id);
        mapper.update(request, organizador);

        if (request.getUserAcessosIds() != null) {
            var acessos = userAcessoRepository.findAllById(request.getUserAcessosIds());
            organizador.setUserAcesso(acessos);
        }

        if (request.getEventoId() != null) {
            var eventos = eventoRepository.findAllById(request.getEventoId());
            organizador.setEvento(eventos);
        }

        return repository.save(organizador);
    }


    public List<OrganizadorResponse> listar() {
        return repo.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public OrganizadorResponse buscarPorId(Long id) {
        return mapper.toResponse(repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizador não encontrado")));
    }

    public OrganizadorDetalhadoResponse buscarDetalhado(Long id) {
        return mapper.toDetalhadoResponse(repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Organizador não encontrado")));
    }
}
