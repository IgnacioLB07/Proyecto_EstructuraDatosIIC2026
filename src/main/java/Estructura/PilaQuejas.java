package Estructura;

import EstructurasBase.PilaDinamica;
import Modelo.Queja;

/**
 * Clase hija de PilaDinamica, es la base del funcionamiento de Quejas
 *
 * @author johan
 */
public class PilaQuejas extends PilaDinamica {

    //Atributos
    private NodoQueja cima;

    //Constructores
    /**
     * Crea una pila de quejas con los valores ingresados
     */
    public PilaQuejas() {
    }

    //Metodos
    /**
     * Insertar una queja
     *
     * @param queja motivo de salida del paciente
     */
    public void apilarQueja(Queja queja) {

        NodoQueja nuevo = new NodoQueja();
        nuevo.setValor(queja);

        if (esVacia()) { // Caso 1: Si la pila está vacía.
            cima = nuevo;
        } else {  // Caso 2: Si la pila tiene elementos.
            nuevo.setAnterior(cima);     // Amarro eñ muevo Nodo al resto de la pila.
            cima = nuevo;      //Muevo la devuelveCima al nuevo Nodo para tener una nueva devuelveCima.
        }
    }

    /**
     * Eliminar una queja
     *
     * @return aux
     */
    public Queja desapilarQueja() {
        if (esVacia()) {
            return null;
        } else {
            Queja aux = cima.getValor();   // Creo un puntero temporal y lo igual a la devuelveCima.
            cima = cima.getAnterior();   // Muevo la devuelveCima al de bajo para poder eliminar el de arriba.
            return aux;
        }
    }

    /**
     * Ver la última queja
     *
     * @return Valor de la devuelveCima
     */
    public Queja devuelveQueja() {
        if (esVacia()) {
            return null;
        } else {
            return cima.getValor();
        }
    }

    /**
     * Mostrar todas las quejas
     *
     * @return msg
     */
    public String mostrarQuejas() {
        if (esVacia()) {
            return "No existen quejas.";
        }

        String msg = "";
        NodoQueja actual = cima;

        while (actual != null) {
            Queja q = actual.getValor();

            msg += "======== MOSTRAR QUEJA ========\n"
                    + "Ficha: " + q.getFicha() + "\n"
                    + "Con cédula: " + q.getCedula() + "\n"
                    + "Abandona la cola sin ser atendido(a)" + "\n"
                    + "A la Fecha y Hora: " + q.getFechaHoraSalida() + "\n"
                    + "Por el Motivo: " + q.getMotivo() + "\n"
                    + "=============================\n\n";

            actual = actual.getAnterior();
        }

        return msg;
    }

    /**
     * Muestra una cantidad específica de quejas a partir de una posición
     * determinada de la pila.
     *
     * @param inicio Posición desde la cual iniciar el recorrido.
     * @param cantidad Cantidad máxima de quejas a mostrar.
     * @return Información de las quejas solicitadas.
     */
    public String mostrarQuejas(int inicio, int cantidad) {

        if (esVacia()) {
            return "NO EXISTEN QUEJAS.";
        }

        String msg = "";

        NodoQueja actual = cima;

        int indice = 0;
        int mostradas = 0;

        while (actual != null && mostradas < cantidad) {

            if (indice >= inicio) {

                Queja q = actual.getValor();

                msg +=    "Ficha: " + q.getFicha() + "\n"
                        + "Con Cédula: " + q.getCedula() + "\n"
                        + "Abandona la cola sin ser atendido(a)" + "\n"
                        + "A la Fecha y Hora: " + q.getFechaHoraSalida() + "\n"
                        + "Por el Motivo: " + q.getMotivo() + "\n"
                        + "============================\n\n";

                mostradas++;
            }

            indice++;
            actual = actual.getAnterior();
        }

        return msg;
    }

    /**
     * Método que retorna true si la pila está vacía o false si tiene elementos.
     *
     * @return true/false
     */
    public boolean esVacia() {
        return cima == null;
    }

    /**
     * Cuenta la cantidad de quejas almacenadas en la pila.
     *
     * @return Cantidad de quejas registradas.
     */
    public int contarQuejas() {

        int contador = 0;

        NodoQueja actual = cima;

        while (actual != null) {
            contador++;
            actual = actual.getAnterior();
        }

        return contador;
    }
}
