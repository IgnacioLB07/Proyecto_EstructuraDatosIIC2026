package Estructura;

import Modelo.Cita;

/**
 * Lista Simple Circular para almacenar el historial de citas de un paciente.
 *
 * @author nelson
 */
public class ListaCircularCitas {

    // Atributos
    private NodoCita ultimo;

    // Constructor
    public ListaCircularCitas() {
        ultimo = null;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si está vacía
     */
    public boolean esVacia() {
        return ultimo == null;
    }

    /**
     * Inserta una cita al final de la lista circular.
     *
     * @param cita cita que se desea registrar
     */
    public void insertarCita(Cita cita) {

        NodoCita nuevo = new NodoCita(cita);

        if (esVacia()) {

            ultimo = nuevo;
            ultimo.setSiguiente(ultimo);

        } else {

            nuevo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;

        }

    }

    /**
     * Muestra todas las citas registradas.
     *
     * @return historial de citas
     */
    public String mostrarCitas() {

        if (esVacia()) {
            return "No existen citas registradas.\n";
        }

        String mensaje = "";

        NodoCita actual = ultimo.getSiguiente();

        do {

            mensaje += "---------------------------------\n";
            mensaje += actual.getDato().toString();
            mensaje += "\n";

            actual = actual.getSiguiente();

        } while (actual != ultimo.getSiguiente());

        return mensaje;
    }

}