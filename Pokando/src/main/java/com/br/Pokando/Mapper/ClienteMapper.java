package com.br.Pokando.Mapper;

import com.br.Pokando.dto.ClienteRequest;
import com.br.Pokando.dto.ClienteResponse;

import com.br.Pokando.model.Evento;
import com.br.Pokando.model.Cliente;
import com.br.Pokando.repository.EventoRepository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ClienteMapper implements IMapper<Cliente, ClienteResponse, ClienteRequest, ClienteRequest> {


    private final EventoRepository eventoRepository;

    public ClienteMapper(
   EventoRepository eventoRepository
    ) {

        this.eventoRepository = eventoRepository;
    }

    @Override
    public ClienteResponse toDto(Cliente entity) {
        ClienteResponse dto = new ClienteResponse(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNickname(entity.getNickname());
        dto.setCpf(entity.getCpf());
        dto.setCnpj(entity.getCnpj());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setFoto(entity.getFoto());






        if (entity.getAcessoClienteEvento() != null && !entity.getAcessoClienteEvento().isEmpty()) {
            dto.setEventoClienteId(
                    entity.getAcessoClienteEvento()
                            .stream()
                            .map(Evento::getId)
                            .collect(Collectors.toList())
            );
        }

        if (entity.getAcessoOrganizadorEvento() != null && !entity.getAcessoOrganizadorEvento().isEmpty()) {
            dto.setEventoOrganizadorId(
                    entity.getAcessoOrganizadorEvento()
                            .stream()
                            .map(Evento::getId)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }


    public Cliente toEntity(ClienteRequest dto, EventoRepository eventoRepository ) {
        var entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setCpf(dto.getCpf());
        entity.setCnpj(dto.getCnpj());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setFoto(dto.getFoto());

        if (dto.getEventoClienteId() != null && !dto.getEventoClienteId().isEmpty()) {
            List<Evento> eventos = dto.getEventoClienteId().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoClienteEvento(eventos);
        }

        return entity;
    }

    @Override
    public Cliente toEntity(ClienteRequest dto) {
        var entity = new Cliente(dto.getId());
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setCpf(dto.getCpf());
        entity.setCnpj(dto.getCnpj());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setFoto(dto.getFoto());

        if (dto.getEventoClienteId() != null && !dto.getEventoClienteId().isEmpty()) {
            List<Evento> eventos = dto.getEventoClienteId().stream()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoClienteEvento(eventos);
        }


        return entity;
    }

    @Override
    public Cliente update(ClienteRequest request, Cliente entity) {
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setCpf(request.getCpf());
        entity.setCnpj(request.getCnpj());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setFoto(request.getFoto());


        if (request.getEventoClienteId() != null && !request.getEventoClienteId().isEmpty()) {
            List<Evento> eventos = request.getEventoClienteId().stream()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoClienteEvento(eventos);
        }



        return entity;
    }

    public List<ClienteResponse> toListDto(List<Cliente> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }
}
