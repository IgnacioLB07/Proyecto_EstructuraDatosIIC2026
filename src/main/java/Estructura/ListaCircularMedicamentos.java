package Estructura;

import EstructurasBase.ListaCircular;
import Modelo.Medicamento;

/**
 * Lista simple circular utilizada para almacenar
 * el historial de medicamentos de un paciente.
 *
 * Hereda de ListaCircular.
 *
 * @author nelson
 */
public class ListaCircularMedicamentos
        extends ListaCircular {

    private NodoMedicamento ultimo;

    /**
     * Constructor.
     */
    public ListaCircularMedicamentos() {

        ultimo = null;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si no existen medicamentos
     */
    public boolean esVacia() {

        return ultimo == null;
    }

    /**
     * Inserta un medicamento al final de la lista.
     *
     * @param medicamento medicamento por registrar
     */
    public void insertarMedicamento(
            Medicamento medicamento) {

        if (medicamento == null) {
            return;
        }

        NodoMedicamento nuevo
                = new NodoMedicamento(
                        medicamento);

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
     * Muestra todos los medicamentos registrados.
     *
     * @return historial de medicamentos
     */
    public String mostrarMedicamentos() {

        if (esVacia()) {

            return "No existen medicamentos registrados.\n";
        }

        String mensaje = "";

        NodoMedicamento actual
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
     * Verifica si existe un medicamento
     * dentro del historial.
     *
     * La comparación no distingue mayúsculas
     * de minúsculas.
     *
     * @param medicamento medicamento buscado
     * @return true si existe
     */
    public boolean contieneMedicamento(
            String medicamento) {

        if (esVacia()
                || medicamento == null
                || medicamento.trim().isEmpty()) {

            return false;
        }

        NodoMedicamento actual
                = ultimo.getSiguiente();

        do {

            Medicamento dato
                    = actual.getDato();

            if (dato != null
                    && dato.getMedicamento() != null
                    && dato.getMedicamento()
                            .equalsIgnoreCase(
                                    medicamento.trim())) {

                return true;
            }

            actual = actual.getSiguiente();

        } while (actual
                != ultimo.getSiguiente());

        return false;
    }

    /**
     * Devuelve el último nodo de medicamentos.
     *
     * El nombre evita conflicto con getUltimo()
     * de la clase base ListaCircular.
     *
     * @return último nodo de medicamentos
     */
    public NodoMedicamento
            getUltimoMedicamento() {

        return ultimo;
    }

    /**
     * Modifica el último nodo de medicamentos.
     *
     * @param ultimo nuevo último nodo
     */
    public void setUltimoMedicamento(
            NodoMedicamento ultimo) {

        this.ultimo = ultimo;
    }
}