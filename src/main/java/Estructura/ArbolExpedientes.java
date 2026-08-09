package Estructura;

import EstructurasBase.ArbolBinario;
import Modelo.ExpedientePaciente;

/**
 * Árbol Binario de Búsqueda utilizado para almacenar
 * los expedientes médicos de los pacientes.
 *
 * Hereda de ArbolBinario.
 *
 * @author ignap
 */
public class ArbolExpedientes extends ArbolBinario {

    private NodoExpedienteArbol raizExpediente;

    // Atributos auxiliares para la paginación
    private int indicePagina;
    private int mostradosPagina;
    private String mensajePagina;

    /**
     * Constructor cargado.
     *
     * @param raizExpediente raíz del árbol
     */
    public ArbolExpedientes(
            NodoExpedienteArbol raizExpediente) {

        super();
        this.raizExpediente = raizExpediente;
    }

    /**
     * Constructor vacío.
     */
    public ArbolExpedientes() {

        super();
        raizExpediente = null;
    }

    /**
     * Verifica si el árbol está vacío.
     *
     * @return true si está vacío
     */
    public boolean esVacia() {

        return raizExpediente == null;
    }

    /**
     * Inserta un expediente en el ABB.
     *
     * @param expediente expediente del paciente
     */
    public void insertar(
            ExpedientePaciente expediente) {

        if (expediente == null
                || expediente.getCedula() == null
                || expediente.getCedula().trim().isEmpty()) {

            return;
        }

        raizExpediente = insertarRec(
                raizExpediente,
                expediente);
    }

    /**
     * Inserta recursivamente un expediente.
     *
     * @param nodoActual nodo actual
     * @param expediente expediente por insertar
     * @return nodo actualizado
     */
    private NodoExpedienteArbol insertarRec(
            NodoExpedienteArbol nodoActual,
            ExpedientePaciente expediente) {

        if (nodoActual == null) {

            return new NodoExpedienteArbol(
                    expediente);
        }

        int comparacion = compararCedulas(
                expediente.getCedula(),
                nodoActual.getDato().getCedula());

        if (comparacion < 0) {

            nodoActual.setNodoIzq(
                    insertarRec(
                            nodoActual.getNodoIzq(),
                            expediente));

        } else if (comparacion > 0) {

            nodoActual.setNodoDer(
                    insertarRec(
                            nodoActual.getNodoDer(),
                            expediente));
        }

        return nodoActual;
    }

    /**
     * Compara dos cédulas.
     *
     * @param cedula1 primera cédula
     * @param cedula2 segunda cédula
     * @return resultado de la comparación
     */
    private int compararCedulas(
            String cedula1,
            String cedula2) {

        String valor1 = cedula1
                .replace("-", "")
                .trim();

        String valor2 = cedula2
                .replace("-", "")
                .trim();

        try {

            long numero1 = Long.parseLong(valor1);
            long numero2 = Long.parseLong(valor2);

            return Long.compare(
                    numero1,
                    numero2);

        } catch (NumberFormatException e) {

            return valor1.compareToIgnoreCase(
                    valor2);
        }
    }

    /**
     * Busca un expediente por cédula.
     *
     * @param cedula cédula por buscar
     * @return expediente encontrado o null
     */
    public ExpedientePaciente buscarExpediente(
            String cedula) {

        if (cedula == null
                || cedula.trim().isEmpty()) {

            return null;
        }

        return buscarExpedienteRec(
                raizExpediente,
                cedula.trim());
    }

    /**
     * Busca recursivamente un expediente.
     *
     * @param nodoActual nodo actual
     * @param cedula cédula por buscar
     * @return expediente encontrado o null
     */
    private ExpedientePaciente buscarExpedienteRec(
            NodoExpedienteArbol nodoActual,
            String cedula) {

        if (nodoActual == null) {

            return null;
        }

        int comparacion = compararCedulas(
                cedula,
                nodoActual.getDato().getCedula());

        if (comparacion == 0) {

            return nodoActual.getDato();
        }

        if (comparacion < 0) {

            return buscarExpedienteRec(
                    nodoActual.getNodoIzq(),
                    cedula);
        }

        return buscarExpedienteRec(
                nodoActual.getNodoDer(),
                cedula);
    }

    /**
     * Recorre el árbol en InOrden e imprime
     * los expedientes en consola.
     */
    public void inOrden() {

        inOrdenRec(raizExpediente);
        System.out.println();
    }

