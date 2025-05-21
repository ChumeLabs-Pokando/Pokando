/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.br.Pokando.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 04766167198
 */
@Entity
public class Local implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeLocal;
    //private Endereco enderecoLocal;
    //private EnderecoGeografico enderecogeografico;
    private int horarioDeFuncionamento;
    private String alvaraDeFuncionamento;
    private String comprovanteCorpoBombeiros;
    private String comprovanteSanitario;
    private int capacidade; 

    List<Proprietario> proprietario;
    
     public List<Proprietario> getProprietario() {
        return proprietario;
    }

    public Local(Long id, String nomeLocal, String alvaraDeFuncionamento, String comprovanteCorpoBombeiros, int horarioDeFuncionamento, List<Proprietario> proprietario) {
        this.id = id;
        this.nomeLocal = nomeLocal;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.alvaraDeFuncionamento = alvaraDeFuncionamento;
        this.comprovanteCorpoBombeiros = comprovanteCorpoBombeiros;
        this.comprovanteSanitario = comprovanteSanitario;
        this.capacidade = capacidade;
        this.proprietario = proprietario;
    }
     
    
    public Local() {
    }

    
    
    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    /*
    public Endereco getEnderecoLocal() {
        return enderecoLocal;
    }

    public void setEnderecoLocal(Endereco enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    public EnderecoGeografico getEnderecogeografico() {
        return enderecogeografico;
    }

    public void setEnderecogeografico(EnderecoGeografico enderecogeografico) {
        this.enderecogeografico = enderecogeografico;
    }
*/
    public int getHorarioDeFuncionamento() {
        return horarioDeFuncionamento;
    }

    public void setHorarioDeFuncionamento(int horarioDeFuncionamento) {
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

    public String getAlvaraDeFuncionamento() {
        return alvaraDeFuncionamento;
    }

    public void setAlvaraDeFuncionamento(String alvaraDeFuncionamento) {
        this.alvaraDeFuncionamento = alvaraDeFuncionamento;
    }

    public String getComprovanteCorpoBombeiros() {
        return comprovanteCorpoBombeiros;
    }

    public void setComprovanteCorpoBombeiros(String comprovanteCorpoBombeiros) {
        this.comprovanteCorpoBombeiros = comprovanteCorpoBombeiros;
    }

    public String getComprovanteSanitario() {
        return comprovanteSanitario;
    }

    public void setComprovanteSanitario(String comprovanteSanitario) {
        this.comprovanteSanitario = comprovanteSanitario;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    
    public void setProprietario(List<Proprietario> proprietario) {
        this.proprietario = proprietario;
    }
    
    
}
