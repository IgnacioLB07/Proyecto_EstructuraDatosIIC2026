package Estructura;

import Modelo.BitacoraCita;

/**
 * Lista Simple Ordenada por cédula para almacenar
 * la bitácora de citas del día.
 *
 * @author nelson
 */
public class ListaBitacora {

    // Atributo
    private NodoBitacora primero;

    /**
     * Constructor.
     */
    public ListaBitacora() {
        primero = null;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si no contiene registros.
     */
    public boolean esVacia() {
        return primero == null;
    }

    /**
     * Compara dos cédulas.
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
     * Inserta un registro ordenado por cédula.
     *
     * @param cita registro de bitácora.
     */
    public void insertar(BitacoraCita cita) {

        NodoBitacora nuevo = new NodoBitacora(cita);

        // Lista vacía
        if (esVacia()) {

            primero = nuevo;
            return;

        }

        // Insertar al inicio
        if (compararCedulas(
                cita.getCedula(),
                primero.getDato().getCedula()) < 0) {

            nuevo.setSiguiente(primero);
            primero = nuevo;
            return;

        }

        NodoBitacora anterior = primero;
        NodoBitacora actual = primero.getSiguiente();

        while (actual != null
                && compararCedulas(
                        cita.getCedula(),
                        actual.getDato().getCedula()) > 0) {

            anterior = actual;
            actual = actual.getSiguiente();

        }

        nuevo.setSiguiente(actual);
        anterior.setSiguiente(nuevo);

    }

    /**
     * Busca un registro por cédula.
     *
     * @param cedula cédula a buscar.
     * @return registro encontrado o null.
     */
    public BitacoraCita buscar(String cedula) {

        NodoBitacora actual = primero;

        while (actual != null) {

            if (actual.getDato().getCedula().equalsIgnoreCase(cedula)) {
                return actual.getDato();
            }

            actual = actual.getSiguiente();

        }

        return null;

    }

    /**
     * Cuenta la cantidad de registros.
     *
     * @return total.
     */
    public int contar() {

        int contador = 0;

        NodoBitacora actual = primero;

        while (actual != null) {

            contador++;
            actual = actual.getSiguiente();

        }

        return contador;

    }

    /**
     * Muestra todos los registros.
     *
     * @return texto para JOptionPane.
     */
    public String mostrar() {

        if (esVacia()) {
            return "No existen registros en la bitácora.";
        }

        String mensaje = "";

        NodoBitacora actual = primero;

        while (actual != null) {

            mensaje += "=================================\n";
            mensaje += actual.getDato().toString();
            mensaje += "\n\n";

            actual = actual.getSiguiente();

        }

        return mensaje;

    }

    /**
     * Devuelve el primer nodo.
     *
     * @return primer nodo.
     */
    public NodoBitacora getPrimero() {
        return primero;
    }

}