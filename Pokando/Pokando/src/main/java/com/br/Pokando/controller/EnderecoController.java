/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.controller;

import com.br.Pokando.Mapper.EnderecoMapper;
import com.br.Pokando.Service.EnderecoService;
import com.br.Pokando.dto.EnderecoRequest;
import com.br.Pokando.dto.EnderecoResponse;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author felip
 */
@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;
    @Autowired
    private EnderecoRepository repository;

    private final EnderecoMapper mapper;


    @Transactional
    @PostMapping
    public EnderecoResponse salvarEndereco(
            @RequestBody EnderecoRequest endereco
    ) {
        var entity = mapper.toEntity(endereco);
        var saved = repository.save(entity);
        var dto = mapper.toDto(saved);
        return dto;
    }

    ;

    // busca apenas logradouros unicos no sistema...
   /* @GetMapping("/logradouro-{logradouro}")
    public Endereco findByLogradouro(
            @PathVariable String logradouro
    ) {
        var optional = find(logradouro);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Optional<Endereco> find(
            String logradouro
    ) {
        Optional<Endereco> optional = enderecoService.buscarPorLogradouro(logradouro);
        return optional;
    }

    */

    // pesquisa zika, se voce mandar vazio ele devolve todos os logradouros..
    // se voce pesquisar ele devolve todos com a pesquisa; exemplo: ?logradouro=rua (ele ignora maiusculo e minisculo)
    // no bd ta buscando um LIKE = "%?%"
    @GetMapping("/logradouro")
    public List<Endereco> findByLogradouro(@RequestParam(required = false) String logradouro) {
        if (logradouro == null || logradouro.isBlank()) {
            return enderecoService.buscarTodos();
        }
        return enderecoService.buscarTodosPorLogradouro(logradouro);
    }





    @GetMapping
    public List<EnderecoResponse> list() {
        List<Endereco> l = repository.findAll();
        return mapper.toListDto(l);
    }

    @GetMapping("/{id}")
    public Endereco findBy(
            @PathVariable Long id
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    public Optional<Endereco> find(
            Long id
    ) {
        Optional<Endereco> optional = repository.findById(id);
        return optional;
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        var optional = find(id);
        if (optional.isPresent()) {
            Endereco endereco = optional.get();
            repository.delete(endereco);

        }
    }

    /*
    -- teste --
    @Transactional
    @DeleteMapping("/logradouro-{logradouro}")
    public void delete(
            @PathVariable String logradouro
    ) {

        var optional = find(logradouro);
        if (optional.isPresent()) {
            Endereco endereco = optional.get();
            enderecoService.deletarPorLogradouro(logradouro);

        }
    }*/

    @Transactional
    @PutMapping("/{id}")
    public Endereco update(
            @PathVariable Long id,
            @RequestBody Endereco endereco
    ) {
        Endereco enderecoEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Endereço não encontrado"));
        Endereco enderecoAtualizado = Endereco.builder()
                .id(endereco.getId() != null ? endereco.getId() :
                        enderecoEntity.getId())
                .logradouro(endereco.getLogradouro() != null ? endereco.getLogradouro() :
                        enderecoEntity.getLogradouro())
                .bairro(endereco.getBairro() != null ? endereco.getBairro()
                        : enderecoEntity.getBairro())
                .cidade(endereco.getCidade() != null ? endereco.getCidade()
                        : enderecoEntity.getCidade())
                .numero(endereco.getNumero() != null ? endereco.getNumero()
                        : enderecoEntity.getNumero())
                .cep(endereco.getCep() != null ? endereco.getCep()
                        : enderecoEntity.getCep())
                .complemento(endereco.getComplemento() != null ? endereco.getComplemento()
                        : enderecoEntity.getComplemento())
                .build();

            return repository.saveAndFlush(enderecoAtualizado);
        }

    }






