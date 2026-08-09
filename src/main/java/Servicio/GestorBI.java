package Servicio;

import Estructura.ArbolExpedientes;
import Estructura.ListaDiagnosticos;
import Estructura.NodoCita;
import Estructura.NodoExpedienteArbol;
import Estructura.NodoMedicamento;
import Modelo.ExpedientePaciente;

/**
 * Gestiona las funciones de Inteligencia Empresarial
 * del sistema hospitalario.
 *
 * @author nelson
 */
public class GestorBI {

    private ArbolExpedientes arbolE;

    // Variables auxiliares para paginar la propuesta de valor
    private int indicePrioridad;
    private int mostradosPrioridad;
    private String mensajePrioridad;

    /**
     * Constructor.
     *
     * @param arbolE árbol de expedientes
     */
    public GestorBI(ArbolExpedientes arbolE) {
        this.arbolE = arbolE;
    }

    /**
     * Genera el análisis completo de enfermedades
     * más frecuentes.
     *
     * @return reporte de diagnósticos
     */
    public String analizarEnfermedades() {

        if (arbolE == null || arbolE.esVacia()) {
            return "No existen expedientes cargados.";
        }

        ListaDiagnosticos lista = crearListaDiagnosticos();

        String mensaje = "";

        mensaje += "=================================\n";
        mensaje += "ENFERMEDADES MÁS FRECUENTES\n";
        mensaje += "=================================\n\n";
        mensaje += lista.mostrarPorFrecuencia();

        return mensaje;
    }

    /**
     * Genera una página del análisis de enfermedades
     * más frecuentes.
     *
     * @param inicio posición inicial
     * @param cantidad cantidad máxima por mostrar
     * @return diagnósticos correspondientes a la página
     */
    public String analizarEnfermedades(
            int inicio,
            int cantidad) {

        if (arbolE == null || arbolE.esVacia()) {
            return "No existen expedientes cargados.";
        }

        ListaDiagnosticos lista = crearListaDiagnosticos();

        return lista.mostrarPorFrecuencia(
                inicio,
                cantidad);
    }

    /**
     * Cuenta la cantidad de diagnósticos diferentes.
     *
     * @return cantidad de diagnósticos
     */
    public int contarDiagnosticos() {

        if (arbolE == null || arbolE.esVacia()) {
            return 0;
        }

        ListaDiagnosticos lista = crearListaDiagnosticos();

        return lista.contarDiagnosticos();
    }

    /**
     * Crea y llena la lista de diagnósticos.
     *
     * @return lista con diagnósticos contabilizados
     */
    private ListaDiagnosticos crearListaDiagnosticos() {

        ListaDiagnosticos lista =
                new ListaDiagnosticos();

        acumularDiagnosticos(
                arbolE.getRaizExpediente(),
                lista);

        return lista;
    }

    /**
     * Recorre el ABB y acumula los diagnósticos.
     *
     * @param nodoActual nodo actual
     * @param lista lista de diagnósticos
     */
    private void acumularDiagnosticos(
            NodoExpedienteArbol nodoActual,
            ListaDiagnosticos lista) {

        if (nodoActual == null) {
            return;
        }

        acumularDiagnosticos(
                nodoActual.getNodoIzq(),
                lista);

        ExpedientePaciente expediente =
                nodoActual.getDato();

        if (expediente != null
                && expediente.getHistoricoCitas() != null) {

            expediente.getHistoricoCitas()
                    .acumularDiagnosticos(lista);
        }

        acumularDiagnosticos(
                nodoActual.getNodoDer(),
                lista);
    }

    /**
     * Segmenta los pacientes según su edad.
     *
     * @return reporte de segmentación
     */
    public String segmentarPacientes() {

        if (arbolE == null || arbolE.esVacia()) {
            return "No existen expedientes cargados.";
        }

        int menores = contarPorGrupo(
                arbolE.getRaizExpediente(),
                1);

        int adultos = contarPorGrupo(
                arbolE.getRaizExpediente(),
                2);

        int adultosMayores = contarPorGrupo(
                arbolE.getRaizExpediente(),
                3);

        int total = menores
                + adultos
                + adultosMayores;

        String mensaje = "";

        mensaje += "=================================\n";
        mensaje += "SEGMENTACIÓN DE PACIENTES\n";
        mensaje += "=================================\n\n";

        mensaje += "Menores de Edad: "
                + menores
                + " pacientes.\n";

        mensaje += "Adultos: "
                + adultos
                + " pacientes.\n";

        mensaje += "Adultos Mayores: "
                + adultosMayores
                + " pacientes.\n\n";

        mensaje += "Total de pacientes: "
                + total;

        return mensaje;
    }

