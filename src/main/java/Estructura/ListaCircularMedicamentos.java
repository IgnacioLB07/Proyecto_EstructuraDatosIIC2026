package Estructura;

import Modelo.Medicamento;

/**
 * Lista Simple Circular para almacenar
 * el histórico de medicamentos prescritos.
 *
 * @author nelson
 */
public class ListaCircularMedicamentos {

    // Atributos
    private NodoMedicamento ultimo;

    // Constructor
    public ListaCircularMedicamentos() {
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
     * Inserta un medicamento en la lista.
     *
     * @param medicamento medicamento a registrar
     */
    public void insertarMedicamento(Medicamento medicamento) {

        NodoMedicamento nuevo = new NodoMedicamento(medicamento);

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
     * Muestra todos los medicamentos registrados.
     *
     * @return historial de medicamentos
     */
    public String mostrarMedicamentos() {

        if (esVacia()) {
            return "No existen medicamentos registrados.\n";
        }

        String mensaje = "";

        NodoMedicamento actual = ultimo.getSiguiente();

        do {

            mensaje += "---------------------------------\n";
            mensaje += actual.getDato().toString();
            mensaje += "\n";

            actual = actual.getSiguiente();

        } while (actual != ultimo.getSiguiente());

        return mensaje;
    }

}