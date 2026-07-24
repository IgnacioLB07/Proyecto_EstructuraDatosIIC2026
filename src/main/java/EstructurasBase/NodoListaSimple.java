package EstructurasBase;

/**
 *
 * @author EQUIPO
 */
public class NodoListaSimple {

    private Contacto dato;
    NodoListaSimple siguiente;

    public NodoListaSimple(Contacto dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Contacto getDato() {
        return dato;
    }

    public NodoListaSimple getSiguiente() {
        return siguiente;
    }

    public void setDato(Contacto dato) {
        this.dato = dato;
    }

    public void setSiguiente(NodoListaSimple siguiente) {
        this.siguiente = siguiente;
    }

}
