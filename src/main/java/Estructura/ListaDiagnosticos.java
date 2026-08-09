package Estructura;

import EstructurasBase.ListaEnlazadaSimple;

/**
 * Lista enlazada utilizada para contabilizar los
 * diagnósticos encontrados en los expedientes.
 *
 * Los diagnósticos pueden mostrarse ordenados desde
 * el más frecuente hasta el menos frecuente.
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
     * Si el diagnóstico ya existe, aumenta su cantidad.
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
     * Busca un diagnóstico dentro de la lista.
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
     * Cuenta los diagnósticos diferentes almacenados.
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
     * Muestra todos los diagnósticos ordenados desde
     * el más frecuente hasta el menos frecuente.
     *
     * @return reporte completo de diagnósticos
     */
    public String mostrarPorFrecuencia() {

        return mostrarPorFrecuencia(
                0,
                contarDiagnosticos());
    }

    /**
     * Muestra los diagnósticos por páginas, ordenados
     * desde el más frecuente hasta el menos frecuente.
     *
     * @param inicio posición inicial
     * @param cantidad cantidad máxima por mostrar
     * @return diagnósticos correspondientes a la página
     */
    public String mostrarPorFrecuencia(
            int inicio,
            int cantidad) {

        if (esVacia()) {

            return "No existen diagnósticos registrados.";
        }

        if (inicio < 0) {

            inicio = 0;
        }

        if (cantidad <= 0) {

            return "No hay diagnósticos para mostrar.";
        }

        reiniciarMostrados();

        String mensaje = "";

        int total = contarDiagnosticos();
        int mostrados = 0;

        for (int posicion = 0;
                posicion < total
                && mostrados < cantidad;
                posicion++) {

            NodoDiagnostico mayor
                    = buscarMayorNoMostrado();

            if (mayor == null) {

                break;
            }

            if (posicion >= inicio) {

                mensaje += mayor.getDiagnostico();
                mensaje += ": ";
                mensaje += mayor.getCantidad();

                if (mayor.getCantidad() == 1) {

                    mensaje += " caso\n";

                } else {

                    mensaje += " casos\n";
                }

                mostrados++;
            }

            mayor.setMostrado(true);
        }

        reiniciarMostrados();

        if (mensaje.isEmpty()) {

            return "No existen diagnósticos "
                    + "en esa posición.";
        }

        return mensaje;
    }

    /**
     * Busca el diagnóstico con mayor cantidad que
     * todavía no haya sido mostrado.
     *
     * Si dos diagnósticos tienen la misma cantidad,
     * se utiliza el orden alfabético.
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

    /**
     * Devuelve el primer nodo.
     *
     * @return primer diagnóstico
     */
    public NodoDiagnostico getPrimero() {

        return primero;
    }

    /**
     * Modifica el primer nodo.
     *
     * @param primero nuevo primer nodo
     */
    public void setPrimero(
            NodoDiagnostico primero) {

        this.primero = primero;
    }
}