    /**
     * Recorre recursivamente el árbol.
     *
     * @param nodoActual nodo actual
     */
    private void inOrdenRec(
            NodoExpedienteArbol nodoActual) {

        if (nodoActual != null) {

            inOrdenRec(
                    nodoActual.getNodoIzq());

            System.out.println(
                    nodoActual.getDato());

            inOrdenRec(
                    nodoActual.getNodoDer());
        }
    }

    /**
     * Cuenta los expedientes del árbol.
     *
     * @return cantidad de expedientes
     */
    public int contarExpedientes() {

        return contarExpedientesRec(
                raizExpediente);
    }

    /**
     * Cuenta recursivamente los expedientes.
     *
     * @param nodoActual nodo actual
     * @return cantidad de nodos
     */
    private int contarExpedientesRec(
            NodoExpedienteArbol nodoActual) {

        if (nodoActual == null) {

            return 0;
        }

        return 1
                + contarExpedientesRec(
                        nodoActual.getNodoIzq())
                + contarExpedientesRec(
                        nodoActual.getNodoDer());
    }

    /**
     * Muestra todos los expedientes ordenados
     * por cédula.
     *
     * @return información de los expedientes
     */
    public String mostrarInOrden() {

        if (esVacia()) {

            return "No existen expedientes registrados.";
        }

        return mostrarInOrdenRec(
                raizExpediente);
    }

    /**
     * Construye recursivamente la información
     * de todos los expedientes.
     *
     * @param nodoActual nodo actual
     * @return información de los expedientes
     */
    private String mostrarInOrdenRec(
            NodoExpedienteArbol nodoActual) {

        if (nodoActual == null) {

            return "";
        }

        String mensaje = "";

        mensaje += mostrarInOrdenRec(
                nodoActual.getNodoIzq());

        mensaje += nodoActual.getDato()
                .mostrarExpediente();

        mensaje += "\n\n";

        mensaje += mostrarInOrdenRec(
                nodoActual.getNodoDer());

        return mensaje;
    }

    /**
     * Muestra una cantidad de expedientes a partir
     * de una posición determinada.
     *
     * @param inicio posición inicial
     * @param cantidad cantidad de expedientes
     * @return expedientes solicitados
     */
    public String mostrarInOrden(
            int inicio,
            int cantidad) {

        if (esVacia()) {

            return "No existen expedientes registrados.";
        }

        if (inicio < 0) {

            inicio = 0;
        }

        if (cantidad <= 0) {

            return "No hay expedientes para mostrar.";
        }

        indicePagina = 0;
        mostradosPagina = 0;
        mensajePagina = "";

        mostrarPaginaRec(
                raizExpediente,
                inicio,
                cantidad);

        if (mensajePagina.isEmpty()) {

            return "No existen expedientes en esa posición.";
        }

        return mensajePagina;
    }

    /**
     * Recorre el árbol en InOrden y obtiene únicamente
     * los expedientes correspondientes a una página.
     *
     * @param nodoActual nodo actual
     * @param inicio posición inicial
     * @param cantidad cantidad máxima
     */
    private void mostrarPaginaRec(
            NodoExpedienteArbol nodoActual,
            int inicio,
            int cantidad) {

        if (nodoActual == null
                || mostradosPagina >= cantidad) {

            return;
        }

        mostrarPaginaRec(
                nodoActual.getNodoIzq(),
                inicio,
                cantidad);

        if (mostradosPagina >= cantidad) {

            return;
        }

        if (indicePagina >= inicio) {

            mensajePagina
                    += nodoActual.getDato()
                            .mostrarExpediente();

            mensajePagina += "\n\n";

            mostradosPagina++;
        }

        indicePagina++;

        mostrarPaginaRec(
                nodoActual.getNodoDer(),
                inicio,
                cantidad);
    }

    /**
     * Devuelve la raíz del árbol.
     *
     * @return raíz del árbol
     */
    public NodoExpedienteArbol getRaizExpediente() {

        return raizExpediente;
    }

    /**
     * Modifica la raíz del árbol.
     *
     * @param raizExpediente nueva raíz
     */
    public void setRaizExpediente(
            NodoExpedienteArbol raizExpediente) {

        this.raizExpediente = raizExpediente;
    }
}