/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

/**
 *
 * @author ignap
 */
import Modelo.Paciente;
import Servicio.GestorPacientes;
import javax.swing.JOptionPane;

/**
 * Muestra el menú de gestión de pacientes
 *
 * @author ignap
 */
public class MenuPacientes {

    //Atributos
    private GestorPacientes gestorP;

    //Constructores
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
                    JOptionPane.showMessageDialog(null,
                            "Aquí se ejecutará la opción Seleccionar Ficha.");
                    seleccionarFicha();
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Aquí se ejecutará la opción Atender Paciente.");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Aquí se ejecutará la opción Abandonar Cola de Pacientes.");
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Aquí se ejecutará la opción Mostrar Fichas Pendientes.");
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Aquí se ejecutará la opción Mostrar Quejas Recibidas.");
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
                + "\n\nSu número de ficha es la: "+ paciente.getFicha() + "\n"
                + "Registro Exitoso");
    }
}
