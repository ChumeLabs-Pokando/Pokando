package com.br.Pokando.Mapper;

import com.br.Pokando.dto.EventoRequest;
import com.br.Pokando.dto.EventoResponse;
import com.br.Pokando.model.*;
import com.br.Pokando.model.Organizador;
import com.br.Pokando.model.heranca.Cliente;
import com.br.Pokando.repository.ClienteRepository;
import com.br.Pokando.repository.IngressoRepository;
import com.br.Pokando.repository.OrganizadorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class EventoMapper implements IMapper<Evento, EventoResponse, EventoRequest, EventoRequest> {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    private final OrganizadorMapper organizadorMapper;
    private final OrganizadorRepository organizadorRepository;

    private final IngressoMapper ingressoMapper;
    private final IngressoRepository ingressoRepository;

    public EventoMapper(ClienteMapper clienteMapper, ClienteRepository clienteRepository, OrganizadorMapper organizadorMapper, OrganizadorRepository organizadorRepository, IngressoMapper ingressoMapper, IngressoRepository ingressoRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
        this.organizadorMapper = organizadorMapper;
        this.organizadorRepository = organizadorRepository;
        this.ingressoMapper = ingressoMapper;
        this.ingressoRepository = ingressoRepository;
    }


    @Override
    public EventoResponse toDto(Evento entity) {
        EventoResponse dto = new EventoResponse(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setStatus(entity.getStatusEvento());
        dto.setDataHora(entity.getDataHora());
        dto.setAutorizado(entity.isAutorizado());
        dto.setLimiteInscricoes(entity.getLimiteInscricoes());

        if (entity.getCliente() != null) {
            dto.setClienteResponse(
                    entity.getCliente().stream()
                            .map(clienteMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public Evento toEntity(EventoRequest dto, ClienteRepository clienteRepository, OrganizadorRepository organizadorRepository, IngressoRepository ingressoRepository) {
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
            List<Organizador> organizadores = dto.getOrganizadorId().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> organizadorRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Organizador não encontrado com ID " + id)))
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

        if (dto.getClienteId() != null) {
            List<Cliente> clientes = dto.getClienteId().stream()
                    .map(id -> clienteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setCliente(clientes);
        }
        if (dto.getOrganizadorId() != null) {
            List<Organizador> organizadores = dto.getOrganizadorId().stream()
                    .map(id -> organizadorRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Organizador não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setOrganizador(organizadores);
        }
        if (dto.getIngressoId() != null) {
            List<Ingresso> ingressos = dto.getIngressoId().stream()
                    .map(id -> ingressoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Ingresso não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setIngresso(ingressos);
        }
        

        return entity;
    }

    @Override
    public Evento update(EventoRequest request, Evento entity) {
        entity.setNome(request.getNome());
        entity.setDescricao(request.getDescricao());
        entity.setStatusEvento(request.getStatus());
        entity.setDataHora(request.getDataHora());
        entity.setAutorizado(request.isAutorizado());
                
        if (request.getClienteId() != null) {
            List<Cliente> clientes = request.getClienteId().stream()
                    .map(id -> clienteRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setCliente(clientes);
        }
        if (request.getOrganizadorId() != null) {
            List<Organizador> organizadores = request.getOrganizadorId().stream()
                    .map(id -> organizadorRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Organizador não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setOrganizador(organizadores);
        }
        if (request.getIngressoId() != null) {
            List<Ingresso> ingressos = request.getIngressoId().stream()
                    .map(id -> ingressoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Ingresso não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setIngresso(ingressos);
        }

        return entity;
    }
    

    public List<EventoResponse> toListDto(List<Evento> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }


    
}
