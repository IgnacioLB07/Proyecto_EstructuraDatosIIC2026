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

/**
 * Muestra el menú de principal del sistema
 * @author ignap
 */
public class MenuPrincipal {

    /**
     * Muestra el menú con JOptionPane
     * y permite elegir la función con do while y switch
     */
    public void mostrarMenuPrincipal() {
        
        MenuPacientes menuP = new MenuPacientes();

        int opcion;

        do {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "=================================\n"
                    + "BIENVENIDO A HOSPITAL 'SU SALUD'\n"
                    + "=================================\n\n"
                    + "1. Gestionar Llegada de Pacientes\n"
                    + "2. Ayuda\n"
                    + "3. Salir\n\n"
                    + "Seleccione una opción:"
            ));

            switch (opcion) {

                case 1:
                    JOptionPane.showMessageDialog(null,
                            "Opción: Gestionar Llegada de Pacientes");
                    menuP.mostrarMenu();
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Opción: Ayuda");
                    mostrarAyuda();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Opción: Salir");
                    JOptionPane.showMessageDialog(null, 
                            "GRACIAS POR SU VISITA");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción inválida.");
            }

        } while (opcion != 3);
    }
    
    /**
     * Muestra un submenu de Ayuda con la versión del sistema y los colaboradores
     */
    public void mostrarAyuda() {
        JOptionPane.showMessageDialog(null,
                "=================================\n"
              + "    VERSIÓN DE LA HERRAMIENTA\n"
              + "=================================\n\n"
              + "Avance 1 V 1.0.N (N numero de avances internos)\n"
              + "Colaboradores: \n"
              + "Ignacio R. Leitón Benavides \n"
              + "Johan Rodriguez Chaves \n"
              + "NOMBRE Y APELLIDO \n"
        );
    }
}
