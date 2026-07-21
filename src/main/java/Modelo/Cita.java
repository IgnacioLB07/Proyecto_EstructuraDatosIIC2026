
package Modelo;
import java.util.Date;
/**
 *
 * @author nelson latino
 ** Representa una cita médica realizada a un paciente.
 * Almacena la fecha de atención, el nombre del doctor
 * y el diagnóstico correspondiente*/

public class Cita {

    // Atributos
    private Date fechaAtencion;
    private String nombreDoctor;
    private String diagnostico;

    // Constructores

    /**
     * Crea una nueva cita con los datos ingresados.
     *
     * @param fechaAtencion fecha y hora de atención
     * @param nombreDoctor nombre del doctor que atendió
     * @param diagnostico diagnóstico del paciente
     */
    public Cita(Date fechaAtencion, String nombreDoctor, String diagnostico) {
        this.fechaAtencion = fechaAtencion;
        this.nombreDoctor = nombreDoctor;
        this.diagnostico = diagnostico;
    }

    /**
     * Constructor vacío.
     */
    public Cita() {
    }

    // Getters y Setters

    /**
     * Obtiene la fecha de atención.
     *
     * @return fecha de atención
     */
    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    /**
     * Modifica la fecha de atención.
     *
     * @param fechaAtencion nueva fecha de atención
     */
    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    /**
     * Obtiene el nombre del doctor.
     *
     * @return nombre del doctor
     */
    public String getNombreDoctor() {
        return nombreDoctor;
    }

    /**
     * Modifica el nombre del doctor.
     *
     * @param nombreDoctor nuevo nombre del doctor
     */
    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    /**
     * Obtiene el diagnóstico.
     *
     * @return diagnóstico del paciente
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Modifica el diagnóstico.
     *
     * @param diagnostico nuevo diagnóstico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Construye la información de la cita.
     *
     * @return información completa de la cita
     */
    @Override
    public String toString() {
        return "Fecha de atención: " + fechaAtencion
                + "\nDoctor: " + nombreDoctor
                + "\nDiagnóstico: " + diagnostico;
    }
}