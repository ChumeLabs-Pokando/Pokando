/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.repository;

import com.br.Pokando.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 05029689150
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
