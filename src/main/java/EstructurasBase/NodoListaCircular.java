package EstructurasBase;

/**
 *
 * @author EQUIPO
 */
public class NodoListaCircular {
    private Contacto dato;
    NodoListaCircular siguiente;

    public NodoListaCircular(Contacto dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Contacto getDato() {
        return dato;
    }

    public NodoListaCircular getSiguiente() {
        return siguiente;
    }

    public void setDato(Contacto dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoListaCircular siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
