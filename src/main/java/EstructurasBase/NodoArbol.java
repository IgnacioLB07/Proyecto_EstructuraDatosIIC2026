package EstructurasBase;

/**
 *
 * @author EQUIPO
 */
public class NodoArbol {

    private int dato;
    private NodoArbol nodoIzq;
    private NodoArbol nodoDer;

    public NodoArbol(int dato) {
        this.dato = dato;
        this.nodoIzq = null;
        this.nodoDer = null;
    }

    public int getDato() {
        return dato;
    }

    public NodoArbol getNodoIzq() {
        return nodoIzq;
    }

    public NodoArbol getNodoDer() {
        return nodoDer;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setNodoIzq(NodoArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    public void setNodoDer(NodoArbol nodoDer) {
        this.nodoDer = nodoDer;
    }

}
