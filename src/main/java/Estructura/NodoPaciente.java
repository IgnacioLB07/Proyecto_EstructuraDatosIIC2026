/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura;

import Modelo.Paciente;

/**
 * Representa un nodo de la cola de pacientes.
 * Cada nodo almacena un objeto Paciente y una referencia
 * al siguiente nodo de la cola.
 *
 * Esta clase sirve como base para la implementación de la
 * estructura dinámica ColaPacientes.
 *
 * @author ignap
 * @version 1.0
 */
public class NodoPaciente {

    //Atributos
    private Paciente dato;
    private NodoPaciente siguiente;

    //Constructores
    /**
     * Crea un nuevo nodo con el paciente indicado.
     *
     * @param dato Paciente que será almacenado en el nodo.
     */
    public NodoPaciente(Paciente dato) {
        this.dato = dato;
    }

    //Getters & Setters
    /**
     * Obtiene el paciente almacenado en el nodo.
     *
     * @return Paciente contenido en el nodo.
     */
    public Paciente getDato() {
        return dato;
    }

    /**
     * Modifica el paciente almacenado en el nodo.
     *
     * @param dato Nuevo paciente que almacenará el nodo.
     */
    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    /**
     * Obtiene la referencia al siguiente nodo.
     *
     * @return Siguiente nodo de la cola o {@code null} si es el último.
     */
    public NodoPaciente getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo.
     *
     * @param siguiente Nodo que se enlazará como siguiente.
     */
    public void setSiguiente(NodoPaciente siguiente) {
        this.siguiente = siguiente;
    }
}