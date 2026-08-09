package Servicio;

import Estructura.ArbolExpedientes;
import Modelo.ExpedientePaciente;
import java.io.File;
import java.io.IOException;

/**
 * Gestiona los expedientes almacenados en el ABB.
 *
 * @author nelson
 */
public class GestorExpedientes {

    private ArbolExpedientes arbolE;
    private CargadorJSON cargadorJSON;

    /**
     * Constructor vacío.
     */
    public GestorExpedientes() {

        arbolE = new ArbolExpedientes();
        cargadorJSON = new CargadorJSON(this);
    }

    /**
     * Constructor cargado.
     *
     * @param arbolE árbol de expedientes
     */
    public GestorExpedientes(
            ArbolExpedientes arbolE) {

        if (arbolE == null) {

            this.arbolE = new ArbolExpedientes();

        } else {

            this.arbolE = arbolE;
        }

        cargadorJSON = new CargadorJSON(this);
    }

    /**
     * Registra un expediente en el ABB.
     *
     * @param expediente expediente por registrar
     * @return true si fue registrado
     */
    public boolean registrarExpediente(
            ExpedientePaciente expediente) {

        if (expediente == null
                || expediente.getCedula() == null
                || expediente.getCedula().trim().isEmpty()) {

            return false;
        }

        ExpedientePaciente existente
                = arbolE.buscarExpediente(
                        expediente.getCedula());

        if (existente != null) {

            return false;
        }

        arbolE.insertar(expediente);

        return true;
    }

    /**
     * Carga expedientes desde un archivo JSON.
     *
     * @param archivo archivo seleccionado
     * @return cantidad de expedientes cargados
     * @throws IOException error de lectura
     */
    public int cargarExpedientesDesdeArchivo(
            File archivo) throws IOException {

        return cargadorJSON.cargarArchivo(
                archivo);
    }

    /**
     * Busca un expediente por cédula.
     *
     * @param cedula cédula del paciente
     * @return expediente encontrado o null
     */
    public ExpedientePaciente buscarExpediente(
            String cedula) {

        if (cedula == null
                || cedula.trim().isEmpty()) {

            return null;
        }

        return arbolE.buscarExpediente(
                cedula.trim());
    }

    /**
     * Muestra un expediente.
     *
     * @param cedula cédula del paciente
     * @return información del expediente
     */
    public String mostrarExpediente(
            String cedula) {

        ExpedientePaciente expediente
                = buscarExpediente(cedula);

        if (expediente == null) {

            return "No existe un expediente con esa cédula.";
        }

        return expediente.mostrarExpediente();
    }

    /**
     * Muestra todos los expedientes.
     *
     * @return información de los expedientes
     */
    public String mostrarExpedientes() {

        return arbolE.mostrarInOrden();
    }

    /**
     * Cuenta los expedientes.
     *
     * @return cantidad de expedientes
     */
    public int contarExpedientes() {

        return arbolE.contarExpedientes();
    }

    /**
     * Obtiene el árbol.
     *
     * @return árbol de expedientes
     */
    public ArbolExpedientes getArbolE() {

        return arbolE;
    }

    /**
     * Modifica el árbol.
     *
     * @param arbolE nuevo árbol
     */
    public void setArbolE(
            ArbolExpedientes arbolE) {

        if (arbolE == null) {

            this.arbolE = new ArbolExpedientes();

        } else {

            this.arbolE = arbolE;
        }
    }
}