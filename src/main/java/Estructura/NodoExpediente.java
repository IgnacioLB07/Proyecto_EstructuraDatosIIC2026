package Estructura;

import Modelo.ExpedientePaciente;

/**
 * Nodo de la lista doble circular de expedientes.
 *
 * @author nelson
 */
public class NodoExpediente {

    // Atributos
    private ExpedientePaciente dato;
    private NodoExpediente siguiente;
    private NodoExpediente anterior;

    // Constructores

    /**
     * Crea un nodo con un expediente.
     *
     * @param dato expediente del paciente
     */
    public NodoExpediente(ExpedientePaciente dato) {
        this.dato = dato;
    }

    /**
     * Constructor vacío.
     */
    public NodoExpediente() {
    }

    // Getters y Setters

    /**
     * Devuelve el dato
     * @return dato del nodo
     */
    public ExpedientePaciente getDato() {
        return dato;
    }

    /**
     * Guarda el dato
     * @param dato informacion del nodo
     */
    public void setDato(ExpedientePaciente dato) {
        this.dato = dato;
    }

    /**
     * Devuelve el siguiente nodo
     * @return nodo siguiente
     */
    public NodoExpediente getSiguiente() {
        return siguiente;
    }

    /**
     * Guarda el siguiente nodo
     * @param siguiente nodo siguiente
     */
    public void setSiguiente(NodoExpediente siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Devuelve el nodo anterior
     * @return nodo anterior
     */
    public NodoExpediente getAnterior() {
        return anterior;
    }

    /**
     * Guarda el nodo anterior
     * @param anterior nodo anterior
     */
    public void setAnterior(NodoExpediente anterior) {
        this.anterior = anterior;
    }

}