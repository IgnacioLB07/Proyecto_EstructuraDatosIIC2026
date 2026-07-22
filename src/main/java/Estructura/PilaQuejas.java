package Estructura;

import Modelo.Queja;

/**
 * Pila dinámica utilizada para almacenar las quejas.
 *
 * @author nelson
 */
public class PilaQuejas {

    // Nodo ubicado en la cima de la pila
    private NodoQueja cima;

    /**
     * Constructor de la pila.
     */
    public PilaQuejas() {
        cima = null;
    }

    /**
     * Agrega una queja en la cima de la pila.
     *
     * @param queja queja que se desea almacenar
     */
    public void apilarQueja(Queja queja) {

        if (queja == null) {
            return;
        }

        NodoQueja nuevoNodo = new NodoQueja();

        nuevoNodo.setValor(queja);
        nuevoNodo.setAnterior(cima);

        cima = nuevoNodo;
    }

    /**
     * Elimina y devuelve la última queja registrada.
     *
     * @return queja eliminada o null si la pila está vacía
     */
    public Queja desapilarQueja() {

        if (esVacia()) {
            return null;
        }

        Queja quejaEliminada = cima.getValor();

        cima = cima.getAnterior();

        return quejaEliminada;
    }

    /**
     * Devuelve la última queja sin eliminarla.
     *
     * @return última queja registrada
     */
    public Queja devuelveQueja() {

        if (esVacia()) {
            return null;
        }

        return cima.getValor();
    }

    /**
     * Determina si la pila está vacía.
     *
     * @return true si está vacía; false si contiene quejas
     */
    public boolean esVacia() {
        return cima == null;
    }

    /**
     * Cuenta las quejas registradas.
     *
     * @return cantidad de quejas
     */
    public int contarQuejas() {

        int contador = 0;

        NodoQueja auxiliar = cima;

        while (auxiliar != null) {

            contador++;

            auxiliar = auxiliar.getAnterior();
        }

        return contador;
    }

    /**
     * Muestra todas las quejas registradas.
     *
     * @return información de las quejas
     */
    public String mostrarQuejas() {

        return mostrarQuejas(0, contarQuejas());
    }

    /**
     * Muestra las quejas mediante paginación.
     *
     * @param inicio posición desde la que se empieza a mostrar
     * @param cantidad cantidad máxima de quejas
     * @return información de las quejas
     */
    public String mostrarQuejas(int inicio, int cantidad) {

        if (esVacia()) {
            return "No existen quejas registradas.";
        }

        if (inicio < 0) {
            inicio = 0;
        }

        if (cantidad <= 0) {
            return "No hay quejas para mostrar.";
        }

        String mensaje = "";

        NodoQueja auxiliar = cima;

        int posicion = 0;
        int mostradas = 0;

        while (auxiliar != null && mostradas < cantidad) {

            if (posicion >= inicio) {

                Queja queja = auxiliar.getValor();

                mensaje += "QUEJA REGISTRADA\n";
                mensaje += "Ficha: "
                        + queja.getFicha() + "\n";

                mensaje += "Cédula: "
                        + queja.getCedula() + "\n";

                mensaje += "Motivo: "
                        + queja.getMotivo() + "\n";

                mensaje += "Fecha y hora de salida: "
                        + queja.getFechaHoraSalida() + "\n";

                mensaje += "-----------------------------\n\n";

                mostradas++;
            }

            posicion++;

            auxiliar = auxiliar.getAnterior();
        }

        if (mensaje.isEmpty()) {
            return "No existen quejas en esa posición.";
        }

        return mensaje;
    }

    /**
     * Obtiene la cima de la pila.
     *
     * @return nodo ubicado en la cima
     */
    public NodoQueja getCima() {
        return cima;
    }

    /**
     * Modifica la cima de la pila.
     *
     * @param cima nueva cima
     */
    public void setCima(NodoQueja cima) {
        this.cima = cima;
    }
}