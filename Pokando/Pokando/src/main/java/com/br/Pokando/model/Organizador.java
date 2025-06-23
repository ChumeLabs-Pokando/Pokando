/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

import com.br.Pokando.model.heranca.Usuario;
import jakarta.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 05029689150
 */
@Entity
public class Organizador extends Usuario {
    List<Evento> evento;

      public Organizador() {
        
    }
    
      public Organizador(Long id,String nomeCompleto,String email,String senha,String cpf,String rg,Date dataDeNascimento,String telefone,String foto, List<Evento> evento) 
      {
        super(id, nomeCompleto, email, senha, cpf, rg, dataDeNascimento, telefone, foto);
        this.evento = evento;
    }
      
      
    public Organizador(List<Evento> evento) {
        this.evento = evento;
    }
    
    
    
    
    public List<Evento> getEvento() {
        return evento;
    }
}
