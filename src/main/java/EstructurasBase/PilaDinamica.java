package EstructurasBase;

/**
 * Clase base para las pilas dinamicas del sistema
 * @author ignap
 */
public class PilaDinamica {

    //Atributos
    private NodoPilas cima;  //  Debemos guarda el elemento que está en la cima (top).

    //Contructores
    /**
     * Crea una nueva PilaDinamica con los valores ingresados
     */
    public PilaDinamica() {}

    // Getter & Setter
    /**
     * Modifica la cima
     * @param cima top de la pila
     */
    public void setCima(NodoPilas cima) {
        this.cima = cima;
    }

    /**
     * Obtiene la cima
     * @return cima
     */
    public NodoPilas getCima() {
        return cima;
    }

    // Métodos
    /**
     * Método apilar o push. 
     * Permite insertar un elemento (enviado por parámetro) a la pila.
     * @param valor dato del nodo
     */
    public void apilar(int valor) {
        NodoPilas miNodo = new NodoPilas();
        miNodo.setValor(valor);

        if (esVacia()) { // Caso 1: Si la pila está vacía.
            cima = miNodo;
        } else {  // Caso 2: Si la pila tiene elementos.
            miNodo.setAnterior(cima);     // Amarro eñ muevo Nodo al resto de la pila.
            cima = miNodo;      //Muevo la cima al nuevo Nodo para tener una nueva cima.
        }
    }

    /**
     * Método para desapilar (eliminar).
     * Permite sacar un elemento de la pila (pop).
     * @return cimaAnterior
     */
    public NodoPilas desapilar() {
        if (esVacia()) {   // Evita stack underflow Ocurre si intentamos realizar una operación de pop() o peek() en una pila vacía, lo cual no es permitido.
            return null;
        } else {      // Si la Pila tiene elementos, procedemos a hacer pop
            NodoPilas cimaAnterior = cima;   // Creo un puntero temporal y lo igual a la cima.
            cima = cima.getAnterior();   // Muevo la cima al de bajo para poder eliminar el de arriba.
            return cimaAnterior;                // retorno el puntero temporal que todavía apunta al elemento elimando.
        }
    }

    /**
     * Método para desapilar(eliminar)
     * SIN RETORNAR valor
     */
    public void desapilarSinRetornar() {
        if (esVacia()) {   // Evita stack underflow Ocurre si intentamos realizar una operación de pop() o peek() en una pila vacía, lo cual no es permitido.
            return;
        } else {      // Si la Pila tiene elementos, procedemos a hacer pop
            cima = cima.getAnterior();   // Muevo la cima al de bajo para poder eliminar el de arriba.
        }
    }

    /**
     * Método peek. 
     * Retornar retorna cima SIN eliminarla.
     * @return cima
     */
    public NodoPilas devuelveCima() {
        if (esVacia()) {   // Evita stack underflow Ocurre si intentamos realizar una operación de pop() o peek() en una pila vacía, lo cual no es permitido.
            System.out.println("La Pila está Vacía");
            return null;
        } else // Si la pila tiene elementos
        {
            return cima;
        }
    }

    /**
     * Método que retorna true si la pila está vacía o false si tiene elementos.
     * @return true/false
     */
    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que imprime la pila sin alterar la EEDD
     */
    public void imprimePila() {
        NodoPilas aux = cima; // Creo una variable auxiliar y la igualo a la cima. Esta variable me permitirá
        // recorrer la EEDD sin alterarla. Para no mover la cima.
        while (aux != null) {
            System.out.println(aux.getValor());
            aux = aux.getAnterior();
        }
    }

    /**
     * Retorna el tamaño de la Pila.
     * Si la pila está vacía retorna 0.
     * @return valor
     */
    public int retornarTamaño() {

        int valor = 0;

        if (esVacia()) {
            return valor;
        }

        return valor;
    }

    /**
     * Método que imprimePilaRec (RECURSIVO)
     * Base publica para llamar a imprimePilaRecursivo
     */
    public void imprimePilaRec() {
        imprimePilaRecursivo(cima);
    }

    /**
     * Método recursivo que imprime la EEDD
     * @param nodo caja con el dato de la pila
     */
    private void imprimePilaRecursivo(NodoPilas nodo) {

        if (esVacia()) {
            return;
        }

        System.out.println(nodo.getValor());

        imprimePilaRecursivo(nodo.getAnterior());
    }
}
