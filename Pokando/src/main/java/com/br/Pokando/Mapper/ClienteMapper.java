package com.br.Pokando.Mapper;

import com.br.Pokando.dto.ClienteRequest;
import com.br.Pokando.dto.ClienteRequestUpdate;
import com.br.Pokando.dto.ClienteResponse;
import com.br.Pokando.model.UserAcesso;
import com.br.Pokando.model.Evento;
import com.br.Pokando.model.Cliente;
import com.br.Pokando.repository.EventoRepository;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ClienteMapper implements IMapper<Cliente, ClienteResponse, ClienteRequest, ClienteRequestUpdate> {

    private final UserAcessoMapper userAcessoMapper;
    private final UserAcessoRepository userAcessoRepository;
    private final EventoRepository eventoRepository;

    public ClienteMapper(
            UserAcessoMapper userAcessoMapper,
            UserAcessoRepository userAcessoRepository, EventoRepository eventoRepository
    ) {
        this.userAcessoMapper = userAcessoMapper;
        this.userAcessoRepository = userAcessoRepository;
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

        if (entity.getUserAcesso() != null && !entity.getUserAcesso().isEmpty()) {
            dto.setUserAcessoResponse(
                    entity.getUserAcesso().stream()
                            .map(userAcessoMapper::toDto)
                            .collect(Collectors.toList())
            );
        }
        if (dto.getEventoClienteId() != null && !dto.getEventoClienteId().isEmpty()) {
            List<Evento> eventos = dto.getEventoClienteId().stream()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento vinculado a um cliente não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoClienteEvento(eventos);
        }
        if (dto.getEventoOrganizadorId() != null && !dto.getEventoOrganizadorId().isEmpty()) {
            List<Evento> eventos = dto.getEventoOrganizadorId().stream()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento vinculado a um organizador não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoOrganizadorEvento(eventos);
        }


        return dto;
    }


    public Cliente toEntity(ClienteRequest dto,
                            UserAcessoRepository userAcessoRepository) {
        var entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setCpf(dto.getCpf());
        entity.setCnpj(dto.getCnpj());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setFoto(dto.getFoto());

        if (dto.getUserAcessosIds() != null && !dto.getUserAcessosIds().isEmpty()) {
            List<UserAcesso> acessos = dto.getUserAcessosIds().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setUserAcesso(acessos);
        }
        if (dto.getEventoClienteId() != null && !dto.getEventoClienteId().isEmpty()) {
            List<Evento> eventos = dto.getEventoClienteId().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoClienteEvento(eventos);
        }
        if (dto.getEventoOrganizadorId() != null && !dto.getEventoOrganizadorId().isEmpty()) {
            List<Evento> eventos = dto.getEventoOrganizadorId().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoOrganizadorEvento(eventos);
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

        if (dto.getUserAcessosIds() != null && !dto.getUserAcessosIds().isEmpty()) {
            List<UserAcesso> acessos = dto.getUserAcessosIds().stream()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setUserAcesso(acessos);
        }
        if (dto.getEventoClienteId() != null && !dto.getEventoClienteId().isEmpty()) {
            List<Evento> eventos = dto.getEventoClienteId().stream()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoClienteEvento(eventos);
        }
        if (dto.getEventoOrganizadorId() != null && !dto.getEventoOrganizadorId().isEmpty()) {
            List<Evento> eventos = dto.getEventoOrganizadorId().stream()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setAcessoOrganizadorEvento(eventos);
        }

        return entity;
    }

    public Cliente update(ClienteRequestUpdate request, Cliente entity) {
        if (request.getNome() != null) entity.setNome(request.getNome());
        if (request.getNickname() != null) entity.setNickname(request.getNickname());
        if (request.getCpf() != null) entity.setCpf(request.getCpf());
        if (request.getCnpj() != null) entity.setCnpj(request.getCnpj());
        if (request.getEmail() != null) entity.setEmail(request.getEmail());
        if (request.getSenha() != null) entity.setSenha(request.getSenha());
        if (request.getDataNascimento() != null) entity.setDataNascimento(request.getDataNascimento());
        if (request.getFoto() != null) entity.setFoto(request.getFoto());

        if (request.getUserAcessosIds() != null) {
            List<UserAcesso> acessos = request.getUserAcessosIds().stream()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id)))
                    .collect(Collectors.toList());

            entity.setUserAcesso(acessos);
        }

        if (request.getEventoClienteId() != null) {
            List<Evento> eventos = request.getEventoClienteId().stream()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());

            entity.setAcessoClienteEvento(eventos);
        }

        if (request.getEventoOrganizadorId() != null) {
            List<Evento> eventos = request.getEventoOrganizadorId().stream()
                    .map(id -> eventoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Evento não encontrado com ID " + id)))
                    .collect(Collectors.toList());

            entity.setAcessoOrganizadorEvento(eventos);
        }

        return entity;
    }


    public List<ClienteResponse> toListDto(List<Cliente> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }
}
