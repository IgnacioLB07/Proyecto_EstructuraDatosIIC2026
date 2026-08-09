/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Cita;
import Modelo.ExpedientePaciente;
import Modelo.Medicamento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Permite cargar expedientes medicos desde
 * un archivo JSON.
 *
 * Los expedientes son almacenados posteriormente
 * en el Arbol Binario de Busqueda.
 *
 * @author nelson
 */
public class CargadorJSON {

    // Atributos
    private GestorExpedientes gestorExpedientes;
    private SimpleDateFormat formatoFecha;

    /**
     * Constructor.
     *
     * @param gestorExpedientes gestor de expedientes
     */
    public CargadorJSON(
            GestorExpedientes gestorExpedientes) {

        this.gestorExpedientes
                = gestorExpedientes;

        formatoFecha
                = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");

        formatoFecha.setLenient(false);
    }

    /**
     * Carga un archivo JSON.
     *
     * @param archivo archivo seleccionado
     * @return cantidad de expedientes cargados
     * @throws IOException error de lectura
     */
    public int cargarArchivo(
            File archivo) throws IOException {

        if (archivo == null
                || !archivo.exists()) {

            return 0;
        }

        String contenido
                = leerArchivo(archivo);

        return procesarPacientes(
                contenido);
    }

    /**
     * Lee el archivo completo.
     *
     * @param archivo archivo JSON
     * @return contenido del archivo
     * @throws IOException error de lectura
     */
    private String leerArchivo(
            File archivo) throws IOException {

        BufferedReader lector
                = new BufferedReader(
                        new FileReader(archivo));

        StringBuilder contenido
                = new StringBuilder();

        String linea;

        while ((linea
                = lector.readLine()) != null) {

            contenido.append(linea);
            contenido.append("\n");
        }

        lector.close();

        return contenido.toString();
    }

    /**
     * Procesa los pacientes encontrados
     * dentro del archivo.
     *
     * @param contenido contenido JSON
     * @return cantidad de pacientes cargados
     */
    private int procesarPacientes(
            String contenido) {

        int cargados = 0;
        int nivelLlaves = 0;
        int inicioObjeto = -1;

        boolean dentroTexto = false;

        char anterior = '\0';

        for (int i = 0;
                i < contenido.length();
                i++) {

            char caracter
                    = contenido.charAt(i);

            if (caracter == '"'
                    && anterior != '\\') {

                dentroTexto = !dentroTexto;
            }

            if (!dentroTexto) {

                if (caracter == '{') {

                    nivelLlaves++;

                    if (nivelLlaves == 1) {

                        inicioObjeto = i;
                    }

                } else if (caracter == '}') {

                    if (nivelLlaves == 1
                            && inicioObjeto >= 0) {

                        String paciente
                                = contenido.substring(
                                        inicioObjeto,
                                        i + 1);

                        if (procesarPaciente(
                                paciente)) {

                            cargados++;
                        }

                        inicioObjeto = -1;
                    }

                    nivelLlaves--;
                }
            }

            anterior = caracter;
        }

        return cargados;
    }

    /**
     * Procesa un paciente del archivo.
     *
     * @param objetoPaciente informacion JSON
     * @return true si se registro
     */
    private boolean procesarPaciente(
            String objetoPaciente) {

        String cedula = obtenerTexto(
                objetoPaciente,
                "CEDULA");

        String nombre = obtenerTexto(
                objetoPaciente,
                "NOMBRE");

        int edad = obtenerNumero(
                objetoPaciente,
                "EDAD");

        String genero = obtenerTexto(
                objetoPaciente,
                "GENERO");

        if (cedula == null
                || nombre == null
                || edad < 0
                || genero == null) {

            return false;
        }

        ExpedientePaciente expediente
                = new ExpedientePaciente(
                        cedula,
                        nombre,
                        edad,
                        genero);

        String citas = obtenerArreglo(
                objetoPaciente,
                "CITAS");

        procesarCitas(
                citas,
                expediente);

        String medicamentos
                = obtenerArreglo(
                        objetoPaciente,
                        "MEDICAMENTOS");

        procesarMedicamentos(
                medicamentos,
                expediente);

        return gestorExpedientes
                .registrarExpediente(
                        expediente);
    }

