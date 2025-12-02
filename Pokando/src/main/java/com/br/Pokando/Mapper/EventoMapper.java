package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EventoRequest;
import com.br.Pokando.dto.EventoRequestUpdate;
import com.br.Pokando.dto.EventoResponse;
import com.br.Pokando.model.*;
import com.br.Pokando.model.Cliente;
import com.br.Pokando.repository.ClienteRepository;
import com.br.Pokando.repository.IngressoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class EventoMapper implements IMapper<Evento, EventoResponse, EventoRequest, EventoRequestUpdate> {

    private final ClienteMapper clienteMapper;

    private final IngressoMapper ingressoMapper;


    public EventoMapper(ClienteMapper clienteMapper, IngressoMapper ingressoMapper) {
        this.clienteMapper = clienteMapper;

        this.ingressoMapper = ingressoMapper;

    }


    @Override
    public EventoResponse toDto(Evento event) {
        if (event == null) return null;

        EventoResponse dto = EventoResponse.builder()
                .id(event.getId())
                .nome(event.getNome())
                .descricao(event.getDescricao())
                .dataHora(event.getDataHora())
                .autorizado(event.isAutorizado())
                .limiteInscricoes(event.getLimiteInscricoes())
                .statusEvento(event.getStatusEvento())

                .clienteIds(event.getCliente() != null
                        ? event.getCliente().stream().map(Cliente::getId).collect(Collectors.toList())
                        : null)
                .organizadorIds(event.getOrganizador() != null
                        ? event.getOrganizador().stream().map(Cliente::getId).collect(Collectors.toList())
                        : null)
                .ingressoIds(event.getIngresso() != null
                        ? event.getIngresso().stream().map(Ingresso::getId).collect(Collectors.toList())
                        : null)
                .build();

        return dto;
    }

    public Evento toEntity(EventoRequest dto, ClienteRepository clienteRepository, IngressoRepository ingressoRepository) {
        var entity = new Evento();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setStatusEvento(dto.getStatus());
        entity.setDataHora(dto.getDataHora());
        entity.setAutorizado(dto.isAutorizado());
        entity.setLimiteInscricoes(dto.getLimiteInscricoes());

        if (dto.getClienteId() != null && !dto.getClienteId().isEmpty()) {
            List<Cliente> clientes = dto.getClienteId().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> clienteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setCliente(clientes);
        }
        if (dto.getOrganizadorId() != null && !dto.getOrganizadorId().isEmpty()) {
            List<Cliente> organizadores = dto.getOrganizadorId().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> clienteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Organziador não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setOrganizador(organizadores);
        }
        if (dto.getIngressoId() != null && !dto.getIngressoId().isEmpty()) {
            List<Ingresso> ingressos = dto.getIngressoId().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> ingressoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Ingresso não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setIngresso(ingressos);
        }




        return entity;
    }

    @Override
    public Evento toEntity(EventoRequest dto) {
        Evento entity = new Evento(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setStatusEvento(dto.getStatus());
        entity.setDataHora(dto.getDataHora());
        entity.setAutorizado(dto.isAutorizado());
        entity.setLimiteInscricoes(dto.getLimiteInscricoes());
        return entity;
    }

    @Override
    public Evento update(EventoRequestUpdate request, Evento entity) {
        entity.setNome(request.getNome());
        entity.setDescricao(request.getDescricao());
        entity.setStatusEvento(request.getStatus());
        entity.setDataHora(request.getDataHora());
        entity.setAutorizado(request.isAutorizado());
        entity.setLimiteInscricoes(request.getLimiteInscricoes());
        return entity;
    }



    public List<EventoResponse> toListDto(List<Evento> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }

    
}
