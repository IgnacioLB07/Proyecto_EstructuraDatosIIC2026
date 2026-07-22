package Estructura;

import Modelo.BitacoraCita;

/**
 * Nodo de la lista simple de la bitácora de citas.
 *
 * @author nelson
 */
public class NodoBitacora {

    // Atributos
    private BitacoraCita dato;
    private NodoBitacora siguiente;

    // Constructores

    public NodoBitacora(BitacoraCita dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoBitacora() {
    }

    // Getters y Setters

    public BitacoraCita getDato() {
        return dato;
    }

    public void setDato(BitacoraCita dato) {
        this.dato = dato;
    }

    public NodoBitacora getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBitacora siguiente) {
        this.siguiente = siguiente;
    }

}