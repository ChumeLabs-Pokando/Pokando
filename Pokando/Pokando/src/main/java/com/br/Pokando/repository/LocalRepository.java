/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.br.Pokando.repository;

import com.br.Pokando.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author felip
 */
public interface LocalRepository  extends JpaRepository<Local, Long> {
    
}
