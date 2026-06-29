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
    private int contadorPreferenciales = 0;
    
    public Paciente atenderPaciente (ColaPacientes colaPreferencial, ColaPacientes colaRegular){
       Paciente paciente = null;

    try {

        // Si existen pacientes en ambas colas
        if (!colaPreferencial.esVacia() && !colaRegular.esVacia()) {

            if (contadorPreferenciales < 2) {

                paciente = colaPreferencial.desencolarPaciente();
                contadorPreferenciales++;

            } else {

                paciente = colaRegular.desencolarPaciente();
                contadorPreferenciales = 0;

            }

        }
        // Solo quedan preferenciales
        else if (!colaPreferencial.esVacia()) {

            paciente = colaPreferencial.desencolarPaciente();

        }
        // Solo quedan regulares
        else if (!colaRegular.esVacia()) {

            paciente = colaRegular.desencolarPaciente();

        }
        // No hay pacientes
        else {

            System.out.println("No hay pacientes en espera.");
          
        }

        System.out.println("Ficha # " + paciente.getFicha()
                + " con cédula "
                + paciente.getCedula()
                + " pasar a consulta médica.");

    } catch (Exception e) {

        System.out.println(e.getMessage());

    }
    }
    
    public Paciente abandonarCola(ColaPacientes colaPreferencial,
                          ColaPacientes colaRegular,
                          PilaQuejas pilaQuejas,
                          String ficha,
                          String motivo) {
       Paciente paciente = null;

    // Buscar primero en la cola preferencial
    paciente = colaPreferencial.eliminarPorFicha(ficha);

    // Si no está, buscar en la cola regular
    if (paciente == null) {
        paciente = colaRegular.eliminarPorFicha(ficha);
    }

    if (paciente != null) {

        System.out.println("Ficha # "
                + paciente.getFicha()
                + " con cédula "
                + paciente.getCedula()
                + " abandona la cola sin ser atendido(a).");

        // Crear la queja
        Queja queja = new Queja(motivo, new Date());

        // Guardarla en la pila
        pilaQuejas.apilar(queja);

    } else {

        System.out.println("No existe un paciente con esa ficha.");

    }
    }
    
    public String mostrarPacientes() {
        return ""; //Cambiar por código
    }
}
