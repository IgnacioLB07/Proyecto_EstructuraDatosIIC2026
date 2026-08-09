package Estructura;

import Estructura.ArbolExpedientes;
import Modelo.Cita;
import Modelo.ExpedientePaciente;
import Modelo.Medicamento;
import java.util.Date;

public class MainTest {

    public static void main(String[] args) {

        // Crear el árbol
        ArbolExpedientes arbol = new ArbolExpedientes();

        // Crear expedientes
        ExpedientePaciente paciente1 = new ExpedientePaciente(
                "205010101",
                "Carlos Pérez",
                25,
                "Masculino"
        );

        ExpedientePaciente paciente2 = new ExpedientePaciente(
                "103020202",
                "Ana Rodríguez",
                17,
                "Femenino"
        );

        ExpedientePaciente paciente3 = new ExpedientePaciente(
                "402030303",
                "Luis González",
                70,
                "Masculino"
        );

        ExpedientePaciente paciente4 = new ExpedientePaciente(
                "301040404",
                "María López",
                45,
                "Femenino"
        );

        // Agregar una cita al primer paciente
        paciente1.agregarCita(
                new Cita(
                        new Date(),
                        "Dr. Pérez",
                        "Gripe"
                )
        );

        // Agregar un medicamento al primer paciente
        paciente1.agregarMedicamento(
                new Medicamento(
                        new Date(),
                        "Paracetamol"
                )
        );

        // Agregar una cita al segundo paciente
        paciente2.agregarCita(
                new Cita(
                        new Date(),
                        "Dra. Rodríguez",
                        "Asma"
                )
        );

        // Agregar un medicamento al segundo paciente
        paciente2.agregarMedicamento(
                new Medicamento(
                        new Date(),
                        "Salbutamol"
                )
        );

        // Insertar los expedientes en el árbol
        arbol.insertar(paciente1);
        System.out.println("\n========== EXPEDIENTE DEL PACIENTE ==========");
        System.out.println(paciente1.mostrarExpediente());
        
        arbol.insertar(paciente2);
        System.out.println("\n========== EXPEDIENTE DEL PACIENTE ==========");
        System.out.println(paciente2.mostrarExpediente());
        
        arbol.insertar(paciente3);
        System.out.println("\n========== EXPEDIENTE DEL PACIENTE ==========");
        System.out.println(paciente3.mostrarExpediente());
        
        arbol.insertar(paciente4);
        System.out.println("\n========== EXPEDIENTE DEL PACIENTE ==========");
        System.out.println(paciente4.mostrarExpediente());

        // Mostrar recorrido
        System.out.println("===== RECORRIDO DEL ABB =====");
        arbol.inOrden();
        
        
        System.out.println("\n========== BUSCAR EXPEDIENTE ================");
        ExpedientePaciente encontrado = arbol.buscarExpediente("205010101");
        
        if (encontrado != null) {
            System.out.println("EXPEDIENTE ENCONTRADO: ");
            System.out.println(encontrado.mostrarExpediente());
        } else {
            System.out.println("NO SE ENCONTRO EL EXPEDIENTE");
        }
        
        System.out.println("\n========== BUSCAR EXPEDIENTE ================");
        ExpedientePaciente noEncontrado = arbol.buscarExpediente("9999999");
        
        if (noEncontrado != null) {
            System.out.println(noEncontrado.mostrarExpediente());
        } else {
            System.out.println("NO EXISTE UN EXPEDIENTE CON ESA CEDULA");
        }
        
        
    }
}