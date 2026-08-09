package Estructura;

import Modelo.ExpedientePaciente;

/**
 * Clase NodoExpedienteArbol usado para almacenar datos para una ABB
 * @author ignap
 */
public class NodoExpedienteArbol {
    
    //Atributos
    private ExpedientePaciente dato;
    private NodoExpedienteArbol nodoIzq;
    private NodoExpedienteArbol nodoDer;

    /**
     * Constructor cargado
     * @param dato informacion de expediente paciente
     */
    public NodoExpedienteArbol(ExpedientePaciente dato) {
        this.dato = dato;
    }

    /**
     * Constructor vacio
     */
    public NodoExpedienteArbol() {}
    
    /**
     * Devolver el nodo derecho
     * @return dato del nodo
     */
    public ExpedientePaciente getDato() {
        return dato;
    }

    /**
     * Guardar el dato del nodo
     * @param dato info del nodo
     */
    public void setDato(ExpedientePaciente dato) {
        this.dato = dato;
    }

    /**
     * Devolver el nodo izquierdo
     * @return nodoIzq
     */
    public NodoExpedienteArbol getNodoIzq() {
        return nodoIzq;
    }

    /**
     * Guardar el nodo izquierdo
     * @param nodoIzq nodo menor
     */
    public void setNodoIzq(NodoExpedienteArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    /**
     * Devolver el nodo derecho
     * @return nodoDer
     */
    public NodoExpedienteArbol getNodoDer() {
        return nodoDer;
    }

    /**
     * Guardar el nodo derecho
     * @param nodoDer nodo mayor
     */
    public void setNodoDer(NodoExpedienteArbol nodoDer) {
        this.nodoDer = nodoDer;
    }
    
}
