package Servicio;

import Estructura.PilaQuejas;
import Modelo.Paciente;
import Modelo.Queja;
import java.util.Date;

/**
 * Clase encargada de gestionar las quejas de los pacientes.
 *
 * @author nelson
 */
public class GestorQuejas {

    private PilaQuejas pilaQuejas;

    /**
     * Constructor.
     */
    public GestorQuejas() {

        pilaQuejas = new PilaQuejas();
    }

    /**
     * Registra una queja utilizando los datos de un paciente.
     *
     * @param paciente paciente que abandonó la cola
     * @param motivo motivo de la queja
     * @return true si la queja fue registrada
     */
    public boolean registrarQueja(
            Paciente paciente,
            String motivo) {

        if (paciente == null
                || motivo == null
                || motivo.trim().isEmpty()) {

            return false;
        }

        Queja nuevaQueja = new Queja(
                paciente.getFicha(),
                paciente.getCedula(),
                motivo.trim(),
                new Date()
        );

        pilaQuejas.apilarQueja(nuevaQueja);

        return true;
    }

    /**
     * Registra una queja mediante ficha y cédula.
     *
     * @param ficha ficha del paciente
     * @param cedula cédula del paciente
     * @param motivo motivo de la queja
     * @return true si se registró correctamente
     */
    public boolean registrarQueja(
            String ficha,
            String cedula,
            String motivo) {

        if (ficha == null
                || ficha.trim().isEmpty()
                || cedula == null
                || cedula.trim().isEmpty()
                || motivo == null
                || motivo.trim().isEmpty()) {

            return false;
        }

        Queja nuevaQueja = new Queja(
                ficha.trim(),
                cedula.trim(),
                motivo.trim(),
                new Date()
        );

        pilaQuejas.apilarQueja(nuevaQueja);

        return true;
    }

    /**
     * Elimina la última queja registrada.
     *
     * @return queja eliminada
     */
    public Queja eliminarUltimaQueja() {

        return pilaQuejas.desapilarQueja();
    }

    /**
     * Obtiene la última queja sin eliminarla.
     *
     * @return última queja registrada
     */
    public Queja obtenerUltimaQueja() {

        return pilaQuejas.devuelveQueja();
    }

    /**
     * Muestra todas las quejas.
     *
     * @return información de las quejas
     */
    public String mostrarQuejas() {

        return pilaQuejas.mostrarQuejas();
    }

    /**
     * Muestra las quejas mediante paginación.
     *
     * @param inicio posición inicial
     * @param cantidad cantidad por mostrar
     * @return información de las quejas
     */
    public String mostrarQuejas(
            int inicio,
            int cantidad) {

        return pilaQuejas.mostrarQuejas(
                inicio,
                cantidad
        );
    }

    /**
     * Cuenta las quejas registradas.
     *
     * @return cantidad de quejas
     */
    public int contarQuejas() {

        return pilaQuejas.contarQuejas();
    }

    /**
     * Determina si existen quejas.
     *
     * @return true si no existen quejas
     */
    public boolean esVacia() {

        return pilaQuejas.esVacia();
    }

    /**
     * Obtiene la pila de quejas.
     *
     * @return pila de quejas
     */
    public PilaQuejas getPilaQuejas() {

        return pilaQuejas;
    }

    /**
     * Modifica la pila de quejas.
     *
     * @param pilaQuejas nueva pila
     */
    public void setPilaQuejas(
            PilaQuejas pilaQuejas) {

        this.pilaQuejas = pilaQuejas;
    }
}