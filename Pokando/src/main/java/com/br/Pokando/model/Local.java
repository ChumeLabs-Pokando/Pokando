/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.pokando;

import java.util.List;

/**
 *
 * @author 04766167198
 */
public class Local {
    private String nomeLocal;
    private Endereco enderecoLocal;
    private EnderecoGeografico enderecogeografico;
    private int horarioDeFuncionamento;
    private String alvaraDeFuncionamento;
    private String comprovanteCorpoBombeiros;
    private String comrpovateSanitario;
    private int capacidade; 

    List<Proprietario> proprietario;
    
     public List<Proprietario> getProprietario() {
        return proprietario;
    }
    
    public Local() {
    }

    
    
    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

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

    public String getComrpovateSanitario() {
        return comrpovateSanitario;
    }

    public void setComrpovateSanitario(String comrpovateSanitario) {
        this.comrpovateSanitario = comrpovateSanitario;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
    
}
