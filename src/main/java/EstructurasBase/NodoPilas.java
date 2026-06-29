package EstructurasBase;

/**
 * Clase Nodo que ayuda al funcionamiento de la PilaDinamica
 * @author ignap
 */
public class NodoPilas {

    //Atributos
    private int valor;
    private NodoPilas anterior;

    //Constructores
    /**
     * Crea un nuevo nodo con los datos ingresados
     * @param valor dato del nodo
     */
    public NodoPilas(int valor) {
        this.valor = valor;
    }
    
    public NodoPilas() {}
    
    //Getters & Setters
    /**
     * Obtiene el valor del nodo
     * @return valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene el valor anterior del nodo
     * @return anterior
     */
    public NodoPilas getAnterior() {
        return anterior;
    }

    /**
     * Modifica el valor del nodo
     * @param valor dato del nodo
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Modifica el valor anterior del nodo
     * @param anterior una posicion anterior al dato inicial del nodo
     */
    public void setAnterior(NodoPilas anterior) {
        this.anterior = anterior;
    }
}
