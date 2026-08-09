package Estructura;

import EstructurasBase.ArbolBinario;
import Modelo.ExpedientePaciente;

/**
 * Clase ArbolExpedientes, almacena la lógica de una EEDD Arbol Binario de
 * Busqueda hereda de ArbolBinario
 *
 * @author ignap
 */
public class ArbolExpedientes extends ArbolBinario {

    //Atributos
    private NodoExpedienteArbol raizExpediente;

    /**
     * Constructor cargado
     *
     * @param raizExpediente
     */
    public ArbolExpedientes(NodoExpedienteArbol raizExpediente) {
        super();
        this.raizExpediente = raizExpediente;
    }

    /**
     * Constructor vacio
     */
    public ArbolExpedientes() {
    }

    /**
     * Metodo que verifica si la EEDD esta vacia
     *
     * @return true/false
     */
    public boolean esVacia() {
        return raizExpediente == null;
    }

    /**
     * Metodo warpper para insertar el expediente
     *
     * @param expediente datos del expediente
     */
    public void insertar(ExpedientePaciente expediente) {
        if (expediente == null || expediente.getCedula() == null) {
            return;
        }

        raizExpediente = insertarRec(raizExpediente, expediente);
    }

    /**
     * Método recursivo para insertar en el ABB
     *
     * @param nodoActual recibe la raiz y crea un nodo auxiliar
     * @param expediente recibe los datos del expediente
     * @return el nodo actual
     */
    private NodoExpedienteArbol insertarRec(NodoExpedienteArbol nodoActual, ExpedientePaciente expediente) {
        if (nodoActual == null) {
            return new NodoExpedienteArbol(expediente);
        }

        int comparacion = compararCedulas(expediente.getCedula(), nodoActual.getDato().getCedula());
        if (comparacion < 0) {
            nodoActual.setNodoIzq(insertarRec(nodoActual.getNodoIzq(), expediente));
        } else if (comparacion > 0) {
            nodoActual.setNodoDer(insertarRec(nodoActual.getNodoDer(), expediente));
        }

        return nodoActual;
    }

    /**
     * Metodo que compara dos cedulas
     *
     * @param cedula1 cedula 1
     * @param cedula2 cedula 2
     * @return valor de la comparacion entre cedulas
     */
    private int compararCedulas(String cedula1, String cedula2) {
        String valor1 = cedula1.replace("-", "").trim();
        String valor2 = cedula2.replace("-", "").trim();

        try {
            long numero1 = Long.parseLong(valor1);
            long numero2 = Long.parseLong(valor2);
            return Long.compare(numero1, numero2);

        } catch (NumberFormatException e) {
            return valor1.compareToIgnoreCase(valor2);
        }
    }

    /**
     * Metodo warpper inOrden
     */
    public void inOrden() {
        inOrdenRec(raizExpediente);
        System.out.println();
    }

    /**
     * Metodo recursivo que imprime el ABB en inOrden
     *
     * @param nodoActual
     */
    private void inOrdenRec(NodoExpedienteArbol nodoActual) {
        if (nodoActual != null) {
            inOrdenRec(nodoActual.getNodoIzq());
            System.out.print(nodoActual.getDato() + ", ");
            inOrdenRec(nodoActual.getNodoDer());
        }

    }

    /**
     * 
     * @param cedula
     * @return 
     */
    public ExpedientePaciente buscarExpediente(String cedula) {
        if (cedula == null || cedula.trim().isEmpty()) {
            return null;
        }

        return buscarExpedienteRec(raizExpediente, cedula);
    }

    /**
     * 
     * @param nodoActual
     * @param cedula
     * @return 
     */
    private ExpedientePaciente buscarExpedienteRec(NodoExpedienteArbol nodoActual, String cedula) {
        if (nodoActual == null) {
            return null;
        }

//        NodoExpedienteArbol nodo = (NodoExpedienteArbol) nodoActual; eliminar

        int comparacion = compararCedulas(cedula, nodoActual.getDato().getCedula());
        if (comparacion == 0) {
            return nodoActual.getDato();
        }

        if (comparacion < 0) {
            return buscarExpedienteRec(nodoActual.getNodoIzq(), cedula);
        }

        return buscarExpedienteRec(nodoActual.getNodoDer(), cedula);
    }

}
