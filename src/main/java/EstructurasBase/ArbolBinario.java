package EstructurasBase;

import java.util.Stack;
/**
 *
 * @author EQUIPO
 */
public class ArbolBinario {
    private NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    // Método wrapper. Que envuelve el llamado al método recursivo.
    public void insertar (int valor){
        raiz = insertarRec(raiz, valor);
    }
    
    // Método recursivo que recibe el nodo actual por donde se encuentra dentor del arbol y el valor que desea insertar.
    private NodoArbol insertarRec(NodoArbol nodoActual,int valor){
        // Caso 1: El nodo actual está vacío.
        if (nodoActual == null)
                return new NodoArbol(valor);
        else{
            if (valor < nodoActual.getDato()){
                // camino de la izquierda
                NodoArbol nodoAux = insertarRec(nodoActual.getNodoIzq(),valor);
                nodoActual.setNodoIzq(nodoAux);
            }
            else if (valor > nodoActual.getDato()){
                // camino de la derecha
                nodoActual.setNodoDer(insertarRec(nodoActual.getNodoDer(),valor));
            }
            return nodoActual;
        }
    }
    // método wrapper o envoltura.
    public void inOrden(){
        inOrdenRec(raiz);
        System.out.println();
    }    
    
    
    public void inOrdenRec(NodoArbol nodoActual){
        if (nodoActual != null){
            inOrdenRec(nodoActual.getNodoIzq());
            System.out.print(nodoActual.getDato()+ ", ");
            inOrdenRec(nodoActual.getNodoDer());
        }
    
    }

    // método wrapper o envoltura.
    public void preOrden(){
        preOrdenRec(raiz);
        System.out.println();
        
    }    
    
    
    public void preOrdenRec(NodoArbol nodoActual){
        if (nodoActual != null){
            System.out.print(nodoActual.getDato()+ ", ");
            preOrdenRec(nodoActual.getNodoIzq());
            preOrdenRec(nodoActual.getNodoDer());
        }
    
    }

    // método wrapper o envoltura.
    public void postOrden(){
        postOrden(raiz);
        System.out.println();
        
    }    
    
    
    public void postOrden(NodoArbol nodoActual){
        if (nodoActual != null){
            postOrden(nodoActual.getNodoIzq());
            postOrden(nodoActual.getNodoDer());
            System.out.print(nodoActual.getDato()+ ", ");
        }
    
    }
    
    public void eliminar (int valor){
        raiz = eliminarRec(raiz, valor);
    }
    
    private NodoArbol eliminarRec(NodoArbol nodoActual, int valor){
        if (nodoActual == null) return null;
        
        // Buscar el elemento a eliminar
        if (valor < nodoActual.getDato()){
            nodoActual.setNodoIzq(eliminarRec(nodoActual.getNodoIzq(),valor));
        }else if (valor > nodoActual.getDato()){
                nodoActual.setNodoDer(eliminarRec(nodoActual.getNodoDer(),valor));
        }
        else{   // Lo encontré
            //  Caso 1: Nodo sin hijos (hoja)
            if (nodoActual.getNodoIzq() == null && nodoActual.getNodoDer() == null){
                return null;
            }
            // Caso 2: Nodo con un solo hijo.
            if (nodoActual.getNodoIzq() == null){
                return nodoActual.getNodoDer();
            }
            else if (nodoActual.getNodoDer() == null){
                return nodoActual.getNodoIzq();
            }
            
            // Caso 3: Nodo con 2 hijos.
            NodoArbol sucesor = minValorNodo(nodoActual.getNodoDer());  // Obtenr el sucedor InOrden del elemento a eliminar.
            nodoActual.setDato(sucesor.getDato());      // Reemplazo el dato para que sea el sucesor InOrden
            nodoActual.setNodoDer(eliminarRec(nodoActual.getNodoDer(),sucesor.getDato())); // Eliminar el sucesor de su lugar original para que no este repetido.
        }
        return nodoActual;
    }
    
    // método miscelaneo que retorna cual es el sucesor inOrden del nodo que deseo eliminar.
    private NodoArbol minValorNodo(NodoArbol nodo){
        while (nodo.getNodoIzq() != null){
            nodo = nodo.getNodoIzq();
        }
        return nodo;
    }
    
    ///// Métodos de semana 11.
    public int obtenerNivel (int valor){
        return obtenerNivelRec(raiz, valor, 0);
    
    }

    // Método Recursivo que obtiene el nivel del árbol.
    private int obtenerNivelRec (NodoArbol nodoActual, int valor, int nivel){
        if (nodoActual == null) return -1; //  Indicador de que no lo encontró.
        if (nodoActual.getDato() == valor) return nivel;
        
        // Buscarlo tanto a la izq como a la der.
        int nivelIzq = obtenerNivelRec(nodoActual.getNodoIzq(),valor, nivel+1);
        if (nivelIzq != -1)   // Significa que lo encontró
            return nivelIzq;
        else
            return obtenerNivelRec(nodoActual.getNodoDer(),valor, nivel+1);
    }
    
    
    public int obtenterAltura(){
    
        return obtenerAlturaRec(raiz);
    }
    
    private int obtenerAlturaRec(NodoArbol nodoActual){
        if (nodoActual == null)
            return -1;
        else{
            int alturaIzq = obtenerAlturaRec(nodoActual.getNodoIzq());
            int alturaDer = obtenerAlturaRec(nodoActual.getNodoDer());
            return Math.max(alturaIzq, alturaDer) + 1;
            /*if (alturaIzq > alturaDer)
                return alturaIzq + 1;
            else
                return alturaDer + 1;*/
        }
    }
    
   public void inOrdenIterativo(NodoArbol nodoActual){
       
       Stack <NodoArbol> pila = new Stack(); // Clase precompilada de JAVA que sirve de Pila.
       NodoArbol actual = raiz;
       while (actual != null || !pila.isEmpty() ){
           while (actual!= null){
               pila.push(actual);
               actual = actual.getNodoIzq();
           }
           actual = pila.pop();
           System.out.println(actual.getDato()+ "");
           actual = actual.getNodoDer();
        }    
   
   } 
   
   // Método wrapper que envuelve el método recursivo.,
    public int cuentaNodos(){
        return cuentaNodosRec(raiz);
    }

    private int cuentaNodosRec(NodoArbol nodoActual){
       if (nodoActual != null){
           int cuentaNodos = 1;
           cuentaNodos = cuentaNodos + cuentaNodosRec(nodoActual.getNodoIzq());
           cuentaNodos = cuentaNodos + cuentaNodosRec(nodoActual.getNodoDer());
           return cuentaNodos;
       }else 
            return 0;
    }
   
    
}
