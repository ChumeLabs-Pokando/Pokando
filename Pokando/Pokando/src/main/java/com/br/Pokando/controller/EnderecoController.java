/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.controller;

import com.br.Pokando.Service.EnderecoService;
import com.br.Pokando.model.Endereco;
import com.br.Pokando.model.Evento;
import com.br.Pokando.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public Endereco salvarEndereco(
            @RequestBody Endereco endereco
    ) {
        return enderecoService.salvarEndereco(endereco);
    }

    ;

    @GetMapping("/logradouro-{logradouro}")
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


    @GetMapping
    public List<Endereco> list() {
        var lista = repository.findAll();
        return lista;
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






