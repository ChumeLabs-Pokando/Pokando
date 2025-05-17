/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokando;

import java.util.List;

/**
 *
 * @author 05029689150
 */
public class Contrato {
    private boolean autorizado;

    List<Proprietario> proprietario;
    
    List<Organizador> organizador;

    public List<Organizador> getOrganizador() {
        return (List<Organizador>) organizador;
    }
     public List<Proprietario> getProprietario() {
        return proprietario;
    }
     
      public Contrato() {
    }
    
    public Contrato(List<Proprietario> proprietario, List<Organizador> organizador) {
        this.proprietario = (List<Proprietario>) proprietario;
        this.organizador = (List<Organizador>) organizador;
    }

  

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
    
    
}
