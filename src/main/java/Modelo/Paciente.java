package Modelo;

import java.util.Date;

/**
 * Representa un paciente registrado en el sistema del Hospital Su Salud.
 * Almacena la información necesaria para gestionar la atención médica mediante
 * las colas de pacientes.
 *
 * @author ignap
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
     * @param ficha posicion del paciente para ser atendido
     * @param cedula identificacion del paciente
     * @param nombre nombre del paciente
     * @param fechaHoraLlegada fecha y hora TIMESTAMP
     * @param tipo tipo de paciente (Regular o Preferencial)
     */
    public Paciente(String ficha, String cedula, String nombre,
            Date fechaHoraLlegada, String tipo) {
        this.ficha = ficha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.tipo = tipo;
    }
    
    public Paciente() {}

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
     * @param ficha posicion del paciente para ser atendido
     */
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    /**
     * Obtiene la cedula del paciente
     *
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Modifica la cedula del paciente
     *
     * @param cedula identificacion del paciente
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el nombre del paciente
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del paciente
     *
     * @param nombre nombre del paciente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de llegada del paciente
     *
     * @return fecha y hora TIMESTAMP
     */
    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    /**
     * Modifica la fecha de llegada del paciente
     *
     * @param fechaHoraLlegada fecha y hora TIMESTAMP
     */
    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    /**
     * Obtiene el tipo de paciente
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Modifica el tipo de paciente
     *
     * @param tipo tipo de paciente (Regular o Preferencial)
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
