package Menu;
import Modelo.ExpedientePaciente;
import Estructura.ColaPacientes;
import Modelo.Paciente;
import Servicio.GestorPacientes;
import javax.swing.JOptionPane;

/**
 * Muestra el menú de gestión de pacientes.
 *
 * @author nelson
 */
public class MenuPacientes {

    // Atributos
    private GestorPacientes gestorP;

    /**
     * Constructor.
     */
    public MenuPacientes() {
        gestorP = new GestorPacientes();
    }

    /**
     * Menú principal.
     */
    public void mostrarMenu() {

        int opcion;

        do {

            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "====================================\n"
                        + "GESTIONAR LLEGADA DE PACIENTES\n"
                        + "====================================\n\n"
                        + "1. Seleccionar Ficha\n"
                        + "2. Atender Paciente\n"
                        + "3. Abandonar Cola\n"
                        + "4. Mostrar Pacientes Pendientes\n"
                        + "5. Mostrar Quejas\n"
                        + "6. Gestión de Expedientes\n"
                        + "7. Mostrar Bitácora del Día\n"
                        + "8. Regresar\n\n"
                        + "Seleccione una opción:"
                ));

            } catch (Exception e) {
                opcion = 0;
            }

            switch (opcion) {

                case 1:
                    seleccionarFicha();
                    break;

                case 2:
                    atenderPaciente();
                    break;

                case 3:
                    abandonarCola();
                    break;

                case 4:
                    mostrarPacientesPendientes();
                    break;

                case 5:
                    mostrarQuejas();
                    break;

                case 6:
                    mostrarMenuExpedientes();
                    break;

                case 7:
                    mostrarBitacora();
                    break;

                case 8:
                    JOptionPane.showMessageDialog(
                            null,
                            "Regresando al menú principal...");
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opción inválida.");
            }

        } while (opcion != 8);

    }

    /**
     * Registrar paciente.
     */
    private void seleccionarFicha() {

        String opcion = JOptionPane.showInputDialog(
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
                JOptionPane.showMessageDialog(
                        null,
                        "Opción inválida.");
                return;
        }

        String nombre = JOptionPane.showInputDialog(
                "Ingrese el nombre del paciente:");

        if (nombre == null) {
            return;
        }

        String cedula = JOptionPane.showInputDialog(
                "Ingrese la cédula del paciente:");

        if (cedula == null) {
            return;
        }

        Paciente paciente = gestorP.seleccionarFicha(
                cedula,
                nombre,
                tipoPaciente);

        JOptionPane.showMessageDialog(
                null,
                "Paciente registrado correctamente.\n\n"
                + "Ficha: " + paciente.getFicha());
    }

    /**
     * Atender paciente.
     */
    private void atenderPaciente() {

        Paciente paciente = gestorP.atenderPaciente();

        if (paciente == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay pacientes en espera.");

            return;
        }

        JOptionPane.showMessageDialog(
                null,
                "Paciente atendido correctamente.\n\n"
                + "Ficha: " + paciente.getFicha()
                + "\nCédula: " + paciente.getCedula()
                + "\nNombre: " + paciente.getNombre());

    }

    /**
     * Abandonar cola.
     */
    private void abandonarCola() {

        String ficha = JOptionPane.showInputDialog(
                "Ingrese el número de ficha:");

        if (ficha == null) {
            return;
        }

        String motivo = JOptionPane.showInputDialog(
                "Ingrese el motivo:");

        if (motivo == null) {
            return;
        }

        Paciente paciente =
                gestorP.abandonarCola(ficha, motivo);

        if (paciente == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "No existe esa ficha.");

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "El paciente abandonó la cola.");
        }

    }

    /**
     * Mostrar pacientes pendientes.
     */
    private void mostrarPacientesPendientes() {

        ColaPacientes cola;

        int inicio;
        int total;

        cola = gestorP.getColaPreferencial();

        total = cola.contarPacientes();

        inicio = 0;

        if (total == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay pacientes en la cola preferencial.");

        }

        while (inicio < total) {

            JOptionPane.showMessageDialog(
                    null,
                    "====== COLA PREFERENCIAL ======\n\n"
                    + cola.mostrarPaciente(inicio, 2));

            inicio += 2;

        }

        cola = gestorP.getColaRegular();

        total = cola.contarPacientes();

        inicio = 0;

        if (total == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "No hay pacientes en la cola regular.");

        }

        while (inicio < total) {

            JOptionPane.showMessageDialog(
                    null,
                    "====== COLA REGULAR ======\n\n"
                    + cola.mostrarPaciente(inicio, 2));

            inicio += 2;

        }

    }

    /**
     * Mostrar quejas.
     */
    private void mostrarQuejas() {

        int total =
                gestorP.getGestorQ().contarQuejas();

        int inicio = 0;

        if (total == 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "No existen quejas registradas.");

            return;
        }

        while (inicio < total) {

            JOptionPane.showMessageDialog(
                    null,
                    gestorP.getGestorQ().mostrarQuejas(
                            inicio,
                            2));

            inicio += 2;

        }

    }
    /**
     * Menú para gestionar los expedientes médicos.
     */
    private void mostrarMenuExpedientes() {

        int opcion;

        do {

            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "====================================\n"
                        + "GESTIÓN DE EXPEDIENTES MÉDICOS\n"
                        + "====================================\n\n"
                        + "1. Registrar Expediente\n"
                        + "2. Buscar Expediente\n"
                        + "3. Registrar Cita\n"
                        + "4. Registrar Medicamento\n"
                        + "5. Mostrar Todos los Expedientes\n"
                        + "6. Navegar Expedientes\n"
                        + "7. Regresar\n\n"
                        + "Seleccione una opción:"
                ));

            } catch (Exception e) {
                opcion = 0;
            }

            switch (opcion) {

                case 1:
                    registrarExpediente();
                    break;

                case 2:
                    buscarExpediente();
                    break;

                case 3:
                    registrarCita();
                    break;

                case 4:
                    registrarMedicamento();
                    break;

                case 5:
                    mostrarTodosLosExpedientes();
                    break;

                case 6:
                    navegarExpedientes();
                    break;

                case 7:
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opción inválida.");
            }

        } while (opcion != 7);

    }

    /**
     * Registrar un expediente médico.
     */
    private void registrarExpediente() {

        String cedula = JOptionPane.showInputDialog(
                "Ingrese la cédula:");

        if (cedula == null) {
            return;
        }

        String nombre = JOptionPane.showInputDialog(
                "Ingrese el nombre:");

        if (nombre == null) {
            return;
        }

        int edad;

        try {

            edad = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Ingrese la edad:"));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Edad inválida.");

            return;
        }

        String genero = JOptionPane.showInputDialog(
                "Ingrese el género:");

        if (genero == null) {
            return;
        }

        boolean registrado =
                gestorP.registrarExpediente(
                        cedula,
                        nombre,
                        edad,
                        genero);

        if (registrado) {

            JOptionPane.showMessageDialog(
                    null,
                    "Expediente registrado correctamente.");

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Ya existe un expediente con esa cédula.");
        }

    }
    /**
     * Busca un expediente por número de cédula.
     */
    private void buscarExpediente() {

        String cedula = JOptionPane.showInputDialog(
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
                gestorP.mostrarExpediente(cedula));
    }

    /**
     * Registra una cita en el expediente del paciente.
     */
    private void registrarCita() {

        String cedula = JOptionPane.showInputDialog(
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

        if (gestorP.buscarExpediente(cedula) == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "No existe un expediente con esa cédula.");

            return;
        }

        String doctor = JOptionPane.showInputDialog(
                "Ingrese el nombre del doctor:");

        if (doctor == null) {
            return;
        }

        doctor = doctor.trim();

        if (doctor.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar el nombre del doctor.");

            return;
        }

        String diagnostico = JOptionPane.showInputDialog(
                "Ingrese el diagnóstico:");

        if (diagnostico == null) {
            return;
        }

        diagnostico = diagnostico.trim();

        if (diagnostico.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar un diagnóstico.");

            return;
        }

        boolean registrado =
                gestorP.registrarCita(
                        cedula,
                        doctor,
                        diagnostico);

        if (registrado) {

            JOptionPane.showMessageDialog(
                    null,
                    "Cita registrada correctamente.");

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "No fue posible registrar la cita.");
        }
    }
    /**
     * Registra un medicamento en el expediente del paciente.
     */
    private void registrarMedicamento() {

        String cedula = JOptionPane.showInputDialog(
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

        if (gestorP.buscarExpediente(cedula) == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "No existe un expediente con esa cédula.");

            return;
        }

        String medicamento = JOptionPane.showInputDialog(
                "Ingrese el nombre del medicamento:");

        if (medicamento == null) {
            return;
        }

        medicamento = medicamento.trim();

        if (medicamento.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe ingresar el nombre del medicamento.");

            return;
        }

        boolean registrado =
                gestorP.registrarMedicamento(
                        cedula,
                        medicamento);

        if (registrado) {

            JOptionPane.showMessageDialog(
                    null,
                    "Medicamento registrado correctamente.");

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "No fue posible registrar el medicamento.");
        }
    }

    /**
     * Muestra todos los expedientes registrados.
     */
    private void mostrarTodosLosExpedientes() {

        JOptionPane.showMessageDialog(
                null,
                gestorP.mostrarTodosLosExpedientes());
    }
    /**
     * Permite navegar entre los expedientes registrados.
     */
    private void navegarExpedientes() {

        ExpedientePaciente expediente =
                gestorP.iniciarNavegacionExpedientes();

        if (expediente == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "No existen expedientes registrados.");

            return;
        }

        int opcion;

        do {

            try {

                opcion = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "====================================\n"
                                + "NAVEGACIÓN DE EXPEDIENTES\n"
                                + "====================================\n\n"
                                + expediente.mostrarExpediente()
                                + "\n\n"
                                + "1. Siguiente Expediente\n"
                                + "2. Expediente Anterior\n"
                                + "3. Salir\n\n"
                                + "Seleccione una opción:"
                        )
                );

            } catch (Exception e) {
                opcion = 0;
            }

            switch (opcion) {

                case 1:
                    expediente = gestorP.siguienteExpediente();
                    break;

                case 2:
                    expediente = gestorP.anteriorExpediente();
                    break;

                case 3:
                    break;

                default:
                    JOptionPane.showMessageDialog(
                            null,
                            "Opción inválida.");
            }

        } while (opcion != 3);
    }

    /**
     * Muestra la bitácora de pacientes atendidos.
     */
    private void mostrarBitacora() {

        JOptionPane.showMessageDialog(
                null,
                "====================================\n"
                + "BITÁCORA DE CITAS DEL DÍA\n"
                + "====================================\n\n"
                + gestorP.mostrarBitacora()
                + "\n\nTotal de pacientes atendidos: "
                + gestorP.totalAtendidos()
        );
    }

}