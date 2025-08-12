package com.br.Pokando.Mapper;

import com.br.Pokando.dto.TelefoneRequest;
import com.br.Pokando.dto.TelefoneResponse;
import com.br.Pokando.dto.TelefoneRequest;
import com.br.Pokando.dto.TelefoneResponse;
import com.br.Pokando.model.Telefone;
import com.br.Pokando.model.Usuario;
import com.br.Pokando.model.Telefone;
import com.br.Pokando.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TelefoneMapper implements IMapper<Telefone, TelefoneResponse, TelefoneRequest, TelefoneRequest>{
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public TelefoneResponse toDto(
            Telefone entity
    ) {
        TelefoneResponse dto = new TelefoneResponse(entity.getId());
        dto.setNumero(entity.getNumero());

        if (entity.getUsuario() != null) {
            dto.setUsuario(UsuarioMapper.toDto(entity.getUsuario()));
        }
        return dto;
    }

    @Override
    public List<TelefoneResponse> toListDto(
            List<Telefone> list
    ) {
        return list.stream()
                .map((entity) -> toDto(entity))
                .collect(Collectors.toList());
    }


    public Telefone toEntity(TelefoneRequest request, UsuarioRepository UsuarioRepository) {
        var entity = new Telefone();
        entity.setNumero(request.getNumero());


        if (request.getUsuario() != null) {
            var Usuario = UsuarioRepository
                    .findById(request.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
            entity.setUsuario(Usuario);
        }
        return entity;
    }
    @Override
    public Telefone toEntity(TelefoneRequest request) {
        var entity = new Telefone();
        entity.setNumero(request.getNumero());


        if (request.getUsuario() != null && request.getUsuario().getId() != null) {
            Usuario Usuario = UsuarioRepository.findById(request.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
            entity.setUsuario(Usuario);
        }
        return entity;
    }

    @Override
    public Telefone update(TelefoneRequest request, Telefone entity) {
        entity.setNumero(request.getNumero());


        if (request.getUsuario() != null && request.getUsuario().getId() != null) {
            Usuario Usuario = UsuarioRepository.findById(request.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
            entity.setUsuario(Usuario);
        }
        return entity;
    }
}

