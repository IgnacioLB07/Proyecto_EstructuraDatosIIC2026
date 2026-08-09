package Servicio;

import Estructura.ArbolExpedientes;

/**
 * Gestiona los expedientes, citas, medicamentos, módulos BI, JSON y ABB
 * 
 * @author ignap
 */
public class GestorExpedientes {
    //Atributos
    private ArbolExpedientes arbolE;

    /**
     * Constructor cargado
     * @param arbolE 
     */
    public GestorExpedientes(ArbolExpedientes arbolE) {
        this.arbolE = new ArbolExpedientes();
    }

    /**
     * Devuelve el arbolExpediente
     * @return arbolE con informacion del Expediente en ABB
     */
    public ArbolExpedientes getArbolE() {
        return arbolE;
    }

    /**
     * Guarda el arbolExpediente
     * @param arbolE informacion del expediente en ABB
     */
    public void setArbolE(ArbolExpedientes arbolE) {
        this.arbolE = arbolE;
    }
    
    
    
}
