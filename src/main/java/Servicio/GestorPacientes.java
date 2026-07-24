package Servicio;

import Estructura.ColaPacientes;
import Estructura.ListaBitacora;
import Estructura.ListaExpedientes;
import Modelo.BitacoraCita;
import Modelo.Cita;
import Modelo.ExpedientePaciente;
import Modelo.Medicamento;
import Modelo.Paciente;
import java.util.Date;

/**
 * Gestiona las colas, expedientes y atención de pacientes.
 *
 * @author nelson
 */
public class GestorPacientes {

    private ColaPacientes colaRegular;
    private ColaPacientes colaPreferencial;

    private GeneradorFicha generadorFicha;

    private int contadorPreferenciales;

    private GestorQuejas gestorQ;

    private ListaExpedientes listaExpedientes;
    private ListaBitacora listaBitacora;

    /**
     * Constructor del gestor de pacientes.
     */
    public GestorPacientes() {

        colaRegular = new ColaPacientes();
        colaPreferencial = new ColaPacientes();

        generadorFicha = new GeneradorFicha();

        contadorPreferenciales = 0;

        gestorQ = new GestorQuejas();

        listaExpedientes = new ListaExpedientes();
        listaBitacora = new ListaBitacora();
    }

    public ColaPacientes getColaRegular() {
        return colaRegular;
    }

    public ColaPacientes getColaPreferencial() {
        return colaPreferencial;
    }

    public GeneradorFicha getGeneradorFicha() {
        return generadorFicha;
    }

    public GestorQuejas getGestorQ() {
        return gestorQ;
    }

    public ListaExpedientes getListaExpedientes() {
        return listaExpedientes;
    }

    public ListaBitacora getListaBitacora() {
        return listaBitacora;
    }

    /**
     * Selecciona una ficha para el paciente.
     *
     * @param cedula cédula del paciente
     * @param nombre nombre del paciente
     * @param tipoPaciente tipo Regular o Preferencial
     * @return paciente registrado
     */
    public Paciente seleccionarFicha(
            String cedula,
            String nombre,
            String tipoPaciente) {

        if (cedula == null
                || cedula.trim().isEmpty()
                || nombre == null
                || nombre.trim().isEmpty()
                || tipoPaciente == null
                || tipoPaciente.trim().isEmpty()) {

            return null;
        }

        String ficha;

        if (tipoPaciente.equalsIgnoreCase("Preferencial")) {

            ficha = generadorFicha.generarPreferencial();

        } else {

            ficha = generadorFicha.generarRegular();
        }

        Date fechaHoraLlegada = new Date();

        Paciente paciente = new Paciente(
                ficha,
                cedula.trim(),
                nombre.trim(),
                fechaHoraLlegada,
                tipoPaciente.trim()
        );

        if (tipoPaciente.equalsIgnoreCase("Preferencial")) {

            colaPreferencial.encolarPaciente(paciente);

        } else {

            colaRegular.encolarPaciente(paciente);
        }

        return paciente;
    }

    /**
     * Atiende al siguiente paciente.
     *
     * Se atienden dos pacientes preferenciales y luego uno regular,
     * siempre que existan pacientes en ambas colas.
     *
     * @return paciente atendido o null si no hay pacientes
     */
    public Paciente atenderPaciente() {

        Paciente paciente = null;

        if (!colaPreferencial.esVacia()
                && (contadorPreferenciales < 2
                || colaRegular.esVacia())) {

            paciente = colaPreferencial.desencolarPaciente();

            contadorPreferenciales++;

        } else if (!colaRegular.esVacia()) {

            paciente = colaRegular.desencolarPaciente();

            contadorPreferenciales = 0;

        } else if (!colaPreferencial.esVacia()) {

            paciente = colaPreferencial.desencolarPaciente();

            contadorPreferenciales++;
        }

        if (paciente != null) {

            Date fechaAtencion = new Date();

            BitacoraCita registro = new BitacoraCita(
                    paciente.getFicha(),
                    paciente.getCedula(),
                    paciente.getNombre(),
                    paciente.getFechaHoraLlegada(),
                    fechaAtencion
            );

            listaBitacora.insertar(registro);
        }

        return paciente;
    }

    /**
     * Elimina un paciente de la cola y registra una queja.
     *
     * @param ficha ficha del paciente
     * @param motivo motivo del abandono
     * @return paciente eliminado o null
     */
    public Paciente abandonarCola(
            String ficha,
            String motivo) {

        if (ficha == null || ficha.trim().isEmpty()) {
            return null;
        }

        Paciente paciente
                = colaPreferencial.eliminarPorFicha(ficha.trim());

        if (paciente == null) {

            paciente = colaRegular.eliminarPorFicha(ficha.trim());
        }

        if (paciente != null) {

            gestorQ.registrarQueja(paciente, motivo);
        }

        return paciente;
    }

