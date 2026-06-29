/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructura;

import Modelo.Queja;

public class PilaQuejas {
    
  private NodoQueja cima;

    public PilaQuejas() {
        cima = null;
    }

    public boolean esVacia() {
        return cima == null;
    }

    // Insertar una queja
    public void apilar(Queja queja) {

        NodoQueja nuevo = new NodoQueja(queja);

        nuevo.setSiguiente(cima);

        cima = nuevo;

    }

    // Eliminar una queja
    public Queja desapilar() throws Exception {

        if (esVacia()) {
            throw new Exception("La pila está vacía.");
        }

        Queja aux = cima.getDato();

        cima = cima.getSiguiente();

        return aux;

    }

    // Ver la última queja
    public Queja cima() {

        if (esVacia()) {
            return null;
        }

        return cima.getDato();

    }

    // Mostrar todas las quejas
    public String mostrarQuejas() {

        if (esVacia()) {
            return "No existen quejas.";
        }

        String msg = "";

        NodoQueja actual = cima;

        while (actual != null) {

            Queja q = actual.getDato();

            msg += "=============================\n";
            msg += "Motivo: " + q.getMotivo() + "\n";
            msg += "Fecha: " + q.getFechaHoraSalida() + "\n";
            msg += "=============================\n\n";

            actual = actual.getSiguiente();

        }

        return msg;

    }  
    
}
