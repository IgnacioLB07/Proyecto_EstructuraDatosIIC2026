package EstructurasBase;

/**
 * Clase Nodo que ayuda al funcionamiento de la Cola
 *
 * @author ignap
 */
public class NodoCola {

    //Atributos
    private int dato;
    private NodoCola siguiente;

    //Constructores
    /**
     * Crea un nuevo nodo con los datos ingresados
     *
     * @param dato valor del nodo
     */
    public NodoCola(int dato) {
        this.dato = dato;
    }

    //Getters & Setters
    /**
     * Obtiene el dato del nodo
     *
     * @return dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * Modifica el dato del nodo
     *
     * @param dato valor del nodo
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el dato siguiente del nodo
     *
     * @return siguiente
     */
    public NodoCola getSiguiente() {
        return siguiente;
    }

    /**
     * Modifica el dato siguiente del nodo
     *
     * @param siguiente valor despues del primer nodo
     */
    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

}
