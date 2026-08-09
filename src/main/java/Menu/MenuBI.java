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

                String entrada
                        = JOptionPane.showInputDialog(
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
                    mostrarEnfermedades();
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
                    mostrarPropuestaValor();
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
     * Muestra las enfermedades más frecuentes
     * mediante paginación de cinco diagnósticos
     * por ventana.
     */
    private void mostrarEnfermedades() {

        int total
                = gestorBI.contarDiagnosticos();

        if (total == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "No existen diagnósticos registrados.");

            return;
        }

        int inicio = 0;
        int cantidadPorPagina = 5;

        while (inicio < total) {

            int fin = Math.min(
                    inicio + cantidadPorPagina,
                    total);

            JOptionPane.showMessageDialog(
                    null,
                    "=================================\n"
                    + "ENFERMEDADES MÁS FRECUENTES\n"
                    + "=================================\n\n"
                    + gestorBI.analizarEnfermedades(
                            inicio,
                            cantidadPorPagina)
                    + "\nMostrando diagnósticos "
                    + (inicio + 1)
                    + " - "
                    + fin
                    + " de "
                    + total);

            inicio += cantidadPorPagina;
        }
    }

    /**
     * Muestra la propuesta de valor mediante
     * paginación de un paciente prioritario
     * por ventana.
     */
    private void mostrarPropuestaValor() {

        int total
                = gestorBI.contarPacientesPrioritarios();

        if (total == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "=================================\n"
                    + "PROPUESTA DE VALOR\n"
                    + "=================================\n\n"
                    + "No se identificaron pacientes "
                    + "de atención prioritaria.");

            return;
        }

        int inicio = 0;
        int cantidadPorPagina = 1;

        JOptionPane.showMessageDialog(
                null,
                "=================================\n"
                + "PROPUESTA DE VALOR\n"
                + "PACIENTES DE ATENCIÓN PRIORITARIA\n"
                + "=================================\n\n"
                + "Esta consulta identifica pacientes "
                + "que podrían requerir seguimiento médico "
                + "especial o mayor planificación de recursos.\n\n"
                + "Criterios utilizados:\n"
                + "- Tener 65 años o más.\n"
                + "- Tener 3 o más citas registradas.\n"
                + "- Tener 3 o más medicamentos prescritos.\n\n"
                + "Pacientes identificados: "
                + total);

        while (inicio < total) {

            JOptionPane.showMessageDialog(
                    null,
                    "=================================\n"
                    + "PACIENTE DE ATENCIÓN PRIORITARIA\n"
                    + "=================================\n\n"
                    + "Mostrando paciente "
                    + (inicio + 1)
                    + " de "
                    + total
                    + "\n\n"
                    + gestorBI.generarPropuestaValor(
                            inicio,
                            cantidadPorPagina));

            inicio += cantidadPorPagina;
        }
    }

    /**
     * Solicita los parámetros de la consulta avanzada.
     */
    private void detectarPatrones() {

        String edadInicialTexto
                = JOptionPane.showInputDialog(
                        "Ingrese la edad inicial.\n"
                        + "Déjela vacía si no desea "
                        + "usar rango de edad:");

        if (edadInicialTexto == null) {
            return;
        }

        String edadFinalTexto
                = JOptionPane.showInputDialog(
                        "Ingrese la edad final.\n"
                        + "Déjela vacía si no desea "
                        + "usar rango de edad:");

        if (edadFinalTexto == null) {
            return;
        }

        edadInicialTexto
                = edadInicialTexto.trim();

        edadFinalTexto
                = edadFinalTexto.trim();

        int edadInicial = -1;
        int edadFinal = -1;

        boolean algunaEdadIngresada
                = !edadInicialTexto.isEmpty()
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

                edadInicial
                        = Integer.parseInt(
                                edadInicialTexto);

                edadFinal
                        = Integer.parseInt(
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

        String diagnostico
                = JOptionPane.showInputDialog(
                        "Ingrese el diagnóstico.\n"
                        + "Déjelo vacío si no desea "
                        + "utilizarlo:");

        if (diagnostico == null) {
            return;
        }

        String genero
                = JOptionPane.showInputDialog(
                        "Ingrese el género.\n"
                        + "Ejemplo: MASCULINO o FEMENINO.\n"
                        + "Déjelo vacío si no desea "
                        + "utilizarlo:");

        if (genero == null) {
            return;
        }

        String medicamento
                = JOptionPane.showInputDialog(
                        "Ingrese el medicamento.\n"
                        + "Déjelo vacío si no desea "
                        + "utilizarlo:");

        if (medicamento == null) {
            return;
        }

        diagnostico = diagnostico.trim();
        genero = genero.trim();
        medicamento = medicamento.trim();

        boolean sinParametros
                = edadInicial == -1
                && diagnostico.isEmpty()
                && genero.isEmpty()
                && medicamento.isEmpty();

        if (sinParametros) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar al menos un parámetro.");

            return;
        }

        String reporte
                = gestorBI.detectarPatrones(
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