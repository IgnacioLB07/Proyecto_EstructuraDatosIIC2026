package Estructura;

import EstructurasBase.ArbolBinario;
import Modelo.ExpedientePaciente;

/**
 * Arbol Binario de Busqueda utilizado para almacenar
 * los expedientes medicos de los pacientes.
 *
 * Hereda de ArbolBinario.
 *
 * @author ignap
 */
public class ArbolExpedientes extends ArbolBinario {

    private NodoExpedienteArbol raizExpediente;

    /**
     * Constructor cargado.
     *
     * @param raizExpediente raiz del arbol
     */
    public ArbolExpedientes(
            NodoExpedienteArbol raizExpediente) {

        super();
        this.raizExpediente = raizExpediente;
    }

    /**
     * Constructor vacio.
     */
    public ArbolExpedientes() {

        super();
        raizExpediente = null;
    }

    /**
     * Verifica si el arbol esta vacio.
     *
     * @return true si esta vacio
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
     * Compara dos cedulas.
     *
     * @param cedula1 primera cedula
     * @param cedula2 segunda cedula
     * @return resultado de la comparacion
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
     * Busca un expediente por cedula.
     *
     * @param cedula cedula por buscar
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
     * @param cedula cedula por buscar
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
     * Recorre el arbol en inOrden e imprime
     * los expedientes en consola.
     */
    public void inOrden() {

        inOrdenRec(raizExpediente);
        System.out.println();
    }

    /**
     * Recorre recursivamente el arbol.
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
     * Cuenta los expedientes del arbol.
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
     * por cedula.
     *
     * @return informacion de los expedientes
     */
    public String mostrarInOrden() {

        if (esVacia()) {

            return "No existen expedientes registrados.";
        }

        return mostrarInOrdenRec(
                raizExpediente);
    }

    /**
     * Construye recursivamente la informacion
     * de los expedientes.
     *
     * @param nodoActual nodo actual
     * @return informacion de los expedientes
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
     * Devuelve la raiz del arbol.
     *
     * @return raiz del arbol
     */
    public NodoExpedienteArbol getRaizExpediente() {

        return raizExpediente;
    }

    /**
     * Modifica la raiz del arbol.
     *
     * @param raizExpediente nueva raiz
     */
    public void setRaizExpediente(
            NodoExpedienteArbol raizExpediente) {

        this.raizExpediente = raizExpediente;
    }
}