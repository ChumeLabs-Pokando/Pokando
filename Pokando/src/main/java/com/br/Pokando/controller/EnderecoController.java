/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.controller;

import com.br.Pokando.model.Endereco;
import com.br.Pokando.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 05029689150
 */

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
   private EnderecoRepository repository;
    
    @Transactional
    @PostMapping
    public Endereco create(
            @RequestParam(name = "logradouro", required = true) String logradouro,
            @RequestParam(name = "cidade", required = true) String cidade,
            @RequestParam(name = "numero", required = true) String numero,
            @RequestParam(name = "cep", required = true) String cep,
            @RequestParam(name = "bairro", required = true) String bairro
    ) {
        Endereco endereco = new Endereco(null, logradouro, cidade, numero, cep, bairro);
        repository.save(endereco);
        return endereco;
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
       // Optional<Endereco> optional = lista.stream()
        //        .filter((item) -> item.getId().equals(id))
         //       .findAny();;
        return optional;
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable(name = "id") Long id
          
    ) {
    
        var optional = find(id);
        if (optional.isPresent()) {
            Endereco endereco = optional.get();
            repository.delete(endereco);

        }
    }
    
    @Transactional
    @PutMapping("/{id}")
    public Endereco update(
            @PathVariable Long id,
            @RequestParam(name = "logradouro", required = true) String logradouro,
             @RequestParam(name = "cidade", required = true) String cidade,
            @RequestParam(name = "numero", required = true) String numero,
            @RequestParam(name = "cep", required = true) String cep,
            @RequestParam(name = "bairro", required = true) String bairro
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            var endereco = optional.get();
            endereco.setLogradouro(logradouro);
            endereco.setCidade(cidade);
            endereco.setNumero(numero);
            endereco.setCep(cep);
            endereco.setBairro(bairro);
            return endereco;
        }
        return null;
    }

}


