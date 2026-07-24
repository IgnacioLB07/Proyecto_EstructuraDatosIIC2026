package Estructura;

import Modelo.ExpedientePaciente;

/**
 * Lista doble circular que almacena los expedientes únicos de los pacientes.
 *
 * Los expedientes se insertan ordenados de menor a mayor según la cédula.
 * La estructura permite recorrer los expedientes hacia adelante y hacia atrás.
 *
 * @author nelson
 */
public class ListaExpedientes {

    // Atributos
    private NodoExpediente primero;
    private NodoExpediente actual;

    // Constructor
    /**
     * Constructor vacio
     */
    public ListaExpedientes() {
        primero = null;
        actual = null;
    }

    /**
     * Verifica que la lista este vacia
     * @return true/false si esta vacia
     */
    public boolean esVacia() {
        return primero == null;
    }

    /**
     * Compara las cedulas de los pacientes
     * 
     * @param cedula1 primer identificador de paciente
     * @param cedula2 segundo identificador de paciente
     * @return comparacion de cedulas
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
     * Verifica que al insertar un Expediente este correcto
     * @param expediente datos medicos del paciente
     * @return true/false si se inserto el expediente
     */
    public boolean insertarExpediente(ExpedientePaciente expediente) {

        if (expediente == null || expediente.getCedula() == null) {
            return false;
        }

        if (buscarExpediente(expediente.getCedula()) != null) {
            return false;
        }

        NodoExpediente nuevo = new NodoExpediente(expediente);

        if (esVacia()) {

            primero = nuevo;

            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);

            actual = primero;

            return true;
        }

        NodoExpediente ultimo = primero.getAnterior();

        if (compararCedulas(
                expediente.getCedula(),
                primero.getDato().getCedula()) < 0) {

            nuevo.setSiguiente(primero);
            nuevo.setAnterior(ultimo);

            ultimo.setSiguiente(nuevo);
            primero.setAnterior(nuevo);

            primero = nuevo;
            actual = primero;

            return true;
        }

        NodoExpediente recorrido = primero.getSiguiente();

        while (recorrido != primero
                && compararCedulas(
                        expediente.getCedula(),
                        recorrido.getDato().getCedula()) > 0) {

            recorrido = recorrido.getSiguiente();
        }

        NodoExpediente anterior = recorrido.getAnterior();

        nuevo.setSiguiente(recorrido);
        nuevo.setAnterior(anterior);

        anterior.setSiguiente(nuevo);
        recorrido.setAnterior(nuevo);

        return true;
    }

    /**
     * Busca al expediente en la lista
     * 
     * @param cedula identificador del paciente
     * @return los datos del expediente
     */
    public ExpedientePaciente buscarExpediente(String cedula) {

        if (esVacia() || cedula == null) {
            return null;
        }

        NodoExpediente recorrido = primero;

        do {

            if (recorrido.getDato().getCedula().equalsIgnoreCase(
                    cedula.trim())) {

                return recorrido.getDato();
            }

            recorrido = recorrido.getSiguiente();

        } while (recorrido != primero);

        return null;
    }

    /**
     * Inicia la navegacion de expedientes
     * @return el expediente requerido
     */
    public ExpedientePaciente iniciarNavegacion() {

        if (esVacia()) {
            actual = null;
            return null;
        }

        actual = primero;
        return actual.getDato();
    }

    /**
     * Pasa al siguiente expediente
     * @return el expediente requerido
     */
    public ExpedientePaciente siguienteExpediente() {

        if (esVacia()) {
            return null;
        }

        if (actual == null) {
            actual = primero;
        } else {
            actual = actual.getSiguiente();
        }

        return actual.getDato();
    }

    /**
     * Se devuelve al expediente anterior
     * @return el expediente requerido
     */
    public ExpedientePaciente anteriorExpediente() {

        if (esVacia()) {
            return null;
        }

        if (actual == null) {
            actual = primero;
        } else {
            actual = actual.getAnterior();
        }

        return actual.getDato();
    }

    /**
     * Devuelve el expediente en la posicion actual
     * 
     * @return el expediente actual
     */
    public ExpedientePaciente getExpedienteActual() {

        if (actual == null) {
            return null;
        }

        return actual.getDato();
    }

    /**
     * Devuelve un string mostrando los expedientes
     * @return mensaje
     */
    public String mostrarTodosLosExpedientes() {

        if (esVacia()) {
            return "No existen expedientes registrados.";
        }

        String mensaje = "";
        NodoExpediente recorrido = primero;

        do {

            mensaje += recorrido.getDato().mostrarExpediente();
            mensaje += "\n\n";

            recorrido = recorrido.getSiguiente();

        } while (recorrido != primero);

        return mensaje;
    }

    /**
     * Cuenta los expedientes 
     * @return cantidad de expedientes
     */
    public int contarExpedientes() {

        if (esVacia()) {
            return 0;
        }

        int contador = 0;
        NodoExpediente recorrido = primero;

        do {

            contador++;
            recorrido = recorrido.getSiguiente();

        } while (recorrido != primero);

        return contador;
    }

    /**
     * Devuelve el primer expediente
     * @return primer expediente
     */
    public NodoExpediente getPrimero() {
        return primero;
    }
}