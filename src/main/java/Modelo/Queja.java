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
public class Queja 
{
    //Atributos
    private String motivo;
    private LocalDate fechaHoraSalida;
    
    //Constructores
    public Queja() {}

    public Queja(String motivo, LocalDate fechaHoraSalida) {
        this.motivo = motivo;
        this.fechaHoraSalida = fechaHoraSalida;
    }
    
    //Getters && Setters

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDate fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }
}