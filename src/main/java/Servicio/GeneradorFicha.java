/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 * Gestiona las fichas del sistema hospitalario
 * @author ignap
 */
public class GeneradorFicha {
    
    //Atributos
    private int contadorRegular;
    private int contadorPreferencial;

    //Constructores
    /**
     * 
     * @param contadorRegular
     * @param contadorPreferencial 
     */
    public GeneradorFicha(int contadorRegular, int contadorPreferencial) {
        this.contadorRegular = 0;
        this.contadorPreferencial = 0;
    }  

    public GeneradorFicha() {}
    
    //Metodos
    /**
     * Generar una ficha consecutiva para un paciente regular
     * Cada vez que se invoca, incrementa el contador
     * retornando una cadena con P + contador
     * @return Numero de ficha para un paciente Regular
     */
    public String generarRegular() {
        contadorRegular += 1;
        
        return "R" + contadorRegular;
    }
    
    /**
     * Generar una ficha consecutiva para un paciente preferencial
     * Cada vez que se invoca, incrementa el contador
     * retornando una cadena con P + contador
     * @return Numero de ficha para un paciente Preferencial
     */
    public String generarPreferencial(){
        contadorPreferencial += 1;
        
        return "P" + contadorPreferencial;
    }
}
