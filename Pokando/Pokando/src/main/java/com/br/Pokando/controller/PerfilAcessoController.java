package com.br.Pokando.controller;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author 05029689150
 */


import com.br.Pokando.model.PerfilAcesso;
import com.br.Pokando.repository.PerfilAcessoRepository;
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

@RestController
@RequestMapping("/perfilAcesso")
public class PerfilAcessoController {
    @Autowired
   private PerfilAcessoRepository repository;
    
    @Transactional
    @PostMapping
    public PerfilAcesso create(
            @RequestParam(name = "nome", required = true) String nome

    ) {
        PerfilAcesso perfilAcesso = new PerfilAcesso(null, nome);
        repository.save(perfilAcesso);
        return perfilAcesso;
    }

    @GetMapping
    public List<PerfilAcesso> list() {
        var lista = repository.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public PerfilAcesso findBy(
            @PathVariable Long id
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    
    public Optional<PerfilAcesso> find(
            Long id
    ) {
        Optional<PerfilAcesso> optional = repository.findById(id);
       // Optional<PerfilAcesso> optional = lista.stream()
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
            PerfilAcesso perfilAcesso = optional.get();
            repository.delete(perfilAcesso);

        }
    }
    
    @Transactional
    @PutMapping("/{id}")
    public PerfilAcesso update(
            @PathVariable Long id,
            @RequestParam(name = "nome", required = true) String nome
          
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            var perfilAcesso = optional.get();
            perfilAcesso.setNome(nome);
         
            return perfilAcesso;
        }
        return null;
    }

}
