package EstructurasBase;

/**
 *
 * @author EQUIPO
 */
public class ListaCircular {
    private NodoListaCircular primero;
    private NodoListaCircular ultimo;

    public ListaCircular() {
        this.primero = this.ultimo = null;
    }
    
    // Inicio de los get y set

    public NodoListaCircular getPrimero() {
        return primero;
    }

    public NodoListaCircular getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoListaCircular primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoListaCircular ultimo) {
        this.ultimo = ultimo;
    }
    
    // Inicio de los métodos operacionlaes.
    public void insertaOrdenado(Contacto contacto){
        
        NodoListaCircular nuevoNodo = new NodoListaCircular(contacto);
        
        // Caso 1: Lista vacía
        if (this.getPrimero() == null) { // La lista esta vacía
            // Inicializo el primero.
            primero = ultimo = nuevoNodo;
            ultimo.setSiguiente(primero);
        }else{  // Caso 2:// Caso 2: Teléfono a insertar es menor al primero.
            if (this.getPrimero().getDato().getTelefono() > contacto.getTelefono() ){
            
            nuevoNodo.setSiguiente(primero);  // Amarrar la nueva cajita al primero.
            primero = nuevoNodo;              // Mover el primero al nuevo primero.
            ultimo.setSiguiente(primero);     // Ligar el último al nuevo primero.
            }
            else{
            // Caso 3:  Caso 3: El elemento a insertar es mayor al último.
                if (ultimo.getDato().getTelefono()< contacto.getTelefono()){
                    ultimo.setSiguiente(nuevoNodo);  //Amarramos el último a la nueva cahita.
                    ultimo = nuevoNodo;              // Movemos el último.
                    ultimo.setSiguiente(primero);   // Ligar el nuevo último al primero. la hacemos circular
                }
                else{
                    // Caso 4: El elemento a insertar va en una posición intermedia de la lista.
                    // Debemos iterar.
                    NodoListaCircular aux = primero;
                    while (aux.getSiguiente().getDato().getTelefono() < contacto.getTelefono()){
                        aux = aux.getSiguiente();
                    }
                    nuevoNodo.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(nuevoNodo);
                    
                
                }
            }

        
        }
        
        
        
    }
    
}
