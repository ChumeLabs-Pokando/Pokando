package com.br.Pokando.Service;

import com.br.Pokando.Mapper.UserAcessoMapper;
import com.br.Pokando.dto.UserAcessoRequest;
import com.br.Pokando.dto.UserAcessoResponse;
import com.br.Pokando.model.UserAcesso;
import com.br.Pokando.repository.ClienteRepository;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAcessoService
        extends ServiceAdapter<UserAcesso, Long, UserAcessoResponse, UserAcessoRequest,UserAcessoRequest>{

    private final ClienteRepository clienteRepository;

    public UserAcessoService(ClienteRepository clienteRepository, UserAcessoMapper mapper, UserAcessoRepository repository) {
        super(repository, mapper);
        this.clienteRepository = clienteRepository;
    }


    @Override
    @Transactional
    public UserAcesso create(UserAcessoRequest request) {
        var entity = ((UserAcessoMapper) mapper).toEntity(request, clienteRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar Acesso salvo"));
    }
}
