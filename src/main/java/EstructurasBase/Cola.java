package EstructurasBase;

/**
 * Clase base para las colas del sistema hospitalario
 * @author ignap
 */
public class Cola {
    
    //Atributos
    private NodoCola frente;
    private NodoCola fin;

    //Constructores
    /**
     * Crea una nueva Cola con los parametros ingresados
     * @param frente 
     */
    public Cola() {}

    public Cola(NodoCola frente) {
        this.frente = this.fin = null;
    }
    
    //Getters & Setters
    /**
     * Obtiene el frente de la cola
     * @return frente
     */
    public NodoCola getFrente() {
        return frente;
    }

    /**
     * Modifica el frente de la cola
     * @param frente 
     */
    public void setFrente(NodoCola frente) {
        this.frente = frente;
    }

    /**
     * Obtiene el fin de la cola
     * @return 
     */
    public NodoCola getFin() {
        return fin;
    }

    /**
     * Modifica el fin de la cola
     * @param fin 
     */
    public void setFin(NodoCola fin) {
        this.fin = fin;
    }
    
    // Metodos
    /**
     * Método para ingresar un nuevo dato a la cola
     * @param dato 
     */
    public void Encolar(int dato){
        NodoCola nuevo = new NodoCola(dato);
        
        if (this.esVacia()) {
            this.frente = nuevo;
        }else {
        fin.setSiguiente(nuevo);
    }
        this.fin = nuevo;
        
    }
    
    /**
     * Método para eliminar datos de la cola
     * @return aux
     * @throws Exception 
     */
    public int Desencolar() throws Exception {
        if (this.esVacia()) { //Significa que la cola esta vacia
            throw new Exception("LA COLA ESTA VACIA");
        } //De acá en adelante se que la cola contiene elementos
        
        int aux = frente.getDato(); //Guarda el valor del Frente, antes de eliminarlo
        frente = frente.getSiguiente(); //Mueve la referencia (Frente) al siguiente NodoCola
        
        if (this.esVacia()) { //Si la cola queda nula despues de eliminar. Fin queda nulo (Ambos quedan vacios)
            fin = null;
        }
        return aux; //Retorna el valor que tenia Frente antes de eliminarlo
    }

    /**
     * Método que verifica si la cola esta vacia
     * @return true/false
     */
    public boolean esVacia() {
        //return frente == null; Devuelve true si no hay elementos
        if (this.frente == null) {
            return true;
        }
        else
            return false;
    }
    
    /**
     * Método para imprimir la Cola sin modificarla
     */
    public void imprimeCola(){
        NodoCola aux = frente;
        
        while (aux != null){
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }
}
