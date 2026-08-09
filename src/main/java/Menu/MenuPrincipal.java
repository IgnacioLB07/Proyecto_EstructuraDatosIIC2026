package Menu;

import javax.swing.JOptionPane;

/**
 * Muestra el menú principal del sistema.
 *
 * @author nelson
 */
public class MenuPrincipal {

    private MenuPacientes menuP;
    private MenuExpedientes menuE;

    /**
     * Constructor.
     */
    public MenuPrincipal() {

        menuP = new MenuPacientes();
        menuE = new MenuExpedientes();
    }

    /**
     * Muestra el menú principal.
     */
    public void mostrarMenuPrincipal() {

        int opcion;

        do {

            try {

                String entrada =
                        JOptionPane.showInputDialog(
                                "=================================\n"
                                + "BIENVENIDO A HOSPITAL 'SU SALUD'\n"
                                + "=================================\n\n"
                                + "1. Gestionar Llegada de Pacientes\n"
                                + "2. Gestionar Expedientes ABB\n"
                                + "3. Ayuda\n"
                                + "4. Salir\n\n"
                                + "Seleccione una opción:");

                if (entrada == null) {

                    opcion = 4;

                } else {

                    opcion = Integer.parseInt(
                            entrada.trim());
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

                    menuE.mostrarMenu();
                    break;

                case 3:

                    mostrarAyuda();
                    break;

                case 4:

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

        } while (opcion != 4);
    }

    /**
     * Muestra la ayuda, versión, integrantes
     * y funciones principales del sistema.
     */
    public void mostrarAyuda() {

        JOptionPane.showMessageDialog(
                null,
                "=================================\n"
                + "VERSIÓN DE LA HERRAMIENTA\n"
                + "=================================\n\n"
                + "Hospital 'Su Salud'\n"
                + "Avance 3 - Versión 3.0\n\n"
                + "COLABORADORES:\n"
                + "Ignacio R. Leitón Benavides\n"
                + "Johan Rodríguez Chaves\n"
                + "Nelson Latino Valverde\n\n"
                + "FUNCIONES DEL SISTEMA:\n"
                + "- Gestión de llegada de pacientes\n"
                + "- Atención de pacientes preferenciales y regulares\n"
                + "- Registro y consulta de quejas\n"
                + "- Bitácora de pacientes atendidos\n"
                + "- Expediente único de pacientes mediante ABB\n"
                + "- Carga de expedientes desde archivo JSON\n"
                + "- Historial de citas médicas\n"
                + "- Historial de medicamentos prescritos\n"
                + "- Análisis de enfermedades más frecuentes\n"
                + "- Segmentación de pacientes por edad\n"
                + "- Detección de patrones mediante filtros\n"
                + "- Propuesta de valor para pacientes prioritarios\n\n"
                + "ESTRUCTURAS UTILIZADAS:\n"
                + "- Colas dinámicas\n"
                + "- Pilas dinámicas\n"
                + "- Listas enlazadas simples\n"
                + "- Listas circulares\n"
                + "- Listas dobles circulares\n"
                + "- Árbol Binario de Búsqueda");
    }
}