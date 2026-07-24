package Modelo;

import Estructura.ListaCircularCitas;
import Estructura.ListaCircularMedicamentos;

/**
 * Representa el expediente único de un paciente.
 *
 * Contiene la información personal del paciente y dos listas internas:
 * una para el histórico de citas y otra para el histórico de medicamentos.
 *
 * @author nelson
 */
public class ExpedientePaciente {

    private String cedula;
    private String nombre;
    private int edad;
    private String genero;

    private ListaCircularCitas historicoCitas;
    private ListaCircularMedicamentos historicoMedicamentos;

    /**
     * Constructor con parámetros.
     *
     * @param cedula Cédula del paciente.
     * @param nombre Nombre del paciente.
     * @param edad Edad del paciente.
     * @param genero Género del paciente.
     */
    public ExpedientePaciente(String cedula,
            String nombre,
            int edad,
            String genero) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;

        historicoCitas = new ListaCircularCitas();
        historicoMedicamentos = new ListaCircularMedicamentos();
    }

    /**
     * Constructor vacío.
     */
    public ExpedientePaciente() {

        historicoCitas = new ListaCircularCitas();
        historicoMedicamentos = new ListaCircularMedicamentos();
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ListaCircularCitas getHistoricoCitas() {
        return historicoCitas;
    }

    public void setHistoricoCitas(
            ListaCircularCitas historicoCitas) {

        this.historicoCitas = historicoCitas;
    }

    public ListaCircularMedicamentos getHistoricoMedicamentos() {
        return historicoMedicamentos;
    }

    public void setHistoricoMedicamentos(
            ListaCircularMedicamentos historicoMedicamentos) {

        this.historicoMedicamentos = historicoMedicamentos;
    }

    /**
     * Agrega una cita al historial.
     *
     * @param cita Cita médica.
     */
    public void agregarCita(Cita cita) {

        historicoCitas.insertarCita(cita);
    }

    /**
     * Agrega un medicamento al historial.
     *
     * @param medicamento Medicamento.
     */
    public void agregarMedicamento(Medicamento medicamento) {

        historicoMedicamentos.insertarMedicamento(medicamento);
    }

    /**
     * Muestra el expediente completo.
     *
     * @return Información del expediente.
     */
    public String mostrarExpediente() {

        String mensaje = "";

        mensaje += "=================================\n";
        mensaje += "EXPEDIENTE DEL PACIENTE\n";
        mensaje += "=================================\n";
        mensaje += "Cédula: " + cedula + "\n";
        mensaje += "Nombre: " + nombre + "\n";
        mensaje += "Edad: " + edad + "\n";
        mensaje += "Género: " + genero + "\n\n";

        mensaje += "===== HISTÓRICO DE CITAS =====\n";
        mensaje += historicoCitas.mostrarCitas();

        mensaje += "\n===== HISTÓRICO DE MEDICAMENTOS =====\n";
        mensaje += historicoMedicamentos.mostrarMedicamentos();

        return mensaje;
    }

    @Override
    public String toString() {

        return "Cédula: " + cedula
                + "\nNombre: " + nombre
                + "\nEdad: " + edad
                + "\nGénero: " + genero;
    }
}