package Estructura;

import EstructurasBase.ListaEnlazadaSimple;

/**
 * Lista enlazada utilizada para contar los
 * diagnósticos encontrados en los expedientes.
 *
 * Hereda de ListaEnlazadaSimple.
 *
 * @author nelson
 */
public class ListaDiagnosticos
        extends ListaEnlazadaSimple {

    private NodoDiagnostico primero;

    /**
     * Constructor.
     */
    public ListaDiagnosticos() {

        primero = null;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si está vacía
     */
    public boolean esVacia() {

        return primero == null;
    }

    /**
     * Registra un diagnóstico.
     *
     * Si ya existe, aumenta su cantidad.
     * Si no existe, crea un nuevo nodo.
     *
     * @param diagnostico diagnóstico encontrado
     */
    public void registrarDiagnostico(
            String diagnostico) {

        if (diagnostico == null
                || diagnostico.trim().isEmpty()) {

            return;
        }

        String nombre
                = diagnostico.trim().toUpperCase();

        NodoDiagnostico encontrado
                = buscarNodo(nombre);

        if (encontrado != null) {

            encontrado.aumentarCantidad();
            return;
        }

        NodoDiagnostico nuevo
                = new NodoDiagnostico(nombre);

        if (esVacia()) {

            primero = nuevo;
            return;
        }

        nuevo.setSiguiente(primero);
        primero = nuevo;
    }

    /**
     * Busca un diagnóstico en la lista.
     *
     * @param diagnostico diagnóstico buscado
     * @return nodo encontrado o null
     */
    private NodoDiagnostico buscarNodo(
            String diagnostico) {

        NodoDiagnostico actual = primero;

        while (actual != null) {

            if (actual.getDiagnostico()
                    .equalsIgnoreCase(diagnostico)) {

                return actual;
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    /**
     * Cuenta los diagnósticos diferentes.
     *
     * @return cantidad de diagnósticos
     */
    public int contarDiagnosticos() {

        int contador = 0;

        NodoDiagnostico actual = primero;

        while (actual != null) {

            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }

    /**
     * Muestra los diagnósticos ordenados desde
     * el más frecuente hasta el menos frecuente.
     *
     * @return reporte de diagnósticos
     */
    public String mostrarPorFrecuencia() {

        if (esVacia()) {

            return "No existen diagnósticos registrados.";
        }

        reiniciarMostrados();

        String mensaje = "";
        int total = contarDiagnosticos();

        for (int i = 0; i < total; i++) {

            NodoDiagnostico mayor
                    = buscarMayorNoMostrado();

            if (mayor != null) {

                mensaje += mayor.getDiagnostico()
                        + ": "
                        + mayor.getCantidad();

                if (mayor.getCantidad() == 1) {

                    mensaje += " caso\n";

                } else {

                    mensaje += " casos\n";
                }

                mayor.setMostrado(true);
            }
        }

        reiniciarMostrados();

        return mensaje;
    }

    /**
     * Busca el diagnóstico con mayor cantidad
     * que todavía no haya sido mostrado.
     *
     * @return nodo con mayor frecuencia
     */
    private NodoDiagnostico
            buscarMayorNoMostrado() {

        NodoDiagnostico actual = primero;
        NodoDiagnostico mayor = null;

        while (actual != null) {

            if (!actual.isMostrado()) {

                if (mayor == null
                        || actual.getCantidad()
                        > mayor.getCantidad()) {

                    mayor = actual;

                } else if (actual.getCantidad()
                        == mayor.getCantidad()
                        && actual.getDiagnostico()
                                .compareToIgnoreCase(
                                        mayor.getDiagnostico())
                        < 0) {

                    mayor = actual;
                }
            }

            actual = actual.getSiguiente();
        }

        return mayor;
    }

    /**
     * Coloca todos los nodos como no mostrados.
     */
    private void reiniciarMostrados() {

        NodoDiagnostico actual = primero;

        while (actual != null) {

            actual.setMostrado(false);
            actual = actual.getSiguiente();
        }
    }

    public NodoDiagnostico getPrimero() {
        return primero;
    }

    public void setPrimero(
            NodoDiagnostico primero) {

        this.primero = primero;
    }
}