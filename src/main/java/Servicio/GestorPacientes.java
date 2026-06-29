/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Estructura.ColaPacientes;
import Modelo.Paciente;
import java.util.Date;

/**
 * Gestiona los/as pacientes del sistema hospitalario
 * @author ignap
 */
public class GestorPacientes {
    
    //Atributos
    private ColaPacientes colaRegular;
    private ColaPacientes colaPreferencial;
    private GeneradorFicha generadorFicha;
    
    
    //Constructores
    public GestorPacientes() {
        colaRegular = new ColaPacientes();
        colaPreferencial = new ColaPacientes();
        generadorFicha = new GeneradorFicha();
    }

    public GestorPacientes(ColaPacientes colaRegular, 
            ColaPacientes colaPreferencial, GeneradorFicha generadorFicha) {
        this.colaRegular = colaRegular;
        this.colaPreferencial = colaPreferencial;
        this.generadorFicha = generadorFicha;
    }

    

    //Getters

    public ColaPacientes getColaRegular() {
        return colaRegular;
    }

    public ColaPacientes getColaPreferencial() {
        return colaPreferencial;
    }
    
    
    //Metodos
    /**
     *
     * @return 
     */
    public Paciente seleccionarFicha(String cedula, String nombre, String tipoPaciente) {
        
        String ficha;
        ColaPacientes cola;
        
        if (tipoPaciente.equals("Preferencial")) {
            ficha = generadorFicha.generarPreferencial();
            cola = colaPreferencial;
            
        } else {
            ficha = generadorFicha.generarRegular();
            cola = colaRegular;

        }
            Paciente nuevo = new Paciente(ficha, cedula, nombre,
                    new Date(), tipoPaciente);
            
            cola.encolarPaciente(nuevo);
            
            return nuevo;
        
    }
    
    public Paciente atenderPaciente(){
       return null; //Cambiar por código
    }
    
    public Paciente abandonarCola() {
        return null; //Cambiar por código
    }
    
    public String mostrarPacientes() {
        return ""; //Cambiar por código
    }
}
