/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
/**
 *
 * @author ignap
 */
public class Paciente 
{
    //Atributos
    private String ficha;
    private String cedula;
    private String nombre;
    private LocalDate fechaHoraLlegada;
    private String tipo;
    
    //Constructores
    public Paciente() {}

    public Paciente(String ficha, String cedula, String nombre,
            LocalDate fechaHoraLlegada, String tipo) 
    {
        this.ficha = ficha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.tipo = tipo;
    }
    
    //Getters && Setters
    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(LocalDate fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}