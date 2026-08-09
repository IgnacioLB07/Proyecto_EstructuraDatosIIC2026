package Menu;

import Servicio.GestorBI;
import Servicio.GestorExpedientes;
import javax.swing.JOptionPane;

/**
 * Menú del módulo de Inteligencia Empresarial.
 *
 * @author nelson
 */
public class MenuBI {

    private GestorBI gestorBI;

    /**
     * Constructor.
     *
     * @param gestorE gestor de expedientes
     */
    public MenuBI(GestorExpedientes gestorE) {

        gestorBI = new GestorBI(
                gestorE.getArbolE());
    }

    /**
     * Muestra el menú de BI.
     */
    public void mostrarMenu() {

        int opcion;

        do {

            try {

                String entrada =
                        JOptionPane.showInputDialog(
                                "=================================\n"
                                + "INTELIGENCIA EMPRESARIAL - BI\n"
                                + "=================================\n\n"
                                + "1. Enfermedades más frecuentes\n"
                                + "2. Segmentación de pacientes\n"
                                + "3. Detección de patrones\n"
                                + "4. Propuesta de Valor\n"
                                + "5. Regresar\n\n"
                                + "Seleccione una opción:");

                if (entrada == null) {
                    opcion = 5;
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
                    JOptionPane.showMessageDialog(
                            null,
                            gestorBI.analizarEnfermedades());
                    break;

                case 2:
                    JOptionPane.showMessageDialog(
                            null,
                            gestorBI.segmentarPacientes());
                    break;

                case 3:
                    detectarPatrones();
                    break;

                case 4:
                    JOptionPane.showMessageDialog(
                            null,
                            gestorBI.generarPropuestaValor());
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
     * Solicita los parámetros de la consulta avanzada.
     */
    private void detectarPatrones() {

        String edadInicialTexto =
                JOptionPane.showInputDialog(
                        "Ingrese la edad inicial.\n"
                        + "Déjela vacía si no desea "
                        + "usar rango de edad:");

        if (edadInicialTexto == null) {
            return;
        }

        String edadFinalTexto =
                JOptionPane.showInputDialog(
                        "Ingrese la edad final.\n"
                        + "Déjela vacía si no desea "
                        + "usar rango de edad:");

        if (edadFinalTexto == null) {
            return;
        }

        edadInicialTexto =
                edadInicialTexto.trim();

        edadFinalTexto =
                edadFinalTexto.trim();

        int edadInicial = -1;
        int edadFinal = -1;

        boolean algunaEdadIngresada =
                !edadInicialTexto.isEmpty()
                || !edadFinalTexto.isEmpty();

        if (algunaEdadIngresada) {

            if (edadInicialTexto.isEmpty()
                    || edadFinalTexto.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Para utilizar el rango de edad "
                        + "debe ingresar ambas edades.");

                return;
            }

            try {

                edadInicial = Integer.parseInt(
                        edadInicialTexto);

                edadFinal = Integer.parseInt(
                        edadFinalTexto);

                if (edadInicial < 0
                        || edadFinal < 0) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Las edades no pueden ser negativas.");

                    return;
                }

                if (edadInicial > edadFinal) {

                    JOptionPane.showMessageDialog(
                            null,
                            "La edad inicial no puede ser "
                            + "mayor que la edad final.");

                    return;
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Las edades deben ser números enteros.");

                return;
            }
        }

        String diagnostico =
                JOptionPane.showInputDialog(
                        "Ingrese el diagnóstico.\n"
                        + "Déjelo vacío si no desea "
                        + "utilizarlo:");

        if (diagnostico == null) {
            return;
        }

        String genero =
                JOptionPane.showInputDialog(
                        "Ingrese el género.\n"
                        + "Ejemplo: MASCULINO o FEMENINO.\n"
                        + "Déjelo vacío si no desea "
                        + "utilizarlo:");

        if (genero == null) {
            return;
        }

        String medicamento =
                JOptionPane.showInputDialog(
                        "Ingrese el medicamento.\n"
                        + "Déjelo vacío si no desea "
                        + "utilizarlo:");

        if (medicamento == null) {
            return;
        }

        diagnostico = diagnostico.trim();
        genero = genero.trim();
        medicamento = medicamento.trim();

        boolean sinParametros =
                edadInicial == -1
                && diagnostico.isEmpty()
                && genero.isEmpty()
                && medicamento.isEmpty();

        if (sinParametros) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar al menos un parámetro.");

            return;
        }

        String reporte = gestorBI.detectarPatrones(
                edadInicial,
                edadFinal,
                diagnostico,
                genero,
                medicamento);

        JOptionPane.showMessageDialog(
                null,
                reporte);
    }
}