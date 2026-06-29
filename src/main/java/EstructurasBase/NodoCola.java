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
     * @param dato
     */
    public NodoCola(int dato) {
        this.dato = dato;
    }

    //Getters & Setters
    /**
     * Obtiene el dato del nodo
     *
     * @return
     */
    public int getDato() {
        return dato;
    }

    /**
     * Modifica el dato del nodo
     *
     * @param dato
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el dato siguiente del nodo
     *
     * @return
     */
    public NodoCola getSiguiente() {
        return siguiente;
    }

    /**
     * Modifica el dato siguiente del nodo
     *
     * @param siguiente
     */
    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }

}
