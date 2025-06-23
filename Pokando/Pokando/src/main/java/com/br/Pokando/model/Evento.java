/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.br.Pokando.model;

import com.br.Pokando.model.heranca.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 04766167198
 */
@Entity
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // private LocalDate data;
    // private LocalTime hora;
    private String nomeEvento;
    private String descricao;
    private float custo;
    private double limiteDePessoas;
    private boolean autorizacaoLocal;
    private String status;
    //@OneToMany
   // List<Local> local;
    //List<Usuario> usuario;
   // List<Organizador> organizador;
    //@OneToMany
   // List<CategoriaDeIngresso> categoria;

    /*
    voltar quando estiver tudo definido...
     */
    public Evento() {
    }

    public Evento(Long id, String nomeEvento, double limiteDePessoas, boolean autorizacaoLocal, String descricao/*, List<Local> local, List<Usuario> usuario, List<Organizador> organizador, List<CategoriaDeIngresso> categoria*/) {
        this.id = id;
        this.nomeEvento = nomeEvento;
        this.descricao = descricao;
        this.custo = custo;
        this.limiteDePessoas = limiteDePessoas;
        this.autorizacaoLocal = autorizacaoLocal;
        this.status = status;
    }

    public boolean isAutorizacaoLocal() {
        return autorizacaoLocal;
    }

    public void setAutorizacaoLocal(boolean autorizacaoLocal) {
        this.autorizacaoLocal = autorizacaoLocal;
    }
/*
    public List<CategoriaDeIngresso> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<CategoriaDeIngresso> categoria) {
        this.categoria = categoria;
    }

    public List<Local> getLocal() {
        return local;
    }

    public void setLocal(List<Local> local) {
        this.local = local;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
/*
    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    public void setOrganizador(List<Organizador> organizador) {
        this.organizador = organizador;
    }

    public void setCategoriaDeIngresso(List<CategoriaDeIngresso> categoriaDeIngresso) {
        this.categoria = categoria;
    }
*/
}