    /**
     * Cuenta pacientes pertenecientes a un grupo de edad.
     *
     * @param nodoActual nodo actual
     * @param grupo grupo solicitado
     * @return cantidad de pacientes
     */
    private int contarPorGrupo(
            NodoExpedienteArbol nodoActual,
            int grupo) {

        if (nodoActual == null) {
            return 0;
        }

        int contador = 0;

        ExpedientePaciente expediente =
                nodoActual.getDato();

        if (expediente != null) {

            int edad = expediente.getEdad();

            if (grupo == 1 && edad < 18) {

                contador = 1;

            } else if (grupo == 2
                    && edad >= 18
                    && edad < 65) {

                contador = 1;

            } else if (grupo == 3
                    && edad >= 65) {

                contador = 1;
            }
        }

        contador += contarPorGrupo(
                nodoActual.getNodoIzq(),
                grupo);

        contador += contarPorGrupo(
                nodoActual.getNodoDer(),
                grupo);

        return contador;
    }

    /**
     * Realiza una consulta avanzada utilizando
     * uno o más parámetros.
     *
     * Para no utilizar las edades se debe enviar -1.
     *
     * @param edadInicial edad mínima
     * @param edadFinal edad máxima
     * @param diagnostico diagnóstico buscado
     * @param genero género buscado
     * @param medicamento medicamento buscado
     * @return reporte de coincidencias
     */
    public String detectarPatrones(
            int edadInicial,
            int edadFinal,
            String diagnostico,
            String genero,
            String medicamento) {

        if (arbolE == null || arbolE.esVacia()) {
            return "No existen expedientes cargados.";
        }

        boolean usaEdad =
                edadInicial >= 0
                && edadFinal >= 0;

        boolean usaDiagnostico =
                diagnostico != null
                && !diagnostico.trim().isEmpty();

        boolean usaGenero =
                genero != null
                && !genero.trim().isEmpty();

        boolean usaMedicamento =
                medicamento != null
                && !medicamento.trim().isEmpty();

        if (!usaEdad
                && !usaDiagnostico
                && !usaGenero
                && !usaMedicamento) {

            return "Debe ingresar al menos un parámetro.";
        }

        if (usaEdad && edadInicial > edadFinal) {

            return "La edad inicial no puede ser "
                    + "mayor que la edad final.";
        }

        int encontrados = contarCoincidencias(
                arbolE.getRaizExpediente(),
                edadInicial,
                edadFinal,
                diagnostico,
                genero,
                medicamento);

        String mensaje = "";

        mensaje += "=================================\n";
        mensaje += "DETECCIÓN DE PATRONES\n";
        mensaje += "=================================\n\n";

        mensaje += "PARÁMETROS DE ENTRADA\n";
        mensaje += "---------------------------------\n";

        if (usaEdad) {

            mensaje += "Rango de edad: "
                    + edadInicial
                    + " a "
                    + edadFinal
                    + " años\n";

        } else {

            mensaje += "Rango de edad: No utilizado\n";
        }

        if (usaDiagnostico) {

            mensaje += "Diagnóstico: "
                    + diagnostico.trim()
                    + "\n";

        } else {

            mensaje += "Diagnóstico: No utilizado\n";
        }

        if (usaGenero) {

            mensaje += "Género: "
                    + genero.trim()
                    + "\n";

        } else {

            mensaje += "Género: No utilizado\n";
        }

        if (usaMedicamento) {

            mensaje += "Medicamento: "
                    + medicamento.trim()
                    + "\n";

        } else {

            mensaje += "Medicamento: No utilizado\n";
        }

        mensaje += "\nRESULTADO DE LA BÚSQUEDA\n";
        mensaje += "---------------------------------\n";
        mensaje += "Pacientes encontrados: "
                + encontrados;

        return mensaje;
    }

    /**
     * Recorre el ABB y cuenta las coincidencias.
     *
     * @param nodoActual nodo actual
     * @param edadInicial edad mínima
     * @param edadFinal edad máxima
     * @param diagnostico diagnóstico
     * @param genero género
     * @param medicamento medicamento
     * @return cantidad de coincidencias
     */
    private int contarCoincidencias(
            NodoExpedienteArbol nodoActual,
            int edadInicial,
            int edadFinal,
            String diagnostico,
            String genero,
            String medicamento) {

        if (nodoActual == null) {
            return 0;
        }

        int contador = 0;

        ExpedientePaciente expediente =
                nodoActual.getDato();

        if (expediente != null
                && cumpleParametros(
                        expediente,
                        edadInicial,
                        edadFinal,
                        diagnostico,
                        genero,
                        medicamento)) {

            contador = 1;
        }

        contador += contarCoincidencias(
                nodoActual.getNodoIzq(),
                edadInicial,
                edadFinal,
                diagnostico,
                genero,
                medicamento);

        contador += contarCoincidencias(
                nodoActual.getNodoDer(),
                edadInicial,
                edadFinal,
                diagnostico,
                genero,
                medicamento);

        return contador;
    }

