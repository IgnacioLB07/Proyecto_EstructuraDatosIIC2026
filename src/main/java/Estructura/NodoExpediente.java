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

    public ExpedientePaciente getDato() {
        return dato;
    }

    public void setDato(ExpedientePaciente dato) {
        this.dato = dato;
    }

    public NodoExpediente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoExpediente siguiente) {
        this.siguiente = siguiente;
    }

    public NodoExpediente getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoExpediente anterior) {
        this.anterior = anterior;
    }

}