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

    private NodoExpediente primero;
    private NodoExpediente actual;

    public ListaExpedientes() {
        primero = null;
        actual = null;
    }

    public boolean esVacia() {
        return primero == null;
    }

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

    public ExpedientePaciente iniciarNavegacion() {

        if (esVacia()) {
            actual = null;
            return null;
        }

        actual = primero;
        return actual.getDato();
    }

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

    public ExpedientePaciente getExpedienteActual() {

        if (actual == null) {
            return null;
        }

        return actual.getDato();
    }

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

    public NodoExpediente getPrimero() {
        return primero;
    }
}