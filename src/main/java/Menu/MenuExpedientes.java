package Menu;

import Servicio.GestorExpedientes;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Menu para gestionar los expedientes del ABB.
 *
 * @author nelson
 */
public class MenuExpedientes {

    private GestorExpedientes gestorE;

    /**
     * Constructor.
     */
    public MenuExpedientes() {

        gestorE = new GestorExpedientes();
    }

    /**
     * Muestra el menu de expedientes.
     */
    public void mostrarMenu() {

        int opcion;

        do {

            try {

                String entrada =
                        JOptionPane.showInputDialog(
                                "=================================\n"
                                + "EXPEDIENTE ÚNICO DE PACIENTES\n"
                                + "=================================\n\n"
                                + "1. Cargar Expediente desde Archivo\n"
                                + "2. Buscar Expediente\n"
                                + "3. Mostrar Expedientes\n"
                                + "4. Cantidad de Expedientes\n"
                                + "5. Regresar\n\n"
                                + "Seleccione una opción:");

                if (entrada == null) {

                    opcion = 5;

                } else {

                    opcion =
                            Integer.parseInt(
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
                    cargarArchivo();
                    break;

                case 2:
                    buscarExpediente();
                    break;

                case 3:
                    mostrarExpedientes();
                    break;

                case 4:
                    mostrarCantidad();
                    break;

                case 5:
                    break;

                default:

                    if (opcion != 0) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Opción inválida.");
                    }

                    break;
            }

        } while (opcion != 5);
    }

    /**
     * Selecciona y carga el archivo JSON.
     */
    private void cargarArchivo() {

        JFileChooser selector =
                new JFileChooser();

        FileNameExtensionFilter filtro =
                new FileNameExtensionFilter(
                        "Archivos JSON",
                        "json");

        selector.setFileFilter(filtro);

        selector.setDialogTitle(
                "Seleccione el archivo JSON");

        int resultado =
                selector.showOpenDialog(null);

        if (resultado
                != JFileChooser.APPROVE_OPTION) {

            return;
        }

        File archivo =
                selector.getSelectedFile();

        try {

            int cargados =
                    gestorE
                            .cargarExpedientesDesdeArchivo(
                                    archivo);

            JOptionPane.showMessageDialog(
                    null,
                    "Archivo procesado.\n\n"
                    + "Expedientes cargados: "
                    + cargados
                    + "\n"
                    + "Total de expedientes: "
                    + gestorE.contarExpedientes());

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al leer el archivo.\n"
                    + e.getMessage());
        }
    }

    /**
     * Busca un expediente por cedula.
     */
    private void buscarExpediente() {

        String cedula =
                JOptionPane.showInputDialog(
                        "Ingrese la cédula:");

        if (cedula == null) {
            return;
        }

        if (cedula.trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar una cédula.");

            return;
        }

        JOptionPane.showMessageDialog(
                null,
                gestorE.mostrarExpediente(
                        cedula.trim()));
    }

    /**
     * Muestra todos los expedientes.
     */
    private void mostrarExpedientes() {

        JOptionPane.showMessageDialog(
                null,
                gestorE.mostrarExpedientes());
    }

    /**
     * Muestra la cantidad de expedientes.
     */
    private void mostrarCantidad() {

        JOptionPane.showMessageDialog(
                null,
                "Cantidad de expedientes: "
                + gestorE.contarExpedientes());
    }

    /**
     * Devuelve el gestor.
     *
     * @return gestor de expedientes
     */
    public GestorExpedientes getGestorE() {

        return gestorE;
    }
}