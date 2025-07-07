/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.Service;

import com.br.Pokando.Mapper.EnderecoMapper;
import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author felip
 */
@Service
public class EnderecoService
        extends ServiceAdapter<Endereco, Long, EnderecoResponse, EnderecoRequest, EnderecoRequest> {

    public EnderecoService(EnderecoRepository repository, EnderecoMapper mapper) {
        super(repository, mapper);
    }
}
