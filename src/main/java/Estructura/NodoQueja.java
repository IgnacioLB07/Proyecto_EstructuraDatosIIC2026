/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura;

import Modelo.Queja;

public class NodoQueja {
    
    private Queja dato;
    private NodoQueja siguiente;

    public NodoQueja(Queja dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Queja getDato() {
        return dato;
    }

    public void setDato(Queja dato) {
        this.dato = dato;
    }

    public NodoQueja getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoQueja siguiente) {
        this.siguiente = siguiente;
    }

    
}
