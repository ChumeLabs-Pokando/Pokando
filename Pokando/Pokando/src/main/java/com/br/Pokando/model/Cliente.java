/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

import com.br.Pokando.model.heranca.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 *
 * @author 05029689150
 */
@Entity
@Table(name = "Cliente")
@Getter
@Setter
public class Cliente extends Usuario {


    public Cliente(Long id) {
       super(id);
    }

    public Cliente() {

    }
}
