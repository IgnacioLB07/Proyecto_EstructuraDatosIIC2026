/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;
/**
 * Representa una queja registrada en el sistema del hospital
 * @author ignap
 */
public class Queja 
{
    //Atributos
    private String motivo;
    private Date fechaHoraSalida;
    
    //Constructores

    /**
     * Crea una nueva queja con la información ingresada
     * @param motivo
     * @param fechaHoraSalida 
     */
    public Queja() {}

    public Queja(String motivo, Date fechaHoraSalida) {
        this.motivo = motivo;
        this.fechaHoraSalida = fechaHoraSalida;
    }
    
    //Getters && Setters

    /**
     * Obtiene el motivo de la queja
     * @return 
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Modifica el motivo de la queja
     * @param motivo 
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la fecha de la queja
     * @return 
     */
    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    /**
     * Modifica la fecha de la queja
     * @param fechaHoraSalida 
     */
    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }
}