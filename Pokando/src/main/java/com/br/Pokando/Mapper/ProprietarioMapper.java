package com.br.Pokando.Mapper;

import com.br.Pokando.dto.*;
import com.br.Pokando.dto.ProprietarioRequest;
import com.br.Pokando.dto.ProprietarioResponse;
import com.br.Pokando.model.*;
import com.br.Pokando.model.Proprietario;
import com.br.Pokando.model.Proprietario;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProprietarioMapper implements IMapper<Proprietario, ProprietarioResponse, ProprietarioRequest, ProprietarioRequest>{

    private final UserAcessoMapper userAcessoMapper;
    private final UserAcessoRepository userAcessoRepository;

    public ProprietarioMapper(UserAcessoMapper userAcessoMapper, UserAcessoRepository userAcessoRepository) {
        this.userAcessoMapper = userAcessoMapper;
        this.userAcessoRepository = userAcessoRepository;
    }


    @Override
    public ProprietarioResponse toDto(
            Proprietario entity
    ) {
        ProprietarioResponse dto = new ProprietarioResponse(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNickname(entity.getNickname());
        dto.setEmail(entity.getEmail());
        dto.setSenha(entity.getSenha());
        dto.setFoto(entity.getFoto());
        dto.setCpf(entity.getCpf());
        dto.setCnpj(entity.getCnpj());

        if (entity.getUserAcesso() != null) {
            dto.setUserAcessoResponse(
                    entity.getUserAcesso().stream()
                            .map(userAcessoMapper::toDto)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }

    public Proprietario toEntity(ProprietarioRequest dto, UserAcessoRepository userAcessoRepository) {
        var entity = new Proprietario();
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setCpf(dto.getCpf());
        entity.setCnpj(dto.getCnpj());

        if (dto.getUserAcessosIds() != null && !dto.getUserAcessosIds().isEmpty()) {
            List<UserAcesso> acessos = dto.getUserAcessosIds().stream()
                    .filter(Objects::nonNull)
                    .distinct()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id)))
                    .collect(Collectors.toList());
            entity.setUserAcesso(acessos);
        }
        return entity;
    }

    @Override
    public Proprietario toEntity(ProprietarioRequest dto) {
        var entity = new Proprietario();
        entity.setNome(dto.getNome());
        entity.setNickname(dto.getNickname());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        entity.setDataNascimento(dto.getDataNascimento());
        entity.setCpf(dto.getCpf());
        entity.setCnpj(dto.getCnpj());

        if (dto.getUserAcessosIds() != null) {
            List<UserAcesso> acessos = dto.getUserAcessosIds().stream()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setUserAcesso(acessos);
        }
        return entity;
    }
    @Override
    public Proprietario update(ProprietarioRequest request, Proprietario entity) {
        entity.setNome(request.getNome());
        entity.setNickname(request.getNickname());
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        entity.setDataNascimento(request.getDataNascimento());
        entity.setCpf(request.getCpf());
        entity.setCnpj(request.getCnpj());

        if (request.getUserAcessosIds() != null) {
            List<UserAcesso> acessos = request.getUserAcessosIds().stream()
                    .map(id -> userAcessoRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Acesso não encontrado com ID " + id))
                    )
                    .collect(Collectors.toList());
            entity.setUserAcesso(acessos);
        }
        return entity;
    }

    public List<ProprietarioResponse> toListDto(List<Proprietario> items) {
        return items.stream().map(this::toDto).collect(Collectors.toList());
    }
}
