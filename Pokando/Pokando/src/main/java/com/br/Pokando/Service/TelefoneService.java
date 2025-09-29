package com.br.Pokando.Service;


import com.br.Pokando.Mapper.TelefoneMapper;
import com.br.Pokando.dto.TelefoneRequest;
import com.br.Pokando.dto.TelefoneResponse;
import com.br.Pokando.model.Telefone;
import com.br.Pokando.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TelefoneService extends ServiceAdapter<Telefone, Long, TelefoneResponse, TelefoneRequest, TelefoneRequest>{

    private final ClienteRepository clienteRepository;

    private final OrganizadorRepository organizadorRepository;

   // private final ProprietarioRepository proprietarioRepository;


    public TelefoneService(TelefoneRepository telefoneRepository, TelefoneMapper telefoneMapper, ClienteRepository clienteRepository, OrganizadorRepository organizadorRepository) {
        super(telefoneRepository, telefoneMapper);
        this.clienteRepository = clienteRepository;
        this.organizadorRepository = organizadorRepository;

    }

    @Override
    @Transactional
    public Telefone create(TelefoneRequest request) {
        var entity = ((TelefoneMapper) mapper).toEntity(request, clienteRepository, organizadorRepository);
        var saved = repository.save(entity);
        return repository.findById(saved.getId())
                .orElseThrow(() -> new RuntimeException("Erro ao buscar telefone salvo"));
    }


}
