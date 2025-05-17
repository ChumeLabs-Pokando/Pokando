/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.pokando;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author 04766167198
 */
public class Reserva {

    private LocalDate dataReserva;
    private LocalTime horaReserva;
    private int prazo;
    private int id;
   


    List<Organizador> organizador;
    List<Local> local;

    public List<Organizador> getOrganizador() {
        return organizador;
    }
    
     public List<Local> getLocal() {
        return local;
    }

    public Reserva() {
    }

    public Reserva(LocalDate dataReserva, LocalTime horaReserva, int prazo, Organizador organizador, Local local) {
        this.dataReserva = dataReserva;
        this.horaReserva = horaReserva;
        this.prazo = prazo;
        this.organizador = (List<Organizador>) organizador;
        this.local = (List<Local>) local;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(LocalTime horaReserva) {
        this.horaReserva = horaReserva;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
