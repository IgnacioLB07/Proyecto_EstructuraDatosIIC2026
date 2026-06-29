package Menu;

import Modelo.Paciente;
import Servicio.GestorPacientes;
import javax.swing.JOptionPane;

/**
 * Muestra el menú de gestión de pacientes
 * @author nelson
 */
public class MenuPacientes {

    //Atributos
    private GestorPacientes gestorP;

    //Constructores
    /**
     * Crea un menu pacientes con los valores ingresados
     */
    public MenuPacientes() {
        gestorP = new GestorPacientes();
    }

    /**
     * Muestra el menú con JOptionPane y permite elegir la función con do while
     * y switch
     */
    public void mostrarMenu() {
        int opcion;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "====================================\n"
                    + "GESTIONAR LLEGADA DE PACIENTES\n"
                    + "====================================\n\n"
                    + "1. Seleccionar Ficha\n"
                    + "2. Atender Paciente\n"
                    + "3. Abandonar Cola de Pacientes\n"
                    + "4. Mostrar Fichas Pendientes\n"
                    + "5. Mostrar Quejas Recibidas\n"
                    + "6. Regresar\n\n"
                    + "Seleccione una opción:"
            ));

            switch (opcion) {

                case 1:
                    seleccionarFicha();
                    break;

                case 2:
                    atenderPaciente();
                    break;

                case 3:
                    abandonarCola();
                    break;

                case 4:
                    mostrarPacientesPendientes();
                    break;

                case 5:
                    mostrarQuejas();
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null,
                            "Regresando al menú principal...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción inválida.");
            }

        } while (opcion != 6);
    }

    /**
     * Solicita la información necesaria para registrar un paciente, genera su
     * ficha mediante el GestorPacientes y muestra el número de ficha asignado.
     */
    private void seleccionarFicha() {

        String opcion = JOptionPane.showInputDialog(null,
                "Seleccione el tipo de paciente:\n\n"
                + "1. Regular\n"
                + "2. Preferencial");

        if (opcion == null) {
            return;
        }

        String tipoPaciente;

        switch (opcion) {

            case "1":
                tipoPaciente = "Regular";
                break;

            case "2":
                tipoPaciente = "Preferencial";
                break;

            default:
                JOptionPane.showMessageDialog(null,
                        "Opción inválida");
                return;
        }

        String nombre = JOptionPane.showInputDialog(null,
                "Ingrese el nombre del paciente: ");

        if (nombre == null) {
            return;
        }

        String cedula = JOptionPane.showInputDialog(null,
                "Ingrese la cédula del paciente: ");

        if (cedula == null) {
            return;
        }

        Paciente paciente = gestorP.seleccionarFicha(cedula, nombre, tipoPaciente);

        JOptionPane.showMessageDialog(null,
                "Paciente registrado correctamente"
                + "\n\nSu número de ficha es la: " + paciente.getFicha() + "\n"
                + "Registro Exitoso");
    }

    /**
     * Método para mostrar la lista de pacientes atendidos
     */
    private void atenderPaciente() {
        Paciente paciente = gestorP.atenderPaciente();

        if (paciente == null) {
            JOptionPane.showMessageDialog(null,
                    "No hay pacientes en espera");
            return;
        }

        JOptionPane.showMessageDialog(null,
                "Paciente atendido correctamente \n"
                + "\n Ficha #" + paciente.getFicha()
                + "\n Con Cédula: " + paciente.getCedula()
                + "\n Con Nombre: " + paciente.getNombre()
                + "\n Pasar a Consulta");
    }

    /**
     * Solicita la ficha y el motivo del paciente que desea abandonar la cola de
     * espera. Si la ficha existe, elimina al paciente de la cola y registra la
     * queja correspondiente.
     */
    private void abandonarCola() {
        String ficha = JOptionPane.showInputDialog("Ingrese el número de ficha: ");
        
        if (ficha == null) {
            return;
        }
        
        ficha = ficha.trim();
        
        if (ficha.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un número de ficha valido");
            return;
        }
        
        String motivo = JOptionPane.showInputDialog("Ingrese el motivo de la salida: ");
        
        if (motivo == null) {
            return;
        }
        
        motivo = motivo.trim();
        
        if (motivo.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un motivo");
            return;
        }
        
        Paciente paciente = gestorP.abandonarCola(ficha, motivo);
        
        if (paciente == null) {
            JOptionPane.showMessageDialog(null,
                    "No existe un paciente con la ficha "+ ficha);
            
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ficha #" + paciente.getFicha()
                   +"\n Con cédula: "+ paciente.getCedula()
                   +"\n Abandona la cola sin ser atendido(a)");
        }
    }
    
    /**
     * Método para mostrar los pacientes pendientes por atender
     */
    private void mostrarPacientesPendientes() {
        JOptionPane.showMessageDialog(null, gestorP.mostrarPacientes());
    }
    
    private void mostrarQuejas() {
        JOptionPane.showMessageDialog(null, gestorP.getGestorQ().mostrarQuejas());
    }
    
}
