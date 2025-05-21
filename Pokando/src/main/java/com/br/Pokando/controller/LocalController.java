/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.controller;

import com.br.Pokando.model.Local;
import com.br.Pokando.model.Proprietario;
import com.br.Pokando.repository.LocalRepository;
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
 * @author felip
 */
@RestController
@RequestMapping("/local")
public class LocalController {
    @Autowired
   private LocalRepository repository;
    
    @Transactional
    @PostMapping
    public Local create(
            @RequestParam(name = "nomeLocal", required = true) String nomeLocal,
            //@RequestParam(name = "enderecoLocal", required = true) Endereco endereco
            //@RequestParam(name = "enderecoGeografico", required = true) EnderecoGeografico enderecoGeografico,
            @RequestParam(name = "horarioDeFuncionamento", required = true) String horarioDeFuncionamento,
            @RequestParam(name = "alvaraDeFuncionamento", required = true) String alvaraDeFuncionamento,
            @RequestParam(name = "comprovanteCorpoBombeiros", required = true) String comprovanteCorpoBombeiros,
            @RequestParam(name = "comprovanteSanitario", required = true) String comprovanteSanitario,
            @RequestParam(name = "capacidade", required = true) int capacidade,
            @RequestParam(name = "proprietario", required = true) List<Proprietario> Proprietario
            
    ) {
        Local local = new Local(null, /*enderecoLocal, enderecoGeografico,*/horarioDeFuncionamento, comprovanteCorpoBombeiros, comprovanteSanitario, capacidade, Proprietario);
        repository.save(local);
        return local;
    }

    @GetMapping
    public List<Local> list() {
        var lista = repository.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public Local findBy(
            @PathVariable Long id
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    
    public Optional<Local> find(
            Long id
    ) {
        Optional<Local> optional = repository.findById(id);
       // Optional<Local> optional = lista.stream()
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
            Local local = optional.get();
            repository.delete(local);

        }
    }
    
    @Transactional
    @PutMapping("/{id}")
    public Local update(
            @PathVariable Long id,
             @RequestParam(name = "nomeLocal", required = true) String nomeLocal,
            //@RequestParam(name = "enderecoLocal", required = true) Endereco endereco
            //@RequestParam(name = "enderecoGeografico", required = true) EnderecoGeografico enderecoGeografico,
            @RequestParam(name = "horarioDeFuncionamento", required = true) String horarioDeFuncionamento,
            @RequestParam(name = "alvaraDeFuncionamento", required = true) String alvaraDeFuncionamento,
            @RequestParam(name = "comprovanteCorpoBombeiros", required = true) String comprovanteCorpoBombeiros,
            @RequestParam(name = "comprovanteSanitario", required = true) String comprovanteSanitario,
            @RequestParam(name = "capacidade", required = true) int capacidade,
            @RequestParam(name = "proprietario", required = true) List<Proprietario> Proprietario, List<Proprietario> proprietario
            
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            var local = optional.get();
              local.setNomeLocal(nomeLocal);
             // local.setEnderecoLocal(enderecoLocal);
             //local.setEnderecoGeografico(enderecoGeografico);
              local.setAlvaraDeFuncionamento(alvaraDeFuncionamento);
              local.setComprovanteCorpoBombeiros(comprovanteCorpoBombeiros);
              local.setComprovanteSanitario(comprovanteSanitario);
              local.setCapacidade(capacidade);
              local.setProprietario(proprietario);
            return local;
        }
        return null;
    }

}
