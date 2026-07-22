package Estructura;

import Modelo.Medicamento;

/**
 * Nodo de la lista circular de medicamentos.
 *
 * @author nelson
 */
public class NodoMedicamento {

    // Atributos
    private Medicamento dato;
    private NodoMedicamento siguiente;

    // Constructores

    /**
     * Crea un nodo con un medicamento.
     *
     * @param dato medicamento a almacenar
     */
    public NodoMedicamento(Medicamento dato) {
        this.dato = dato;
    }

    /**
     * Constructor vacío.
     */
    public NodoMedicamento() {
    }

    // Getters y Setters

    public Medicamento getDato() {
        return dato;
    }

    public void setDato(Medicamento dato) {
        this.dato = dato;
    }

    public NodoMedicamento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMedicamento siguiente) {
        this.siguiente = siguiente;
    }
}