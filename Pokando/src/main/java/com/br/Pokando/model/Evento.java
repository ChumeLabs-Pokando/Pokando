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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author 04766167198
 */
@Entity
public class Evento implements Serializable{

    private String nomeEvento;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    // private LocalDate data;
   // private LocalTime hora;
    private String descricao;
    private float custo;
    private double limiteDePessoas;
    private boolean autoricaoLocal;
    private String status;
    List<Local> local;
/*
    voltar quando estiver tudo definido...
  
    List<Organizador> organizador;
    List<Usuario> usuario;
    List<CategoriaDeIngresso> categoria;
    */
    public Evento() {
    }

    public Evento(String nomeEvento, int id, LocalDate data, LocalTime hora, String descricao, float custo, double limiteDePessoas, boolean autoricaoLocal, String status) {
        this.nomeEvento = nomeEvento;
        this.id = id;
        this.descricao = descricao;
        this.custo = custo;
        this.limiteDePessoas = limiteDePessoas;
        this.autoricaoLocal = autoricaoLocal;
        this.status = status;
    }

  

    public List<Local> getLocal() {
        return local;
    }
    public void setLocal(List<Local> local){
    this.local = local;
    }
/*
    public List<Organizador> getOrganizador() {
        return organizador;
    }

     public List<Usuario> getUsuario() {
        return usuario;
    }
    
     public List<CategoriaDeIngresso> getCategoriaDeIngresso() {
        return categoria;
     }
     */
    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
*/
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public double getLimiteDePessoas() {
        return limiteDePessoas;
    }

    public void setLimiteDePessoas(double limiteDePessoas) {
        this.limiteDePessoas = limiteDePessoas;
    }

    public boolean isAutoricaoLocal() {
        return autoricaoLocal;
    }

    public void setAutoricaoLocal(boolean autoricaoLocal) {
        this.autoricaoLocal = autoricaoLocal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    
    
    
    

}
