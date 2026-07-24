package Servicio;

/**
 * Genera fichas para pacientes regulares y preferenciales.
 *
 * @author nelson
 */
public class GeneradorFicha {

    private int contadorRegular;
    private int contadorPreferencial;

    /**
     * Constructor.
     */
    public GeneradorFicha() {

        contadorRegular = 0;
        contadorPreferencial = 0;
    }

    /**
     * Genera una ficha para un paciente regular.
     *
     * @return ficha regular
     */
    public String generarRegular() {

        contadorRegular++;

        return "R-" + contadorRegular;
    }

    /**
     * Genera una ficha para un paciente preferencial.
     *
     * @return ficha preferencial
     */
    public String generarPreferencial() {

        contadorPreferencial++;

        return "P-" + contadorPreferencial;
    }
}