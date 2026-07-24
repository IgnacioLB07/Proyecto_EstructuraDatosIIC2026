package EstructurasBase;

/**
 *
 * @author EQUIPO
 */
public class ListaEnlazadaSimple {
   private NodoListaSimple cabeza;

    public ListaEnlazadaSimple() {
    }

    public NodoListaSimple getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoListaSimple cabeza) {
        this.cabeza = cabeza;
    }
    
    
    //Inicio de la sección de métodos de la clase
    
    public void insertaOrdenado(Contacto contacto){
    
         NodoListaSimple nuevoNodo = new NodoListaSimple(contacto);
         
        // Caso 1: Lista Vacía.
        if (this.getCabeza() == null) { // La lista esta vacía
            cabeza = nuevoNodo;
        }else // Caso 2: Teléfono a insertar es menor al primero.
            if (cabeza.getDato().getTelefono() >= contacto.getTelefono()){  
                nuevoNodo.setSiguiente(cabeza); //Amarrar el nuevo nodo a la lista.
                cabeza = nuevoNodo;    // Mover la cabeza al nuevo primer elemento
            }
            else {// Caso 3: Cuando el télefono a insertar es mayor al primero. 
                    // Recorrer la lista.
                    NodoListaSimple aux = cabeza;      // Creo un auxiliar, lo igualo a la cabeza.
                    while ((aux.getSiguiente() != null) &&
                           aux.getSiguiente().getDato().getTelefono() < contacto.getTelefono()){
                        aux = aux.getSiguiente();
                    }
                    // Insertar el nuevo nodo en la posición correcta.
                    
                    //Amarro la nueva cajita al siguiente de la lista
                    nuevoNodo.setSiguiente(aux.getSiguiente());
                    // Amarrar la lista a la nueva cajita.
                    aux.setSiguiente(nuevoNodo);
            }
    }
    
    public void eliminarNodo(String nombreEliminar){
        NodoListaSimple actual= cabeza;  // Creo un nodo auxiliar, lo igualo a la cabeza para recorrer.
        NodoListaSimple anterior = null; // Guarda una referencia al que está antes del actual.
        while (actual != null && !actual.getDato().getNombre().equals(nombreEliminar)){
            anterior = actual;      // Actualizo el anterior antes de mover el actual.
            actual = actual.getSiguiente(); //muevo el actual al siguiente.
        }        
        //Caso 1; No se encontró el elemento.
        if (actual == null) // Significa que llegó al final de la lista y no lo encontró.
            return;
        // Caso 2: Eliminar el primero de la lista.
        if (anterior == null)
            cabeza = cabeza.getSiguiente();  // Le caigo encima a la cabeza con el segundo.
        else
        // Caso 3: Quiero eliminar un elemento diferente al primero de la lista.
            anterior.setSiguiente(actual.getSiguiente());   // Saltarse la cajita que quiero eliminar.
            //anterior.setSiguiente(anterior.getSiguiente().getSiguiente();
    }
    
    public boolean buscarContacto(String nombre){
        NodoListaSimple aux = cabeza; // Creo una referencia auxiliar para recorrer la lista
        while (aux != null){
            if (aux.getDato().getNombre().equals(nombre))
                return true;
            else
                aux = aux.getSiguiente();
        }
        return false;
    }
    
    public void mostrarContactos(){
        NodoListaSimple aux = cabeza; // Creo una referencia auxiliar para recorrer la lista
        while (aux != null){
            System.out.println("Nombre"+ aux.getDato().getNombre() + " Teléfono: "+ aux.getDato().getTelefono());
            aux = aux.getSiguiente();
        }
    }   
}
