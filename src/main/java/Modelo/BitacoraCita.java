package Modelo;

import java.util.Date;

/**
 * Representa una cita atendida en la sesión actual.
 *
 * Se utiliza para alimentar la bitácora del día.
 *
 * @author nelson
 */
public class BitacoraCita {

    // Atributos

    private String ficha;
    private String cedula;
    private String nombre;

    private Date fechaLlegada;
    private Date fechaAtencion;

    // Constructores

    public BitacoraCita(String ficha,
            String cedula,
            String nombre,
            Date fechaLlegada,
            Date fechaAtencion) {

        this.ficha = ficha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaLlegada = fechaLlegada;
        this.fechaAtencion = fechaAtencion;
    }

    public BitacoraCita() {
    }

    // Getters y Setters

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

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    /**
     * Calcula el tiempo de espera en segundos.
     *
     * @return segundos de espera
     */
    public long tiempoEspera() {

        long diferencia =
                fechaAtencion.getTime()
                - fechaLlegada.getTime();

        return diferencia / 1000;
    }

    /**
     * Devuelve el estado del paciente según el tiempo de espera.
     *
     * El color lo pondremos después en el JOptionPane.
     *
     * @return VERDE, AMARILLO o ROJO
     */
    public String obtenerEstado() {

        long tiempo = tiempoEspera();

        if (tiempo <= 30) {
            return "VERDE";
        }

        if (tiempo < 60) {
            return "AMARILLO";
        }

        return "ROJO";
    }

    @Override
    public String toString() {

        return "Ficha: " + ficha
                + "\nCédula: " + cedula
                + "\nNombre: " + nombre
                + "\nLlegada: " + fechaLlegada
                + "\nAtención: " + fechaAtencion
                + "\nTiempo Espera: " + tiempoEspera() + " segundos"
                + "\nEstado: " + obtenerEstado();

    }

}