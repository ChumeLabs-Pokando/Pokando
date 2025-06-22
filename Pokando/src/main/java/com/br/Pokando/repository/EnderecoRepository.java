/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.repository;

import com.br.Pokando.model.Endereco;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 05029689150
 */
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
    // define que da pra consultar pelo logradouro, sem isso o java não sabe como realizar a busca pois o repository só buscar por ID...
    Optional<Endereco> findByLogradouro(String logradouro);
    
    @Transactional
    void deletarPorLogradouro(String logradouro);
    
    
}
