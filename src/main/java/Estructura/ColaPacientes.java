package Estructura;

import Modelo.Paciente;

/**
 * Cola dinámica para almacenar pacientes.
 *
 * @author nelson
 */
public class ColaPacientes {

    private NodoPaciente frente;
    private NodoPaciente fin;
    private int cantidad;

    /**
     * Constructor de la cola.
     */
    public ColaPacientes() {
        frente = null;
        fin = null;
        cantidad = 0;
    }

    /**
     * Indica si la cola está vacía.
     *
     * @return true si no existen pacientes
     */
    public boolean esVacia() {
        return frente == null;
    }

    /**
     * Agrega un paciente al final de la cola.
     *
     * @param paciente paciente que será agregado
     */
    public void encolarPaciente(Paciente paciente) {

        if (paciente == null) {
            return;
        }

        NodoPaciente nuevo = new NodoPaciente(paciente);

        if (esVacia()) {

            frente = nuevo;
            fin = nuevo;

        } else {

            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        cantidad++;
    }

    /**
     * Elimina y devuelve el primer paciente.
     *
     * @return paciente eliminado o null
     */
    public Paciente desencolarPaciente() {

        if (esVacia()) {
            return null;
        }

        Paciente paciente = frente.getDato();

        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        cantidad--;

        return paciente;
    }

    /**
     * Devuelve el primer paciente sin eliminarlo.
     *
     * @return primer paciente o null
     */
    public Paciente verPrimerPaciente() {

        if (esVacia()) {
            return null;
        }

        return frente.getDato();
    }

    /**
     * Elimina un paciente mediante su ficha.
     *
     * @param ficha ficha que se desea buscar
     * @return paciente eliminado o null
     */
    public Paciente eliminarPorFicha(String ficha) {

        if (ficha == null || ficha.trim().isEmpty()) {
            return null;
        }

        NodoPaciente actual = frente;
        NodoPaciente anterior = null;

        while (actual != null) {

            Paciente pacienteActual = actual.getDato();

            if (pacienteActual.getFicha()
                    .equalsIgnoreCase(ficha.trim())) {

                if (anterior == null) {

                    frente = actual.getSiguiente();

                } else {

                    anterior.setSiguiente(
                            actual.getSiguiente()
                    );
                }

                if (actual == fin) {
                    fin = anterior;
                }

                cantidad--;

                if (frente == null) {
                    fin = null;
                }

                return pacienteActual;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return null;
    }

    /**
     * Cuenta los pacientes de la cola.
     *
     * @return cantidad de pacientes
     */
    public int contarPacientes() {
        return cantidad;
    }

    /**
     * Muestra todos los pacientes.
     *
     * @return información de los pacientes
     */
    public String mostrarPaciente() {

        return mostrarPaciente(0, cantidad);
    }

    /**
     * Muestra pacientes utilizando paginación.
     *
     * @param inicio posición inicial
     * @param cantidadMostrar cantidad máxima por mostrar
     * @return información de los pacientes
     */
    public String mostrarPaciente(
            int inicio,
            int cantidadMostrar) {

        if (esVacia()) {
            return "No existen pacientes pendientes.";
        }

        if (inicio < 0) {
            inicio = 0;
        }

        if (cantidadMostrar <= 0) {
            return "No hay pacientes para mostrar.";
        }

        String mensaje = "";

        NodoPaciente actual = frente;

        int posicion = 0;
        int mostrados = 0;

        while (actual != null
                && mostrados < cantidadMostrar) {

            if (posicion >= inicio) {

                Paciente paciente = actual.getDato();

                mensaje += "Ficha: "
                        + paciente.getFicha() + "\n";

                mensaje += "Cédula: "
                        + paciente.getCedula() + "\n";

                mensaje += "Nombre: "
                        + paciente.getNombre() + "\n";

                mensaje += "Fecha y hora de llegada: "
                        + paciente.getFechaHoraLlegada() + "\n";

                mensaje += "----------------------------------\n";

                mostrados++;
            }

            posicion++;
            actual = actual.getSiguiente();
        }

        if (mensaje.isEmpty()) {
            return "No existen pacientes en esa posición.";
        }

        return mensaje;
    }

    public NodoPaciente getFrente() {
        return frente;
    }

    public void setFrente(NodoPaciente frente) {
        this.frente = frente;
    }

    public NodoPaciente getFin() {
        return fin;
    }

    public void setFin(NodoPaciente fin) {
        this.fin = fin;
    }
}