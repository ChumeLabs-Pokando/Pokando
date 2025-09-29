package com.br.Pokando.Service;

import com.br.Pokando.Mapper.UserAcessoMapper;
import com.br.Pokando.dto.UserAcessoRequest;
import com.br.Pokando.dto.UserAcessoResponse;
import com.br.Pokando.model.UserAcesso;
import com.br.Pokando.repository.UserAcessoRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAcessoService
        extends ServiceAdapter<UserAcesso, Long, UserAcessoResponse, UserAcessoRequest,UserAcessoRequest>{


    public UserAcessoService(UserAcessoRepository repository, UserAcessoMapper mapper) {
        super(repository, mapper);
    }
}
