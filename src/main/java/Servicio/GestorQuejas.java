package Servicio;

import Estructura.PilaQuejas;
import Modelo.Paciente;
import Modelo.Queja;
import java.util.Date;

/**
 * Gestiona las quejas del sistema hospitalario
 * @author johan
 */
public class GestorQuejas {

    //Atributos
    private PilaQuejas pilaQuejas;

    // Constructores
    /**
     * Crea una pila de Quejas con los valores ingresados
     */
    public GestorQuejas() {
        pilaQuejas = new PilaQuejas();
    }

    //Métodos
    /**
     * Registra una queja existente en la pila de quejas.
     *
     * @param queja Queja que se desea almacenar.
     */
    public void registrarQueja(Queja queja) {
        pilaQuejas.apilarQueja(queja);
    }

    /**
     * Crea y registra una nueva queja a partir de un paciente que abandonó la
     * cola de espera.
     *
     * @param paciente Paciente que abandona la cola.
     * @param motivo Motivo indicado por el paciente.
     */
    public void registrarQueja(Paciente paciente, String motivo) {
        Queja nueva = new Queja(
                paciente.getFicha(),
                paciente.getCedula(),
                motivo,
                new Date());

        pilaQuejas.apilarQueja(nueva);
    }

    /**
     * Retorna todas las quejas registradas en formato de texto.
     *
     * @return Información de las quejas almacenadas.
     */
    public String mostrarQuejas() {
        String msg = "========== PILA QUEJAS ==========\n"
                    +pilaQuejas.mostrarQuejas();
                
        return msg;
    }

    /**
     * Obtiene y elimina la última queja registrada.
     *
     * @return La última queja almacenada o {@code null} si la pila está vacía.
     */
    public Queja obtenerUltimaQueja() {
        return pilaQuejas.desapilarQueja();
    }

    /**
     * Verificar si la pila está vacía
     * @return true/false
     */ 
    public boolean hayQuejas() {
        return !pilaQuejas.esVacia();
    }

    /**
     * Obtiene las pila de quejas
     * @return pilaQuejas
     */
    public PilaQuejas getPilaQuejas() {
        return pilaQuejas;
    }

}