    /**
     * Determina si un expediente cumple los parámetros.
     *
     * @param expediente expediente evaluado
     * @param edadInicial edad mínima
     * @param edadFinal edad máxima
     * @param diagnostico diagnóstico
     * @param genero género
     * @param medicamento medicamento
     * @return true si cumple todos los parámetros
     */
    private boolean cumpleParametros(
            ExpedientePaciente expediente,
            int edadInicial,
            int edadFinal,
            String diagnostico,
            String genero,
            String medicamento) {

        boolean usaEdad =
                edadInicial >= 0
                && edadFinal >= 0;

        if (usaEdad
                && (expediente.getEdad() < edadInicial
                || expediente.getEdad() > edadFinal)) {

            return false;
        }

        if (genero != null
                && !genero.trim().isEmpty()) {

            if (expediente.getGenero() == null
                    || !expediente.getGenero()
                            .equalsIgnoreCase(
                                    genero.trim())) {

                return false;
            }
        }

        if (diagnostico != null
                && !diagnostico.trim().isEmpty()) {

            if (expediente.getHistoricoCitas() == null
                    || !expediente.getHistoricoCitas()
                            .contieneDiagnostico(
                                    diagnostico.trim())) {

                return false;
            }
        }

        if (medicamento != null
                && !medicamento.trim().isEmpty()) {

            if (expediente.getHistoricoMedicamentos() == null
                    || !expediente
                            .getHistoricoMedicamentos()
                            .contieneMedicamento(
                                    medicamento.trim())) {

                return false;
            }
        }

        return true;
    }

    /**
     * Genera el reporte completo de propuesta de valor.
     *
     * @return reporte completo
     */
    public String generarPropuestaValor() {

        if (arbolE == null || arbolE.esVacia()) {
            return "No existen expedientes cargados.";
        }

        int cantidad =
                contarPacientesPrioritarios();

        String mensaje = "";

        mensaje += "=================================\n";
        mensaje += "PROPUESTA DE VALOR\n";
        mensaje += "PACIENTES DE ATENCIÓN PRIORITARIA\n";
        mensaje += "=================================\n\n";

        mensaje += "Criterios utilizados:\n";
        mensaje += "- Tener 65 años o más.\n";
        mensaje += "- Tener 3 o más citas registradas.\n";
        mensaje += "- Tener 3 o más medicamentos prescritos.\n\n";

        mensaje += "Pacientes identificados: "
                + cantidad
                + "\n\n";

        if (cantidad == 0) {

            mensaje += "No se identificaron pacientes "
                    + "de atención prioritaria.";

            return mensaje;
        }

        mensaje += generarPropuestaValor(
                0,
                cantidad);

        return mensaje;
    }

    /**
     * Cuenta todos los pacientes que cumplen
     * al menos un criterio de prioridad.
     *
     * @return cantidad de pacientes prioritarios
     */
    public int contarPacientesPrioritarios() {

        if (arbolE == null || arbolE.esVacia()) {
            return 0;
        }

        return contarPacientesPrioritariosRec(
                arbolE.getRaizExpediente());
    }

    /**
     * Cuenta recursivamente los pacientes prioritarios.
     *
     * @param nodoActual nodo actual
     * @return cantidad de pacientes prioritarios
     */
    private int contarPacientesPrioritariosRec(
            NodoExpedienteArbol nodoActual) {

        if (nodoActual == null) {
            return 0;
        }

        int contador = 0;

        ExpedientePaciente expediente =
                nodoActual.getDato();

        if (expediente != null
                && esPacientePrioritario(expediente)) {

            contador = 1;
        }

        contador += contarPacientesPrioritariosRec(
                nodoActual.getNodoIzq());

        contador += contarPacientesPrioritariosRec(
                nodoActual.getNodoDer());

        return contador;
    }

    /**
     * Genera una página de pacientes prioritarios.
     *
     * @param inicio posición inicial
     * @param cantidad cantidad máxima por mostrar
     * @return pacientes correspondientes a la página
     */
    public String generarPropuestaValor(
            int inicio,
            int cantidad) {

        if (arbolE == null || arbolE.esVacia()) {
            return "No existen expedientes cargados.";
        }

        if (inicio < 0) {
            inicio = 0;
        }

        if (cantidad <= 0) {
            return "No hay pacientes para mostrar.";
        }

        indicePrioridad = 0;
        mostradosPrioridad = 0;
        mensajePrioridad = "";

        obtenerPrioritariosPagina(
                arbolE.getRaizExpediente(),
                inicio,
                cantidad);

        if (mensajePrioridad.isEmpty()) {
            return "No existen pacientes "
                    + "prioritarios en esa posición.";
        }

        return mensajePrioridad;
    }

