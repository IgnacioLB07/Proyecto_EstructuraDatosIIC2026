package Menu;

import javax.swing.JOptionPane;

/**
 * Muestra el menú principal del sistema.
 *
 * @author nelson
 */
public class MenuPrincipal {

    private MenuPacientes menuP;

    public MenuPrincipal() {
        menuP = new MenuPacientes();
    }

    /**
     * Muestra el menú principal.
     */
    public void mostrarMenuPrincipal() {

        int opcion;

        do {

            try {

                String entrada = JOptionPane.showInputDialog(
                        "=================================\n"
                        + "BIENVENIDO A HOSPITAL 'SU SALUD'\n"
                        + "=================================\n\n"
                        + "1. Gestionar Llegada de Pacientes\n"
                        + "2. Ayuda\n"
                        + "3. Salir\n\n"
                        + "Seleccione una opción:"
                );

                if (entrada == null) {
                    opcion = 3;
                } else {
                    opcion = Integer.parseInt(entrada.trim());
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Debe ingresar una opción válida.");

                opcion = 0;
            }

            switch (opcion) {

                case 1:
                    menuP.mostrarMenu();
                    break;

                case 2:
                    mostrarAyuda();
                    break;

                case 3:
                    JOptionPane.showMessageDialog(
                            null,
                            "GRACIAS POR UTILIZAR EL SISTEMA");
                    break;

                default:

                    if (opcion != 0) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Opción inválida.");
                    }

                    break;
            }

        } while (opcion != 3);

    }

    /**
     * Muestra la ayuda del sistema.
     */
    public void mostrarAyuda() {

        JOptionPane.showMessageDialog(
                null,
                "=================================\n"
                + "VERSIÓN DE LA HERRAMIENTA\n"
                + "=================================\n\n"
                + "Hospital 'Su Salud'\n"
                + "Avance 2 - Versión 2.0\n\n"
                + "COLABORADORES:\n"
                + "Ignacio R. Leitón Benavides\n"
                + "Johan Rodríguez Chaves\n"
                + "Nelson Latino Valverde\n\n"
                + "FUNCIONES:\n"
                + "- Gestión de pacientes\n"
                + "- Expedientes médicos\n"
                + "- Historial de citas\n"
                + "- Historial de medicamentos\n"
                + "- Bitácora de pacientes atendidos");
    }
}