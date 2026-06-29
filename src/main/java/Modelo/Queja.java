package Modelo;

import java.util.Date;

/**
 * Representa una queja registrada en el sistema del hospital
 *
 * @author ignap
 */
public class Queja {

    //Atributos
    private String ficha;
    private String cedula;
    private String motivo;
    private Date fechaHoraSalida;

    //Constructores
    /**
     * Crea una nueva queja con la información ingresada
     *
     * @param motivo motivo por el cual se queja
     * @param fechaHoraSalida fecha y hora de salida TIMESTAMP
     */
    public Queja(String ficha, String cedula, String motivo, Date fechaHoraSalida) {
        this.ficha = ficha;
        this.cedula = cedula;
        this.motivo = motivo;
        this.fechaHoraSalida = fechaHoraSalida;
    }
    
    public Queja() {}

    //Getters && Setters
    /**
     * Obtiene la ficha de la queja
     *
     * @return ficha
     */
    public String getFicha() {
        return ficha;
    }

    /**
     * Modifica la ficha de la queja
     *
     * @param ficha posicion del paciente para ser atendido
     */
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    /**
     * Obtiene la cedula de la queja
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Modifica la cedula de la queja
     * @param cedula identificacion del paciente
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el motivo de la queja
     *
     * @return motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Modifica el motivo de la queja
     *
     * @param motivo motivo por el cual se queja
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la fecha de la queja
     *
     * @return fecha y hora de salida TIMESTAMP
     */
    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    /**
     * Modifica la fecha de la queja
     *
     * @param fechaHoraSalida fecha y hora de salida TIMESTAMP
     */
    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

}
