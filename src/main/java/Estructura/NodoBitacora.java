package Estructura;

import Modelo.BitacoraCita;

/**
 * Nodo de la lista simple de la bitácora de citas.
 *
 * @author nelson
 */
public class NodoBitacora{

    // Atributos
    private BitacoraCita dato;
    private NodoBitacora siguiente;

    // Constructores
    /**
     * Constructor lleno
     * @param dato informacion del nodo
     */
    public NodoBitacora(BitacoraCita dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Constructor vacio
     */
    public NodoBitacora() {
    }

    // Getters y Setters
    /**
     * Devuelve el dato
     * @return dato del nodo
     */
    public BitacoraCita getDato() {
        return dato; 
    }
    
    /**
     * Guarda el dato
     * @param dato informacion del nodo
     */
    public void setDato(BitacoraCita dato) {
        this.dato = dato;
    }

    /**
     * Devuelve el nodo siguiente
     * @return siguiente nodo
     */
    public NodoBitacora getSiguiente() {
        return siguiente;
    }

    /**
     * Guarda el nodo siguiente
     * @param siguiente nodo que le sigue al puntero
     */
    public void setSiguiente(NodoBitacora siguiente) {
        this.siguiente = siguiente;
    }

}