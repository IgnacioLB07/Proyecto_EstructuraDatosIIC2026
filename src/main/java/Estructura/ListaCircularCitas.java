package Estructura;

import EstructurasBase.ListaCircular;
import Modelo.Cita;

/**
 * Lista simple circular utilizada para almacenar
 * el historial de citas de un paciente.
 *
 * Hereda de ListaCircular.
 *
 * @author nelson
 */
public class ListaCircularCitas extends ListaCircular {

    // Último nodo de la lista circular de citas
    private NodoCita ultimo;

    /**
     * Constructor.
     */
    public ListaCircularCitas() {

        ultimo = null;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si no existen citas
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

        if (cita == null) {
            return;
        }

        NodoCita nuevo
                = new NodoCita(cita);

        if (esVacia()) {

            ultimo = nuevo;

            ultimo.setSiguiente(ultimo);

        } else {

            nuevo.setSiguiente(
                    ultimo.getSiguiente());

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

        NodoCita actual
                = ultimo.getSiguiente();

        do {

            mensaje += "---------------------------------\n";

            mensaje += actual.getDato().toString();

            mensaje += "\n";

            actual = actual.getSiguiente();

        } while (actual
                != ultimo.getSiguiente());

        return mensaje;
    }

    /**
     * Agrega los diagnósticos de las citas
     * a la lista utilizada por el módulo BI.
     *
     * @param lista lista de diagnósticos
     */
    public void acumularDiagnosticos(
            ListaDiagnosticos lista) {

        if (esVacia() || lista == null) {
            return;
        }

        NodoCita actual
                = ultimo.getSiguiente();

        do {

            Cita cita = actual.getDato();

            if (cita != null
                    && cita.getDiagnostico() != null
                    && !cita.getDiagnostico()
                            .trim().isEmpty()) {

                lista.registrarDiagnostico(
                        cita.getDiagnostico());
            }

            actual = actual.getSiguiente();

        } while (actual
                != ultimo.getSiguiente());
    }

    /**
     * Verifica si en el historial existe
     * un diagnóstico determinado.
     *
     * @param diagnostico diagnóstico buscado
     * @return true si existe el diagnóstico
     */
    public boolean contieneDiagnostico(
            String diagnostico) {

        if (esVacia()
                || diagnostico == null
                || diagnostico.trim().isEmpty()) {

            return false;
        }

        NodoCita actual
                = ultimo.getSiguiente();

        do {

            Cita cita = actual.getDato();

            if (cita != null
                    && cita.getDiagnostico() != null
                    && cita.getDiagnostico()
                            .equalsIgnoreCase(
                                    diagnostico.trim())) {

                return true;
            }

            actual = actual.getSiguiente();

        } while (actual
                != ultimo.getSiguiente());

        return false;
    }

    /**
     * Devuelve el último nodo de citas.
     *
     * Se utiliza un nombre diferente a getUltimo()
     * porque la clase ListaCircular ya tiene un método
     * con ese nombre y devuelve otro tipo de nodo.
     *
     * @return último nodo de citas
     */
    public NodoCita getUltimoCita() {

        return ultimo;
    }

    /**
     * Modifica el último nodo de citas.
     *
     * @param ultimo nuevo último nodo
     */
    public void setUltimoCita(
            NodoCita ultimo) {

        this.ultimo = ultimo;
    }
}