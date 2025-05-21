/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.Pokando.model;

import java.util.Date;

/**
 *
 * @author 05029689150
 */
public class InscricaoEvento {
    private boolean estaAutorizado;
    private boolean presenca;
    private Cliente cliente;
    private Evento evento;
    private Date dataPagamento;
    private boolean pago;
    private CategoriaDeIngresso categoria;
    
    public InscricaoEvento() {
    }

    public InscricaoEvento(Cliente cliente, Evento evento, Date dataPagamento) {
        this.cliente = cliente;
        this.evento = evento;
        this.dataPagamento = dataPagamento;
    }

    public CategoriaDeIngresso getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDeIngresso categoria) {
        this.categoria = categoria;
    }

    
    
    public boolean isEstaAutorizado() {
        return estaAutorizado;
    }

    public void setEstaAutorizado(boolean estaAutorizado) {
        this.estaAutorizado = estaAutorizado;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
    
}
