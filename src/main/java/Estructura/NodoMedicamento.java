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

    /**
     * Devuelve el dato del nodo
     * @return dato del nodo
     */
    public Medicamento getDato() {
        return dato;
    }

    /**
     * Guarda el dato del nodo
     * @param dato informacion del nodo
     */
    public void setDato(Medicamento dato) {
        this.dato = dato;
    }

    /**
     * Devuelve el siguiente nodo
     * @return nodo siguiente
     */
    public NodoMedicamento getSiguiente() {
        return siguiente;
    }

    /**
     * Guarda el nodo siguiente
     * @param siguiente siguiente nodo
     */
    public void setSiguiente(NodoMedicamento siguiente) {
        this.siguiente = siguiente;
    }
}