    /**
     * Registra un expediente médico.
     *
     * @param cedula cédula del paciente
     * @param nombre nombre del paciente
     * @param edad edad del paciente
     * @param genero género del paciente
     * @return true si fue registrado
     */
    public boolean registrarExpediente(
            String cedula,
            String nombre,
            int edad,
            String genero) {

        if (cedula == null
                || cedula.trim().isEmpty()
                || nombre == null
                || nombre.trim().isEmpty()
                || edad < 0
                || genero == null
                || genero.trim().isEmpty()) {

            return false;
        }

        ExpedientePaciente existente
                = listaExpedientes.buscarExpediente(cedula.trim());

        if (existente != null) {
            return false;
        }

        ExpedientePaciente expediente
                = new ExpedientePaciente(
                        cedula.trim(),
                        nombre.trim(),
                        edad,
                        genero.trim()
                );

        listaExpedientes.insertarExpediente(expediente);

        return true;
    }

    /**
     * Busca un expediente por cédula.
     *
     * @param cedula cédula del paciente
     * @return expediente encontrado o null
     */
    public ExpedientePaciente buscarExpediente(String cedula) {

        if (cedula == null || cedula.trim().isEmpty()) {
            return null;
        }

        return listaExpedientes.buscarExpediente(cedula.trim());
    }

    /**
     * Registra una cita dentro del expediente.
     *
     * @param cedula cédula del paciente
     * @param doctor nombre del doctor
     * @param diagnostico diagnóstico
     * @return true si la cita fue registrada
     */
    public boolean registrarCita(
            String cedula,
            String doctor,
            String diagnostico) {

        if (doctor == null
                || doctor.trim().isEmpty()
                || diagnostico == null
                || diagnostico.trim().isEmpty()) {

            return false;
        }

        ExpedientePaciente expediente
                = buscarExpediente(cedula);

        if (expediente == null) {
            return false;
        }

        Cita cita = new Cita(
                new Date(),
                doctor.trim(),
                diagnostico.trim()
        );

        expediente.agregarCita(cita);

        return true;
    }

    /**
     * Registra un medicamento dentro del expediente.
     *
     * @param cedula cédula del paciente
     * @param nombreMedicamento nombre del medicamento
     * @return true si fue registrado
     */
    public boolean registrarMedicamento(
            String cedula,
            String nombreMedicamento) {

        if (nombreMedicamento == null
                || nombreMedicamento.trim().isEmpty()) {

            return false;
        }

        ExpedientePaciente expediente
                = buscarExpediente(cedula);

        if (expediente == null) {
            return false;
        }

        Medicamento medicamento = new Medicamento(
                new Date(),
                nombreMedicamento.trim()
        );

        expediente.agregarMedicamento(medicamento);

        return true;
    }

    /**
     * Muestra un expediente.
     *
     * @param cedula cédula del paciente
     * @return información del expediente
     */
    public String mostrarExpediente(String cedula) {

        ExpedientePaciente expediente
                = buscarExpediente(cedula);

        if (expediente == null) {

            return "No existe un expediente con esa cédula.";
        }

        return expediente.mostrarExpediente();
    }

    /**
     * Muestra todos los expedientes.
     *
     * @return expedientes registrados
     */
    public String mostrarTodosLosExpedientes() {

        return listaExpedientes.mostrarTodosLosExpedientes();
    }

    /**
     * Inicia la navegación por la lista de expedientes.
     *
     * @return primer expediente
     */
    public ExpedientePaciente iniciarNavegacionExpedientes() {

        return listaExpedientes.iniciarNavegacion();
    }

    /**
     * Devuelve el siguiente expediente.
     *
     * @return siguiente expediente
     */
    public ExpedientePaciente siguienteExpediente() {

        return listaExpedientes.siguienteExpediente();
    }

    /**
     * Devuelve el expediente anterior.
     *
     * @return expediente anterior
     */
    public ExpedientePaciente anteriorExpediente() {

        return listaExpedientes.anteriorExpediente();
    }

    /**
     * Muestra la bitácora de pacientes atendidos.
     *
     * @return información de la bitácora
     */
    public String mostrarBitacora() {

        return listaBitacora.mostrar();
    }

    /**
     * Cuenta los pacientes atendidos.
     *
     * @return cantidad de pacientes atendidos
     */
    public int totalAtendidos() {

        return listaBitacora.contar();
    }

    /**
     * Muestra los pacientes pendientes.
     *
     * @return información de las dos colas
     */
    public String mostrarPacientes() {

        String resultado = "";

        resultado += "====== COLA PREFERENCIAL ======\n";

        if (colaPreferencial.esVacia()) {

            resultado += "No hay pacientes preferenciales pendientes.\n";

        } else {

            resultado += colaPreferencial.mostrarPaciente(
                    0,
                    colaPreferencial.contarPacientes()
            );
        }

        resultado += "\n====== COLA REGULAR ======\n";

        if (colaRegular.esVacia()) {

            resultado += "No hay pacientes regulares pendientes.\n";

        } else {

            resultado += colaRegular.mostrarPaciente(
                    0,
                    colaRegular.contarPacientes()
            );
        }

        return resultado;
    }

    /**
     * Cuenta todos los pacientes pendientes.
     *
     * @return total de pacientes en ambas colas
     */
    public int totalPacientes() {

        return colaPreferencial.contarPacientes()
                + colaRegular.contarPacientes();
    }
}