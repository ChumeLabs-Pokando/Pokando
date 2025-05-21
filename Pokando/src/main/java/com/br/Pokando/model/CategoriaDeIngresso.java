/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

import java.util.List;

/**
 *
 * @author 05029689150
 */
public class CategoriaDeIngresso {
    private String nome;
    private int id;

    List<Evento> evento;
    
    
    
    public CategoriaDeIngresso() {
    }

    public List<Evento> getLocal() {
        return evento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
