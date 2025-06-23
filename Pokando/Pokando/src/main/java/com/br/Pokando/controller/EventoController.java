/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.controller;

import com.br.Pokando.model.CategoriaDeIngresso;
import com.br.Pokando.model.Evento;
import com.br.Pokando.model.Local;
import com.br.Pokando.model.Organizador;
import com.br.Pokando.model.heranca.Usuario;
import com.br.Pokando.repository.EventoRepository;
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
@RequestMapping("/evento")
public class EventoController {
    @Autowired
   private EventoRepository repository;
  
    
    @Transactional
    @PostMapping
    public Evento create(
            @RequestParam(name = "nomeEvento", required = true) String nomeEvento,
            //@RequestParam(name = "data", required = true) LocalDate data,
            //@RequestParam(name = "hora", required = true) LocalTime hora,
            @RequestParam(name = "descricao", required = true) String descricao,
            @RequestParam(name = "custo", required = true) float custo,
            @RequestParam(name = "limiteDePessoas", required = true) double limiteDePessoas,
            @RequestParam(name = "autorizacaoLocal", required = true) boolean autorizacaoLocal,
            @RequestParam(name = "status", required = true) String status// esse é um enum, tem q alterar
           // @RequestParam(name = "local", required = true) List<Local> Local,
         //   @RequestParam(name = "usuario", required = true) List<Usuario> Usuario,
         //   @RequestParam(name = "organizador", required = true) List<Organizador> Organizador,
        //    @RequestParam(name = "categoriaDeIngresso", required = true) List<CategoriaDeIngresso> CategoriaDeIngresso
            
    ) {
        Evento evento = new Evento(null, /*data, hora,*/descricao, limiteDePessoas, autorizacaoLocal, status /*,Local, Usuario, Organizador, CategoriaDeIngresso*/);
        repository.save(evento);
        return evento;
    }
    @GetMapping
    public List<Evento> list() {
        var lista = repository.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public Evento findBy(
            @PathVariable Long id
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    
    public Optional<Evento> find(
            Long id
    ) {
        Optional<Evento> optional = repository.findById(id);
       // Optional<Evento> optional = lista.stream()
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
            Evento evento = optional.get();
            repository.delete(evento);

        }
    }
    
    @Transactional
    @PutMapping("/{id}")
    public Evento update(
            @PathVariable Long id,
             @RequestParam(name = "nomeEvento", required = true) String nomeEvento,
           //@RequestParam(name = "data", required = true) LocalDate data,
            //@RequestParam(name = "hora", required = true) LocalTime hora,
            @RequestParam(name = "descricao", required = true) String descricao,
            @RequestParam(name = "custo", required = true) float custo,
            @RequestParam(name = "limiteDePessoas", required = true) double limiteDePessoas,
            @RequestParam(name = "autorizacaoLocal", required = true) boolean autorizacaoLocal,
            @RequestParam(name = "status", required = true) String status
                 // @RequestParam(name = "local", required = true) List<Local> Local,
         //  @RequestParam(name = "usuario", required = true) List<Usuario> usuario,
         //   @RequestParam(name = "organizador", required = true) List<Organizador> organizador,
        //    @RequestParam(name = "categoriaDeIngresso", required = true) List<CategoriaDeIngresso> categoriaDeIngresso
            
    ) {
        var optional = find(id);
        if (optional.isPresent()) {
            var evento = optional.get();
              evento.setNomeEvento(nomeEvento);
             // evento.setData(data);
             //evento.setHora(hora);
              evento.setCusto(custo);
              evento.setLimiteDePessoas(limiteDePessoas);
              evento.setAutorizacaoLocal(autorizacaoLocal);
              evento.setStatus(status);
             // evento.setUsuario(usuario);
           //   evento.setLocal(local);
          //    evento.setOrganizador(organizador);
       //       evento.setCategoriaDeIngresso(categoriaDeIngresso);
            return evento;
        }
        return null;
    }

}
