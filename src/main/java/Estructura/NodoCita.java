package Estructura;

import Modelo.Cita;

/**
 * Nodo de la lista circular de citas.
 *
 * @author nelson
 */
public class NodoCita {

    // Atributos
    private Cita dato;
    private NodoCita siguiente;

    // Constructores

    /**
     * Crea un nodo con una cita.
     *
     * @param dato cita que almacenará el nodo
     */
    public NodoCita(Cita dato) {
        this.dato = dato;
    }

    /**
     * Constructor vacío.
     */
    public NodoCita() {
    }

    // Getters y Setters

    /**
     * Obtiene la cita almacenada.
     *
     * @return cita
     */
    public Cita getDato() {
        return dato;
    }

    /**
     * Modifica la cita almacenada.
     *
     * @param dato nueva cita
     */
    public void setDato(Cita dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el siguiente nodo.
     *
     * @return siguiente nodo
     */
    public NodoCita getSiguiente() {
        return siguiente;
    }

    /**
     * Modifica el siguiente nodo.
     *
     * @param siguiente siguiente nodo
     */
    public void setSiguiente(NodoCita siguiente) {
        this.siguiente = siguiente;
    }

}