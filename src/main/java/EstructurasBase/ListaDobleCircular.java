package EstructurasBase;

/**
 *
 * @author EQUIPO
 */
public class ListaDobleCircular {
    private NodoDoble primero;
    private NodoDoble ultimo;

    public ListaDobleCircular() {
    }

    public NodoDoble getPrimero() {
        return primero;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoDoble primero) {
        this.primero = primero;
    }

    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }
    
    
    public void insertaOrdena(Contacto contacto){
        NodoDoble nuevoNodo = new NodoDoble(contacto);
        if (primero == null) {     // Caso 1: La Lista está vacía.
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            
            ultimo.setSiguiente(primero);
            primero.setAnterior(ultimo);
        
        }else if (contacto.getTelefono() <= primero.getDato().getTelefono()) { // Caso 2: Insertar un elemento menor o igual al primero
            nuevoNodo.setSiguiente(primero);  // Amarra la nueva cajita a la izquierda del primero.
            primero.setAnterior(nuevoNodo);    // pone el anterior del primero amarrado a la nueva cajita.
            primero = nuevoNodo;                // Reescribo el primero para que sea la nueva cajita.
            primero.setAnterior(ultimo);        // Amarro el primero al último pero para atrás.
            ultimo.setSiguiente(primero);       // Hago circular la lista apuntando al nuevo primero.
        }
        else if (contacto.getTelefono() >= ultimo.getDato().getTelefono()){
            // Caso 3: Insertar un elemento mayor o igual al último
            ultimo.setSiguiente(nuevoNodo);      // Poner el sgte del último a apuntar a la nueva cajita.
            nuevoNodo.setAnterior(ultimo);       //Poner el anterior de lka nueva cajita a apuntar al último
            ultimo = nuevoNodo;                 // Movemos el último a la nueva cajita,
            primero.setAnterior(ultimo);        // Amarro el primero al último pero para atrás.
            ultimo.setSiguiente(primero);       // Hago circular la lista apuntando al nuevo primero.
        }else{
            // Caso 4 cuando quiero insertar en el medio.
            NodoDoble aux = primero;
            while (aux.getSiguiente().getDato().getTelefono() 
                    < contacto.getTelefono()){
                aux = aux.getSiguiente();
            }
            nuevoNodo.setSiguiente(aux.getSiguiente());  // AMarramos el sgte de la nueva cajita al que está después del aux
            nuevoNodo.setAnterior(aux);  // AMarramos la nueva cajita para atrás a la lista.
            aux.setSiguiente(nuevoNodo);    // Amarra el auxiliar a la nueva cajita.
            nuevoNodo.getSiguiente().setAnterior(nuevoNodo);// AMarro el siguiente de la nueva cajita hacia atras a la nueva cajita.
        
       }
        
    }
    
}
