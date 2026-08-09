package Menu;

import Servicio.GestorExpedientes;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Menú para gestionar los expedientes almacenados
 * en el Árbol Binario de Búsqueda.
 *
 * @author nelson
 */
public class MenuExpedientes {

    private GestorExpedientes gestorE;
    private MenuBI menuBI;

    /**
     * Constructor.
     */
    public MenuExpedientes() {

        gestorE = new GestorExpedientes();

        menuBI = new MenuBI(gestorE);
    }

    /**
     * Muestra el menú de expedientes.
     */
    public void mostrarMenu() {

        int opcion;

        do {

            try {

                String entrada
                        = JOptionPane.showInputDialog(
                                "=================================\n"
                                + "EXPEDIENTE ÚNICO DE PACIENTES\n"
                                + "=================================\n\n"
                                + "1. Cargar Expedientes desde Archivo\n"
                                + "2. Buscar Expediente\n"
                                + "3. Mostrar Expedientes\n"
                                + "4. Cantidad de Expedientes\n"
                                + "5. Inteligencia Empresarial - BI\n"
                                + "6. Regresar\n\n"
                                + "Seleccione una opción:");

                if (entrada == null) {

                    opcion = 6;

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
                    menuBI.mostrarMenu();
                    break;

                case 6:
                    JOptionPane.showMessageDialog(
                            null,
                            "Regresando al menú principal...");
                    break;

                default:

                    if (opcion != 0) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Opción inválida.");
                    }

                    break;
            }

        } while (opcion != 6);
    }

    /**
     * Permite seleccionar y cargar un archivo JSON.
     */
    private void cargarArchivo() {

        JFileChooser selector
                = new JFileChooser();

        FileNameExtensionFilter filtro
                = new FileNameExtensionFilter(
                        "Archivos JSON",
                        "json");

        selector.setFileFilter(filtro);

        selector.setDialogTitle(
                "Seleccione el archivo JSON");

        int resultado
                = selector.showOpenDialog(null);

        if (resultado
                != JFileChooser.APPROVE_OPTION) {

            return;
        }

        File archivo
                = selector.getSelectedFile();

        try {

            int cargados
                    = gestorE
                            .cargarExpedientesDesdeArchivo(
                                    archivo);

            JOptionPane.showMessageDialog(
                    null,
                    "Archivo procesado correctamente.\n\n"
                    + "Expedientes cargados: "
                    + cargados
                    + "\nTotal de expedientes: "
                    + gestorE.contarExpedientes());

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "No fue posible leer el archivo.\n"
                    + "Detalle: "
                    + e.getMessage());
        }
    }

    /**
     * Busca un expediente por cédula.
     */
    private void buscarExpediente() {

        String cedula
                = JOptionPane.showInputDialog(
                        "Ingrese la cédula del paciente:");

        if (cedula == null) {

            return;
        }

        cedula = cedula.trim();

        if (cedula.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar una cédula.");

            return;
        }

        JOptionPane.showMessageDialog(
                null,
                gestorE.mostrarExpediente(
                        cedula));
    }

    /**
     * Muestra los expedientes registrados mediante
     * paginación de un expediente por ventana.
     */
    private void mostrarExpedientes() {

        int total
                = gestorE.contarExpedientes();

        if (total == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "No existen expedientes registrados.");

            return;
        }

        int inicio = 0;

        while (inicio < total) {

            JOptionPane.showMessageDialog(
                    null,
                    "====================================\n"
                    + "EXPEDIENTE MÉDICO - ABB\n"
                    + "====================================\n\n"
                    + "Mostrando expediente "
                    + (inicio + 1)
                    + " de "
                    + total
                    + "\n\n"
                    + gestorE.mostrarExpedientes(
                            inicio,
                            1));

            inicio++;
        }
    }

    /**
     * Muestra la cantidad de expedientes.
     */
    private void mostrarCantidad() {

        JOptionPane.showMessageDialog(
                null,
                "Cantidad de expedientes en el ABB: "
                + gestorE.contarExpedientes());
    }

    /**
     * Devuelve el gestor de expedientes.
     *
     * @return gestor de expedientes
     */
    public GestorExpedientes getGestorE() {

        return gestorE;
    }

    /**
     * Modifica el gestor de expedientes.
     *
     * @param gestorE nuevo gestor
     */
    public void setGestorE(
            GestorExpedientes gestorE) {

        if (gestorE != null) {

            this.gestorE = gestorE;

            menuBI = new MenuBI(
                    this.gestorE);
        }
    }
}