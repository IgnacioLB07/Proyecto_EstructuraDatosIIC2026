/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Estructura.PilaQuejas;
import Modelo.Queja;

public class GestorQuejas {
    
     private PilaQuejas pilaQuejas;

    // Constructor
    public GestorQuejas() {
        pilaQuejas = new PilaQuejas();
    }

    // Registrar una nueva queja
    public void registrarQueja(Queja queja) {
        pilaQuejas.apilar(queja);
    }

    // Mostrar todas las quejas
    public void mostrarQuejas() {
        System.out.println(pilaQuejas.mostrarQuejas());
    }

    // Obtener la última queja
    public Queja obtenerUltimaQueja() {

        try {
            return pilaQuejas.desapilar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    // Verificar si la pila está vacía
    public boolean hayQuejas() {
        return !pilaQuejas.esVacia();
    }

    public PilaQuejas getPilaQuejas() {
        return pilaQuejas;
    }

    public void setPilaQuejas(PilaQuejas pilaQuejas) {
        this.pilaQuejas = pilaQuejas;
    }

    
}
