
package Modelo;
import java.util.Date;
/**
 * Representa un medicamento prescrito a un paciente.
 *
 * @author nelson latino
 */
public class Medicamento {

    // Atributos
    private Date fechaPrescripcion;
    private String medicamento;

    // Constructores

    /**
     * Crea un medicamento con los datos indicados.
     *
     * @param fechaPrescripcion fecha en que fue prescrito
     * @param medicamento nombre del medicamento
     */
    public Medicamento(Date fechaPrescripcion, String medicamento) {
        this.fechaPrescripcion = fechaPrescripcion;
        this.medicamento = medicamento;
    }

    /**
     * Constructor vacío.
     */
    public Medicamento() {
    }

    // Getters y Setters

    /**
     * Obtiene la fecha de prescripción.
     *
     * @return fecha de prescripción
     */
    public Date getFechaPrescripcion() {
        return fechaPrescripcion;
    }

    /**
     * Modifica la fecha de prescripción.
     *
     * @param fechaPrescripcion nueva fecha
     */
    public void setFechaPrescripcion(Date fechaPrescripcion) {
        this.fechaPrescripcion = fechaPrescripcion;
    }

    /**
     * Obtiene el nombre del medicamento.
     *
     * @return medicamento
     */
    public String getMedicamento() {
        return medicamento;
    }

    /**
     * Modifica el nombre del medicamento.
     *
     * @param medicamento nuevo medicamento
     */
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    /**
     * Devuelve la información del medicamento.
     *
     * @return datos del medicamento
     */
    @Override
    public String toString() {
        return "Fecha: " + fechaPrescripcion
                + "\nMedicamento: " + medicamento;
    }
}