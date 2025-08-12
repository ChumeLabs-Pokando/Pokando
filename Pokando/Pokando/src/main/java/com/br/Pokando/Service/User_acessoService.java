package com.br.Pokando.Service;

import com.br.Pokando.Mapper.User_acessoMapper;
import com.br.Pokando.dto.User_acessoRequest;
import com.br.Pokando.dto.User_acessoResponse;
import com.br.Pokando.model.User_acesso;
import com.br.Pokando.repository.User_acessoRepository;
import org.springframework.stereotype.Service;

@Service
public class User_acessoService
        extends ServiceAdapter<User_acesso, Long, User_acessoResponse, User_acessoRequest,User_acessoRequest>{


    public User_acessoService(User_acessoRepository repository, User_acessoMapper mapper) {
        super(repository, mapper);
    }
}