    /**
     * Recorre el árbol en InOrden y obtiene solamente
     * los pacientes prioritarios correspondientes
     * a la página solicitada.
     *
     * @param nodoActual nodo actual
     * @param inicio posición inicial
     * @param cantidad cantidad máxima
     */
    private void obtenerPrioritariosPagina(
            NodoExpedienteArbol nodoActual,
            int inicio,
            int cantidad) {

        if (nodoActual == null
                || mostradosPrioridad >= cantidad) {

            return;
        }

        obtenerPrioritariosPagina(
                nodoActual.getNodoIzq(),
                inicio,
                cantidad);

        if (mostradosPrioridad >= cantidad) {
            return;
        }

        ExpedientePaciente expediente =
                nodoActual.getDato();

        if (expediente != null
                && esPacientePrioritario(expediente)) {

            if (indicePrioridad >= inicio) {

                mensajePrioridad +=
                        crearDetallePrioridad(
                                expediente);

                mostradosPrioridad++;
            }

            indicePrioridad++;
        }

        obtenerPrioritariosPagina(
                nodoActual.getNodoDer(),
                inicio,
                cantidad);
    }

    /**
     * Crea la información de un paciente prioritario.
     *
     * @param expediente expediente del paciente
     * @return detalle del paciente
     */
    private String crearDetallePrioridad(
            ExpedientePaciente expediente) {

        int citas = contarCitas(expediente);

        int medicamentos =
                contarMedicamentos(expediente);

        String mensaje = "";

        mensaje += "---------------------------------\n";

        mensaje += "Cédula: "
                + expediente.getCedula()
                + "\n";

        mensaje += "Nombre: "
                + expediente.getNombre()
                + "\n";

        mensaje += "Edad: "
                + expediente.getEdad()
                + "\n";

        mensaje += "Citas registradas: "
                + citas
                + "\n";

        mensaje += "Medicamentos registrados: "
                + medicamentos
                + "\n";

        mensaje += "Motivo de prioridad:\n";

        if (expediente.getEdad() >= 65) {

            mensaje += "- Adulto mayor.\n";
        }

        if (citas >= 3) {

            mensaje += "- Alto número de citas.\n";
        }

        if (medicamentos >= 3) {

            mensaje += "- Alto número de medicamentos.\n";
        }

        mensaje += "\n";

        return mensaje;
    }

    /**
     * Determina si un paciente cumple al menos
     * un criterio de prioridad.
     *
     * @param expediente expediente evaluado
     * @return true si es prioritario
     */
    private boolean esPacientePrioritario(
            ExpedientePaciente expediente) {

        int citas = contarCitas(expediente);

        int medicamentos =
                contarMedicamentos(expediente);

        return expediente.getEdad() >= 65
                || citas >= 3
                || medicamentos >= 3;
    }

    /**
     * Cuenta las citas de un expediente.
     *
     * @param expediente expediente evaluado
     * @return cantidad de citas
     */
    private int contarCitas(
            ExpedientePaciente expediente) {

        if (expediente.getHistoricoCitas() == null
                || expediente.getHistoricoCitas()
                        .esVacia()) {

            return 0;
        }

        NodoCita ultimo =
                expediente.getHistoricoCitas()
                        .getUltimoCita();

        if (ultimo == null) {
            return 0;
        }

        NodoCita primero =
                ultimo.getSiguiente();

        NodoCita actual = primero;

        int contador = 0;

        do {

            contador++;

            actual =
                    actual.getSiguiente();

        } while (actual != primero);

        return contador;
    }

    /**
     * Cuenta los medicamentos de un expediente.
     *
     * @param expediente expediente evaluado
     * @return cantidad de medicamentos
     */
    private int contarMedicamentos(
            ExpedientePaciente expediente) {

        if (expediente.getHistoricoMedicamentos() == null
                || expediente.getHistoricoMedicamentos()
                        .esVacia()) {

            return 0;
        }

        NodoMedicamento ultimo =
                expediente
                        .getHistoricoMedicamentos()
                        .getUltimoMedicamento();

        if (ultimo == null) {
            return 0;
        }

        NodoMedicamento primero =
                ultimo.getSiguiente();

        NodoMedicamento actual =
                primero;

        int contador = 0;

        do {

            contador++;

            actual =
                    actual.getSiguiente();

        } while (actual != primero);

        return contador;
    }

    /**
     * Devuelve el árbol de expedientes.
     *
     * @return árbol de expedientes
     */
    public ArbolExpedientes getArbolE() {

        return arbolE;
    }

    /**
     * Modifica el árbol de expedientes.
     *
     * @param arbolE nuevo árbol
     */
    public void setArbolE(
            ArbolExpedientes arbolE) {

        this.arbolE = arbolE;
    }
}