    /**
     * Procesa las citas del paciente.
     *
     * @param contenido contenido de citas
     * @param expediente expediente
     */
    private void procesarCitas(
            String contenido,
            ExpedientePaciente expediente) {

        if (contenido == null) {
            return;
        }

        int nivel = 0;
        int inicio = -1;

        boolean dentroTexto = false;

        char anterior = '\0';

        for (int i = 0;
                i < contenido.length();
                i++) {

            char caracter
                    = contenido.charAt(i);

            if (caracter == '"'
                    && anterior != '\\') {

                dentroTexto = !dentroTexto;
            }

            if (!dentroTexto) {

                if (caracter == '{') {

                    nivel++;

                    if (nivel == 1) {
                        inicio = i;
                    }

                } else if (caracter == '}') {

                    if (nivel == 1
                            && inicio >= 0) {

                        String cita
                                = contenido.substring(
                                        inicio,
                                        i + 1);

                        agregarCita(
                                cita,
                                expediente);

                        inicio = -1;
                    }

                    nivel--;
                }
            }

            anterior = caracter;
        }
    }

    /**
     * Agrega una cita al expediente.
     *
     * @param objetoCita informacion de cita
     * @param expediente expediente
     */
    private void agregarCita(
            String objetoCita,
            ExpedientePaciente expediente) {

        String fechaTexto
                = obtenerTexto(
                        objetoCita,
                        "FECHA");

        String medico
                = obtenerTexto(
                        objetoCita,
                        "MEDICO");

        String diagnostico
                = obtenerTexto(
                        objetoCita,
                        "DIAGNOSTICO");

        Date fecha
                = convertirFecha(
                        fechaTexto);

        if (fecha == null
                || medico == null
                || diagnostico == null) {

            return;
        }

        Cita cita = new Cita(
                fecha,
                medico,
                diagnostico);

        expediente.agregarCita(cita);
    }

    /**
     * Procesa los medicamentos.
     *
     * @param contenido contenido de medicamentos
     * @param expediente expediente
     */
    private void procesarMedicamentos(
            String contenido,
            ExpedientePaciente expediente) {

        if (contenido == null) {
            return;
        }

        int nivel = 0;
        int inicio = -1;

        boolean dentroTexto = false;

        char anterior = '\0';

        for (int i = 0;
                i < contenido.length();
                i++) {

            char caracter
                    = contenido.charAt(i);

            if (caracter == '"'
                    && anterior != '\\') {

                dentroTexto = !dentroTexto;
            }

            if (!dentroTexto) {

                if (caracter == '{') {

                    nivel++;

                    if (nivel == 1) {

                        inicio = i;
                    }

                } else if (caracter == '}') {

                    if (nivel == 1
                            && inicio >= 0) {

                        String medicamento
                                = contenido.substring(
                                        inicio,
                                        i + 1);

                        agregarMedicamento(
                                medicamento,
                                expediente);

                        inicio = -1;
                    }

                    nivel--;
                }
            }

            anterior = caracter;
        }
    }

    /**
     * Agrega un medicamento al expediente.
     *
     * @param objetoMedicamento informacion
     * @param expediente expediente
     */
    private void agregarMedicamento(
            String objetoMedicamento,
            ExpedientePaciente expediente) {

        String fechaTexto
                = obtenerTexto(
                        objetoMedicamento,
                        "FECHA");

        String nombreMedicamento
                = obtenerTexto(
                        objetoMedicamento,
                        "MEDICAMENTO");

        Date fecha
                = convertirFecha(
                        fechaTexto);

        if (fecha == null
                || nombreMedicamento == null) {

            return;
        }

        Medicamento medicamento
                = new Medicamento(
                        fecha,
                        nombreMedicamento);

        expediente.agregarMedicamento(
                medicamento);
    }

