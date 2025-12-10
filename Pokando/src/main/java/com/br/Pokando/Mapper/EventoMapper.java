package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EventoDetalhadoResponse;
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
    private final ClienteRepository clienteRepository;
    private final IngressoRepository ingressoRepository;

    public EventoMapper(ClienteMapper clienteMapper, IngressoMapper ingressoMapper, ClienteRepository clienteRepository, IngressoRepository ingressoRepository) {
        this.clienteMapper = clienteMapper;

        this.ingressoMapper = ingressoMapper;

        this.clienteRepository = clienteRepository;
        this.ingressoRepository = ingressoRepository;
    }


    @Override
    public EventoResponse toDto(Evento event) {
        if (event == null) return null;

        EventoResponse dto = EventoResponse.builder()
                .id(event.getId())
                .nome(event.getNome())
                .descricao(event.getDescricao())
                .dataHora(event.getDataHora())
                .autorizado(event.getAutorizado())
                .limiteInscricoes(event.getLimiteInscricoes())
                .local(event.getLocal())
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
        entity.setAutorizado(dto.getAutorizado());
        entity.setLimiteInscricoes(dto.getLimiteInscricoes());
        entity.setLocal(dto.getLocal());

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
        entity.setAutorizado(dto.getAutorizado());
        entity.setLimiteInscricoes(dto.getLimiteInscricoes());
        entity.setLocal(dto.getLocal());

        return entity;
    }

    @Override
    public Evento update(EventoRequestUpdate request, Evento entity) {

        if (request.getNome() != null)
            entity.setNome(request.getNome());

        if (request.getDescricao() != null)
            entity.setDescricao(request.getDescricao());

        if (request.getStatus() != null)
            entity.setStatusEvento(request.getStatus());

        if (request.getDataHora() != null)
            entity.setDataHora(request.getDataHora());

        if (request.getAutorizado() != null)
            entity.setAutorizado(request.getAutorizado());

        if (request.getLimiteInscricoes() != null)
            entity.setLimiteInscricoes(request.getLimiteInscricoes());

        if (request.getLocal() != null)
            entity.setLocal(request.getLocal());


        if (request.getClienteId() != null) {
            if (request.getClienteId().isEmpty()) {
                entity.setCliente(null);
            } else {
                List<Cliente> clientes = request.getClienteId().stream()
                        .filter(Objects::nonNull)
                        .distinct()
                        .map(id -> clienteRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID " + id)))
                        .collect(Collectors.toList());

                entity.setCliente(clientes);
            }
        }


        if (request.getOrganizadorId() != null) {
            if (request.getOrganizadorId().isEmpty()) {
                entity.setOrganizador(null);
            } else {
                List<Cliente> organizadores = request.getOrganizadorId().stream()
                        .filter(Objects::nonNull)
                        .distinct()
                        .map(id -> clienteRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Organizador não encontrado com ID " + id)))
                        .collect(Collectors.toList());

                entity.setOrganizador(organizadores);
            }
        }


        if (request.getIngressoId() != null) {
            if (request.getIngressoId().isEmpty()) {
                entity.setIngresso(null);
            } else {
                List<Ingresso> ingressos = request.getIngressoId().stream()
                        .filter(Objects::nonNull)
                        .distinct()
                        .map(id -> ingressoRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Ingresso não encontrado com ID " + id)))
                        .collect(Collectors.toList());

                entity.setIngresso(ingressos);
            }
        }


        return entity;
    }




    public List<EventoResponse> toListDto(List<Evento> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }

    
}
