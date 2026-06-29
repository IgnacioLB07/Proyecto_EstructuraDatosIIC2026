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
     * @param motivo
     * @param fechaHoraSalida
     */
    public Queja() {
    }

    public Queja(String ficha, String cedula, String motivo, Date fechaHoraSalida) {
        this.ficha = ficha;
        this.cedula = cedula;
        this.motivo = motivo;
        this.fechaHoraSalida = fechaHoraSalida;
    }

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
     * @param ficha
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
     * @param cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el motivo de la queja
     *
     * @return
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Modifica el motivo de la queja
     *
     * @param motivo
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Obtiene la fecha de la queja
     *
     * @return
     */
    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    /**
     * Modifica la fecha de la queja
     *
     * @param fechaHoraSalida
     */
    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

}
