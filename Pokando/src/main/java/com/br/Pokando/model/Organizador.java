/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

import com.br.Pokando.model.heranca.Usuario;
import java.util.List;

/**
 *
 * @author 05029689150
 */
public class Organizador extends Usuario {

    List<Evento> evento;
    
    public Organizador() {
    }
    
    public List<Evento> getEvento() {
        return evento;
    }
}
