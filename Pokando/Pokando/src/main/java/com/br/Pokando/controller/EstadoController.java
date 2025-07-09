package com.br.Pokando.controller;

import com.br.Pokando.Mapper.EnderecoMapper;
import com.br.Pokando.Mapper.EstadoMapper;
import com.br.Pokando.Mapper.IMapper;
import com.br.Pokando.Service.EnderecoService;
import com.br.Pokando.Service.EstadoService;
import com.br.Pokando.Service.IService;
import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.dto.EstadoRequest;
import com.br.Pokando.dto.EstadoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Estado;
import com.br.Pokando.repository.EnderecoRepository;
import com.br.Pokando.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estado")
public class EstadoController extends CRUDDefaultControllerAdapter<Estado, Long, EstadoResponse, EstadoRequest, EstadoRequest> {

    public EstadoController(IService<Estado, Long, EstadoResponse, EstadoRequest, EstadoRequest> service, IMapper<Estado, EstadoResponse, EstadoRequest, EstadoRequest> mapper) {
        super(service, mapper);
    }



}
