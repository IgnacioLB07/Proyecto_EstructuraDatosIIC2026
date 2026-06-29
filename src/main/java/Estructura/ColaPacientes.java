package Estructura;

import EstructurasBase.Cola;
import Modelo.Paciente;

/**
 * Clase hija de Cola, es la base del funcionamiento de Pacientes
 * @author ignap
 */
public class ColaPacientes extends Cola {

    //Atributos
    private NodoPaciente frente;
    private NodoPaciente fin;

    //Constructores
    /**
     * Crea una cola de pacientes con los datos ingresados
     * @param frente primer dato de la cola
     */
    public ColaPacientes(NodoPaciente frente) {
        this.frente = this.fin = null;
    }
    
    public ColaPacientes() {
    }

    //Metodos
    /**
     * Método para encolar un paciente a la cola 
     * @param dato valor del nodo
     */
    public void encolarPaciente(Paciente dato) {
        NodoPaciente nuevo = new NodoPaciente(dato);
        
        if (this.esVacia()) {
            this.frente = nuevo;
        }else {
        fin.setSiguiente(nuevo);
    }
        this.fin = nuevo;
    }

    /**
     * Método para desencolar un paciente de la cola
     * @return paciente
     */
    public Paciente desencolarPaciente() {
        if (this.esVacia()) { //Significa que la cola esta vacia
            return null;
        } //De acá en adelante se que la cola contiene elementos
        
        Paciente aux = frente.getDato(); //Guarda el valor del Frente, antes de eliminarlo
        frente = frente.getSiguiente(); //Mueve la referencia (Frente) al siguiente NodoCola
        
        if (this.esVacia()) { //Si la cola queda nula despues de eliminar. Fin queda nulo (Ambos quedan vacios)
            fin = null;
        }
        return aux; //Retorna el valor que tenia Frente antes de eliminarlo
    }

    /**
     * Método para eliminar un paciente por ficha
     * @param ficha posicion del paciente
     * @return paciente
     */
    public Paciente eliminarPorFicha(String ficha) {
        
        if (esVacia()) {
            return null;
        }
        if (frente.getDato().getFicha().equals(ficha)) {
            Paciente aux = frente.getDato();
            
            frente = frente.getSiguiente();
            
            if (frente == null) {
                fin = null;
            }
            
            return aux;
        }
        
        NodoPaciente anterior = frente;
        NodoPaciente actual = frente.getSiguiente();
        
        while (actual != null) {            
            
            if (actual.getDato().getFicha().equals(ficha)) {
                anterior.setSiguiente(actual.getSiguiente());
                
                if (actual == fin) {
                    fin = anterior;
                }
                return actual.getDato();
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        
        return null;
    }

    /**
     * Método que construye el mensaje que se va a mostrar al usuario en el menu
     * @return msg
     */
    public String mostrarPaciente() {
        if (esVacia()) {
            return "NO HAY PACIENTES EN LA COLA";
        }
        
        String msg = "";
        
        NodoPaciente actual = frente;
        
        while (actual != null) {            
            Paciente aux = actual.getDato();
            
            if (aux.getTipo().equals("Preferencial")) {
                msg +=   "====== MOSTRAR PACIENTE ======"
                     + "\n Ficha: <" + aux.getFicha() +">"
                     + "\n Céula: " + aux.getCedula()
                     + "\n Nombre: " + aux.getNombre()
                     + "\n Fecha y Hora: " + aux.getFechaHoraLlegada()
                     + "\n Tipo: " + aux.getTipo()
                     + "\n==============================\n";
                
            } else {
                msg +=   "====== MOSTRAR PACIENTE ======"
                     + "\n Ficha: " + aux.getFicha()
                     + "\n Céula: " + aux.getCedula()
                     + "\n Nombre: " + aux.getNombre()
                     + "\n Fecha y Hora: " + aux.getFechaHoraLlegada()
                     + "\n Tipo: " + aux.getTipo()
                     + "\n==============================\n";
            }
            
            actual = actual.getSiguiente();
        }
        
        return msg;
    }

    /**
     * Método que verifica si la cola esta vacia
     *
     * @return true/false
     */
    public boolean esVacia() {
        if (this.frente == null) {
            return true;
        } else {
            return false;
        }
    }

}
