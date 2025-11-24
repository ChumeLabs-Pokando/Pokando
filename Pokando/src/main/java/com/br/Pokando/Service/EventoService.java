package com.br.Pokando.Service;

import com.br.Pokando.Mapper.EventoMapper;
import com.br.Pokando.dto.EventoRequest;
import com.br.Pokando.dto.EventoResponse;
import com.br.Pokando.model.Evento;
import com.br.Pokando.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoService extends ServiceAdapter<Evento, Long, EventoResponse, EventoRequest, EventoRequest> {

    private final ClienteRepository clienteRepository;
    private final IngressoRepository ingressoRepository;



    public EventoService(UserAcessoRepository userAcessoRepository, EventoRepository repository, EventoMapper mapper, ClienteRepository clienteRepository, IngressoRepository ingressoRepository) {
        super(repository,mapper);
        this.clienteRepository = clienteRepository;
        this.ingressoRepository = ingressoRepository;
    }

    @Override
    @Transactional
    public Evento create(EventoRequest request) {
        var entity = ((EventoMapper) mapper).toEntity(request, clienteRepository, ingressoRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Evento salvo"));
    }

}
