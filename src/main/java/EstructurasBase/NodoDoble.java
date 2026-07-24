package EstructurasBase;

/**
 *
 * @author EQUIPO
 */
public class NodoDoble {
    private Contacto dato;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(Contacto dato) {
        this.dato = dato;
        this.siguiente = this.anterior = null;
    }

    public Contacto getDato() {
        return dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setDato(Contacto dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }


    
}
