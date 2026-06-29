/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 * Representa un paciente registrado en el sistema del Hospital Su Salud.
 * Almacena la información necesaria para gestionar la atención médica mediante
 * las colas de pacientes.
 *
 * @author ignap
 * @version 1.0
 */
public class Paciente {

    //Atributos
    private String ficha;
    private String cedula;
    private String nombre;
    private Date fechaHoraLlegada;
    private String tipo;

    //Constructores
    /**
     * Crea un nuevo paciente con la información ingresada
     *
     * @param ficha
     * @param cedula
     * @param nombre
     * @param fechaHoraLlegada
     * @param tipo
     */
    public Paciente() {
    }

    public Paciente(String ficha, String cedula, String nombre,
            Date fechaHoraLlegada, String tipo) {
        this.ficha = ficha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.tipo = tipo;
    }

    //Getters && Setters
    /**
     * Obtiene la ficha del paciente
     *
     * @return ficha del paciente
     */
    public String getFicha() {
        return ficha;
    }

    /**
     * Modifca la ficha del paciente
     *
     * @param ficha
     */
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    /**
     * Obtiene la cedula del paciente
     *
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Modifica la cedula del paciente
     *
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el nombre del paciente
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del paciente
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de llegada del paciente
     *
     * @return
     */
    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    /**
     * Modifica la fecha de llegada del paciente
     *
     * @param fechaHoraLlegada
     */
    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    /**
     * Obtiene el tipo de paciente
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de paciente
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
