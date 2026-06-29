package EstructurasBase;

/**
 * 
 * @author ignap
 */
public class NodoPilas {

    //Atributos
    private int valor;
    private NodoPilas anterior;

    //Constructores
    /**
     * Crea un nuevo nodo con los datos ingresados
     * @param valor 
     */
    public NodoPilas() {}

    public NodoPilas(int valor) {
        this.valor = valor;
    }

    //Getters & Setters
    /**
     * Obtiene el valor del nodo
     * @return 
     */
    public int getValor() {
        return valor;
    }

    /**
     * Obtiene el valor anterior del nodo
     * @return 
     */
    public NodoPilas getAnterior() {
        return anterior;
    }

    /**
     * Modifica el valor del nodo
     * @param valor 
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Modifica el valor anterior del nodo
     * @param anterior 
     */
    public void setAnterior(NodoPilas anterior) {
        this.anterior = anterior;
    }
}