    /**
     * Obtiene un texto del JSON.
     *
     * @param objeto objeto JSON
     * @param clave propiedad
     * @return texto encontrado
     */
    private String obtenerTexto(
            String objeto,
            String clave) {

        String etiqueta
                = "\"" + clave + "\"";

        int posicionClave
                = objeto.indexOf(etiqueta);

        if (posicionClave < 0) {

            return null;
        }

        int dosPuntos
                = objeto.indexOf(
                        ':',
                        posicionClave);

        if (dosPuntos < 0) {

            return null;
        }

        int inicio
                = objeto.indexOf(
                        '"',
                        dosPuntos + 1);

        if (inicio < 0) {

            return null;
        }

        int fin = buscarFinTexto(
                objeto,
                inicio + 1);

        if (fin < 0) {

            return null;
        }

        return objeto.substring(
                inicio + 1,
                fin).trim();
    }

    /**
     * Obtiene un numero del JSON.
     *
     * @param objeto objeto JSON
     * @param clave propiedad
     * @return numero encontrado
     */
    private int obtenerNumero(
            String objeto,
            String clave) {

        String etiqueta
                = "\"" + clave + "\"";

        int posicionClave
                = objeto.indexOf(etiqueta);

        if (posicionClave < 0) {

            return -1;
        }

        int dosPuntos
                = objeto.indexOf(
                        ':',
                        posicionClave);

        if (dosPuntos < 0) {

            return -1;
        }

        int posicion
                = dosPuntos + 1;

        while (posicion < objeto.length()
                && Character.isWhitespace(
                        objeto.charAt(posicion))) {

            posicion++;
        }

        String numero = "";

        while (posicion < objeto.length()
                && Character.isDigit(
                        objeto.charAt(posicion))) {

            numero += objeto.charAt(posicion);

            posicion++;
        }

        if (numero.isEmpty()) {

            return -1;
        }

        try {

            return Integer.parseInt(numero);

        } catch (NumberFormatException e) {

            return -1;
        }
    }

    /**
     * Obtiene un arreglo del JSON.
     *
     * @param objeto objeto JSON
     * @param clave propiedad
     * @return contenido del arreglo
     */
    private String obtenerArreglo(
            String objeto,
            String clave) {

        String etiqueta
                = "\"" + clave + "\"";

        int posicionClave
                = objeto.indexOf(etiqueta);

        if (posicionClave < 0) {

            return null;
        }

        int inicio
                = objeto.indexOf(
                        '[',
                        posicionClave);

        if (inicio < 0) {

            return null;
        }

        int nivel = 0;

        boolean dentroTexto = false;

        char anterior = '\0';

        for (int i = inicio;
                i < objeto.length();
                i++) {

            char caracter
                    = objeto.charAt(i);

            if (caracter == '"'
                    && anterior != '\\') {

                dentroTexto = !dentroTexto;
            }

            if (!dentroTexto) {

                if (caracter == '[') {

                    nivel++;

                } else if (caracter == ']') {

                    nivel--;

                    if (nivel == 0) {

                        return objeto.substring(
                                inicio + 1,
                                i);
                    }
                }
            }

            anterior = caracter;
        }

        return null;
    }

    /**
     * Busca el final de un texto.
     *
     * @param texto texto por revisar
     * @param inicio posicion inicial
     * @return posicion final
     */
    private int buscarFinTexto(
            String texto,
            int inicio) {

        for (int i = inicio;
                i < texto.length();
                i++) {

            if (texto.charAt(i) == '"'
                    && texto.charAt(i - 1) != '\\') {

                return i;
            }
        }

        return -1;
    }

    /**
     * Convierte un texto a fecha.
     *
     * @param fechaTexto fecha recibida
     * @return fecha convertida
     */
    private Date convertirFecha(
            String fechaTexto) {

        if (fechaTexto == null
                || fechaTexto.trim().isEmpty()) {

            return null;
        }

        try {

            return formatoFecha.parse(
                    fechaTexto.trim());

        } catch (ParseException e) {

            return null;
        }
    }
}