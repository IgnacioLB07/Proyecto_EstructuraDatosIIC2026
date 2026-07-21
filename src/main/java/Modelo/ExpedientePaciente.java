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

    // Atributos
    private String cedula;
    private String nombre;
    private int edad;
    private String genero;

    private ListaCircularCitas historicoCitas;
    private ListaCircularMedicamentos historicoMedicamentos;

    // Constructores

    /**
     * Crea un expediente con los datos del paciente.
     *
     * @param cedula número de cédula del paciente
     * @param nombre nombre completo del paciente
     * @param edad edad del paciente
     * @param genero género del paciente
     */
    public ExpedientePaciente(String cedula, String nombre,
            int edad, String genero) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;

        /*
         * Cada expediente crea sus propias listas internas.
         * Por eso cada paciente tendrá su propio histórico.
         */
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

    // Getters y Setters

    /**
     * Obtiene la cédula del paciente.
     *
     * @return cédula del paciente
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Modifica la cédula del paciente.
     *
     * @param cedula nueva cédula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el nombre del paciente.
     *
     * @return nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del paciente.
     *
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del paciente.
     *
     * @return edad del paciente
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad del paciente.
     *
     * @param edad nueva edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el género del paciente.
     *
     * @return género del paciente
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Modifica el género del paciente.
     *
     * @param genero nuevo género
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el histórico de citas del paciente.
     *
     * @return lista circular de citas
     */
    public ListaCircularCitas getHistoricoCitas() {
        return historicoCitas;
    }

    /**
     * Modifica el histórico de citas.
     *
     * @param historicoCitas nueva lista de citas
     */
    public void setHistoricoCitas(ListaCircularCitas historicoCitas) {
        this.historicoCitas = historicoCitas;
    }

    /**
     * Obtiene el histórico de medicamentos.
     *
     * @return lista circular de medicamentos
     */
    public ListaCircularMedicamentos getHistoricoMedicamentos() {
        return historicoMedicamentos;
    }

    /**
     * Modifica el histórico de medicamentos.
     *
     * @param historicoMedicamentos nueva lista de medicamentos
     */
    public void setHistoricoMedicamentos(
            ListaCircularMedicamentos historicoMedicamentos) {

        this.historicoMedicamentos = historicoMedicamentos;
    }

    /**
     * Agrega una cita al histórico del paciente.
     *
     * @param cita cita que se desea registrar
     */
    public void agregarCita(Cita cita) {
        historicoCitas.insertarCita(cita);
    }

    /**
     * Agrega un medicamento al histórico del paciente.
     *
     * @param medicamento medicamento que se desea registrar
     */
    public void agregarMedicamento(Medicamento medicamento) {
        historicoMedicamentos.insertarMedicamento(medicamento);
    }

    /**
     * Construye la información completa del expediente.
     *
     * @return información del paciente y sus históricos
     */
    public String mostrarExpediente() {

        String mensaje = "=================================\n"
                + "EXPEDIENTE ÚNICO DEL PACIENTE\n"
                + "=================================\n"
                + "Cédula: " + cedula + "\n"
                + "Nombre: " + nombre + "\n"
                + "Edad: " + edad + "\n"
                + "Género: " + genero + "\n\n"
                + "========= HISTÓRICO DE CITAS =========\n"
                + historicoCitas.mostrarCitas()
                + "\n========= HISTÓRICO DE MEDICAMENTOS =========\n"
                + historicoMedicamentos.mostrarMedicamentos();

        return mensaje;
    }

    /**
     * Devuelve los datos básicos del paciente.
     *
     * @return datos del expediente
     */
    @Override
    public String toString() {
        return "Cédula: " + cedula
                + "\nNombre: " + nombre
                + "\nEdad: " + edad
                + "\nGénero: " + genero;
    }
}