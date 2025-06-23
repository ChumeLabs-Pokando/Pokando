/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

/**
 *
 * @author 05029689150
 */
public class TabelaDePreco {
    private double valor;
    private CategoriaDeIngresso categoria;
    
    
    public TabelaDePreco() {
    }

    public CategoriaDeIngresso getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDeIngresso categoria) {
        this.categoria = categoria;
    }

    
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
