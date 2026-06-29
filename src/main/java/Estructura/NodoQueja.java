package Estructura;

import Modelo.Queja;

/**
 * Clase Nodo que ayuda al funcionamiento de la PilaQueja
 * @author johan
 */
public class NodoQueja {

    //Atributos
    private Queja valor;
    private NodoQueja anterior;

    //Constructores
    /**
     * Crea un nodo queja con los valores ingresados
     * @param valor 
     */
    public NodoQueja(Queja valor) {
        this.valor = valor;
    }
    
    public NodoQueja() {}

    //Getters & Setters
    /**
     * Obtiene el valor del nodo
     * @return valor del nodo
     */
    public Queja getValor() {
        return valor;
    }

    /**
     * Modifica el valor del nodo
     * @param valor 
     */
    public void setValor(Queja valor) {
        this.valor = valor;
    }

    /**
     * Obtiene el valor anterior del nodo
     * @return nodo anterior
     */
    public NodoQueja getAnterior() {
        return anterior;
    }

    /**
     * Modifica el valor anterior del nodo
     * @param anterior 
     */
    public void setAnterior(NodoQueja anterior) {
        this.anterior = anterior;
    }

}
