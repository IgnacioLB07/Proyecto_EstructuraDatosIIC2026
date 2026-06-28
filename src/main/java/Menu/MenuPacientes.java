/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

/**
 *
 * @author ignap
 */
import javax.swing.JOptionPane;

public class MenuPacientes {

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
}