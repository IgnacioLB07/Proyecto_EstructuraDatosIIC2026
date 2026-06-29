/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura;

import EstructurasBase.Cola;
import Modelo.Paciente;

/**
 *
 * @author ignap
 */
public class ColaPacientes extends Cola {

    //Atributos
    NodoPaciente frente;
    NodoPaciente fin;

    //Constructores
    public ColaPacientes() {
    }

    public ColaPacientes(NodoPaciente frente) {
        this.frente = this.fin = null;
    }

    //Getters & Setters
    //Metodos
    public void encolarPaciente(Paciente dato) {
        NodoPaciente nuevo = new NodoPaciente(dato);
        
        if (this.esVacia()) {
            this.frente = nuevo;
        }else {
        fin.setSiguiente(nuevo);
    }
        this.fin = nuevo;
    }

    public Paciente desencolarPaciente() throws Exception {
        if (this.esVacia()) { //Significa que la cola esta vacia
            throw new Exception("LA COLA ESTA VACIA");
        } //De acá en adelante se que la cola contiene elementos
        
        Paciente aux = frente.getDato(); //Guarda el valor del Frente, antes de eliminarlo
        frente = frente.getSiguiente(); //Mueve la referencia (Frente) al siguiente NodoCola
        
        if (this.esVacia()) { //Si la cola queda nula despues de eliminar. Fin queda nulo (Ambos quedan vacios)
            fin = null;
        }
        return aux; //Retorna el valor que tenia Frente antes de eliminarlo
    }

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

    public String mostrarPaciente() {
        if (esVacia()) {
            return "NO HAY PACIENTES EN LA COLA";
        }
        
        String msg = "";
        
        NodoPaciente actual = frente;
        
        while (actual != null) {            
            Paciente aux = actual.getDato();
            
            msg +=   "====== MOSTRAR PACIENTE ======"
                 + "\n Ficha: " + aux.getFicha()
                 + "\n Céula: " + aux.getCedula()
                 + "\n Nombre: " + aux.getNombre()
                 + "\n Fecha y Hora: " + aux.getFechaHoraLlegada()
                 + "\n Tipo: " + aux.getTipo()
                 + "\n==============================\n";
            
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
