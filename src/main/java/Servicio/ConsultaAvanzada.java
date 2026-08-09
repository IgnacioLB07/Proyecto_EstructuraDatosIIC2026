/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;
import javax.swing.JOptionPane;

/**
 *
 * @author jrodriguez
 */
public class ConsultaAvanzada {
    
     private GestorPacientes gestorPacientes;

    public ConsultaAvanzada(GestorPacientes gestorPacientes) {
        this.gestorPacientes = gestorPacientes;
    }

    public void realizarConsulta() {

        String edadInicialTexto = JOptionPane.showInputDialog(
                null,
                "Ingrese la edad inicial.\n"
                + "Deje vacío si no desea utilizar este parámetro:"
        );

        String edadFinalTexto = JOptionPane.showInputDialog(
                null,
                "Ingrese la edad final.\n"
                + "Deje vacío si no desea utilizar este parámetro:"
        );

        String diagnostico = JOptionPane.showInputDialog(
                null,
                "Ingrese el diagnóstico.\n"
                + "Deje vacío si no desea utilizar este parámetro:"
        );

        String genero = JOptionPane.showInputDialog(
                null,
                "Ingrese el género.\n"
                + "Deje vacío si no desea utilizar este parámetro:"
        );

        String medicamento = JOptionPane.showInputDialog(
                null,
                "Ingrese el medicamento.\n"
                + "Deje vacío si no desea utilizar este parámetro:"
        );

        // Si el usuario cancela
        if (edadInicialTexto == null
                || edadFinalTexto == null
                || diagnostico == null
                || genero == null
                || medicamento == null) {

            return;
        }

        // Convertir las edades
        Integer edadInicial = null;
        Integer edadFinal = null;

        try {

            if (!edadInicialTexto.trim().isEmpty()
                    || !edadFinalTexto.trim().isEmpty()) {

                if (edadInicialTexto.trim().isEmpty()
                        || edadFinalTexto.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Debe ingresar la edad inicial y la edad final."
                    );

                    return;
                }

                edadInicial = Integer.parseInt(
                        edadInicialTexto.trim());

                edadFinal = Integer.parseInt(
                        edadFinalTexto.trim());

                if (edadInicial < 0 || edadFinal < 0) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Las edades no pueden ser negativas."
                    );

                    return;
                }

                if (edadInicial > edadFinal) {

                    JOptionPane.showMessageDialog(
                            null,
                            "La edad inicial no puede ser mayor "
                            + "que la edad final."
                    );

                    return;
                }
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Las edades deben ser números enteros."
            );

            return;
        }

        // Contar parámetros utilizados
        int parametros = 0;

        if (edadInicial != null && edadFinal != null) {
            parametros++;
        }

        if (!diagnostico.trim().isEmpty()) {
            parametros++;
        }

        if (!genero.trim().isEmpty()) {
            parametros++;
        }

        if (!medicamento.trim().isEmpty()) {
            parametros++;
        }

        // No se permite dejar todos los parámetros vacíos
        if (parametros == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar al menos un parámetro "
                    + "para realizar la consulta."
            );

            return;
        }

        // Realizar búsqueda
        int cantidad = gestorPacientes.consultarPacientes(
                edadInicial,
                edadFinal,
                diagnostico,
                genero,
                medicamento
        );

        // Crear ficha de resultados
        String resultado
                = "====================================\n"
                + "       CONSULTA AVANZADA\n"
                + "====================================\n\n"
                + "PARÁMETROS DE ENTRADA\n\n"
                + "Edad inicial: "
                + (edadInicial == null
                        ? "Vacío"
                        : edadInicial)
                + "\n"
                + "Edad final: "
                + (edadFinal == null
                        ? "Vacío"
                        : edadFinal)
                + "\n"
                + "Diagnóstico: "
                + (diagnostico.trim().isEmpty()
                        ? "Vacío"
                        : diagnostico)
                + "\n"
                + "Género: "
                + (genero.trim().isEmpty()
                        ? "Vacío"
                        : genero)
                + "\n"
                + "Medicamento: "
                + (medicamento.trim().isEmpty()
                        ? "Vacío"
                        : medicamento)
                + "\n\n"
                + "Cantidad de parámetros utilizados: "
                + parametros
                + "\n\n"
                + "====================================\n"
                + "RESULTADO DE LA BÚSQUEDA\n"
                + "====================================\n"
                + "Pacientes encontrados: "
                + cantidad;

        JOptionPane.showMessageDialog(null, resultado);
    }
    
}
