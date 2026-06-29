package Servicio;

import Estructura.ColaPacientes;
import Modelo.Paciente;
import Modelo.Queja;
import java.util.Date;

/**
 * Gestiona los/as pacientes del sistema hospitalario
 *
 * @author ignap
 */
public class GestorPacientes {

    //Atributos
    private ColaPacientes colaRegular;
    private ColaPacientes colaPreferencial;
    private GeneradorFicha generadorFicha;

    private int contadorPreferenciales = 0;
    private GestorQuejas gestorQ;

    //Constructores
    /**
     * Crea un gestor pacientes con los valores ingresados
     */
    public GestorPacientes() {
        colaRegular = new ColaPacientes();
        colaPreferencial = new ColaPacientes();
        generadorFicha = new GeneradorFicha();
        gestorQ = new GestorQuejas();
    }

    /**
     * Crea un gestro pacientes con los valores ingresados
     *
     * @param colaRegular cola de pacientes Regulares
     * @param colaPreferencial cola de pacientes Preferenciales
     * @param generadorFicha generador de ficha para los pacientes
     */
    public GestorPacientes(ColaPacientes colaRegular,
            ColaPacientes colaPreferencial, GeneradorFicha generadorFicha) {
        this.colaRegular = colaRegular;
        this.colaPreferencial = colaPreferencial;
        this.generadorFicha = generadorFicha;
    }

    //Getters
    /**
     * Obtiene la cola regular
     *
     * @return cola regular
     */
    public ColaPacientes getColaRegular() {
        return colaRegular;
    }

    /**
     * Obtiene la cola preferencial
     *
     * @return cola preferencial
     */
    public ColaPacientes getColaPreferencial() {
        return colaPreferencial;
    }

    /**
     * Obtiene el gestor de quejas asociado al gestor de pacientes
     * @return gestorQ
     */
    public GestorQuejas getGestorQ() {
        return gestorQ;
    }
    
    //Metodos
    /**
     * Método para crear fichas
     *
     * @return Paciente
     */
    public Paciente seleccionarFicha(String cedula, String nombre, String tipoPaciente) {

        String ficha;
        ColaPacientes cola;

        if (tipoPaciente.equals("Preferencial")) {
            ficha = generadorFicha.generarPreferencial();
            cola = colaPreferencial;

        } else {
            ficha = generadorFicha.generarRegular();
            cola = colaRegular;

        }
        Paciente nuevo = new Paciente(ficha, cedula, nombre,
                new Date(), tipoPaciente);

        cola.encolarPaciente(nuevo);

        return nuevo;

    }

    /**
     * Método para atender pacientes Cada 2 preferenciales se atiende uno
     * regular
     *
     * @return Paciente
     */
    public Paciente atenderPaciente() {
        Paciente paciente = null;

        // Si existen pacientes en ambas colas
        if (!colaPreferencial.esVacia() && !colaRegular.esVacia()) {

            if (contadorPreferenciales < 2) {
                paciente = colaPreferencial.desencolarPaciente();
                contadorPreferenciales++;
            } else {
                paciente = colaRegular.desencolarPaciente();
                contadorPreferenciales = 0;
            }

        } // Solo quedan preferenciales
        else if (!colaPreferencial.esVacia()) {
            paciente = colaPreferencial.desencolarPaciente();
        } // Solo quedan regulares
        else if (!colaRegular.esVacia()) {
            paciente = colaRegular.desencolarPaciente();
        }

        return paciente;
    }

    /**
     * Elimina de la cola al paciente indicado por su número de ficha y registra
     * una queja con el motivo proporcionado.
     *
     * Si la ficha pertenece a un paciente preferencial, se elimina de dicha
     * cola; de lo contrario, se busca en la cola regular. Cuando el paciente es
     * encontrado, la queja queda registrada para su revisión posterior.
     *
     * @param ficha Número de ficha del paciente que abandona la cola.
     * @param motivo Motivo indicado por el paciente para abandonar la cola.
     * @return El paciente eliminado o {@code null} si la ficha no existe.
     */
    public Paciente abandonarCola(String ficha, String motivo) {

        Paciente paciente = null;

        // Buscar primero en la cola preferencial
        paciente = colaPreferencial.eliminarPorFicha(ficha);

        // Si no está, buscar en la cola regular
        if (paciente == null) {
            paciente = colaRegular.eliminarPorFicha(ficha);
        }

        if (paciente != null) {
            //Crear la queja y guardarla en la pila
            gestorQ.registrarQueja(paciente, motivo);

        }
        return paciente;
    }

    /**
     * Obtiene la lista de pacientes pendientes de atención.
     *
     * @return Información de las colas de pacientes.
     */
    public String mostrarPacientes() {
        String msg = "==== COLA PREFERENCIALES ====\n\n"
                    + colaPreferencial.mostrarPaciente()
                    +"\n"
                    +"====== COLA  REGULARES ======\n\n"
                    + colaRegular.mostrarPaciente();
        
        return msg;
    }
}
