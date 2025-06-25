package com.br.Pokando.controller;

import com.br.Pokando.Mapper.EnderecoMapper;
import com.br.Pokando.Mapper.EstadoMapper;
import com.br.Pokando.Service.EnderecoService;
import com.br.Pokando.Service.EstadoService;
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
@RequiredArgsConstructor
public class EstadoController {
    private final EstadoService estadoService;
    @Autowired
    private EstadoRepository repository;

    private final EstadoMapper mapper;

    @Transactional
    @PostMapping
    public EstadoResponse salvarEstado(
            @RequestBody EstadoRequest estado
    ) {
        var entity = mapper.toEntity(estado);
        var saved = repository.save(entity);
        var dto = mapper.toDto(saved);
        return dto;
    }
    @GetMapping
    public List<EstadoResponse> list() {
        List<Estado> l = repository.findAll();
        return mapper.toListDto(l);
    }

    @GetMapping("/{id}")
    public Estado findBy(
            @PathVariable Long id
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    public Optional<Estado> find(
            Long id
    ) {
        Optional<Estado> optional = repository.findById(id);
        return optional;
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        var optional = find(id);
        if (optional.isPresent()) {
            Estado estado = optional.get();
            repository.delete(estado);

        }
    }


}
