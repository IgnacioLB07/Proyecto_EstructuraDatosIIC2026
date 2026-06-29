package Servicio;

/**
 * Gestiona las fichas del sistema hospitalario
 * @author ignap
 */
public class GeneradorFicha {
    
    //Atributos
    private int contadorRegular;
    private int contadorPreferencial;

    //Constructores
    /**
     * Crea una ficha con los valores ingresados
     * @param contadorRegular contador de pacientes Regulares
     * @param contadorPreferencial contador de pacientes Preferenciales
     */
    public GeneradorFicha(int contadorRegular, int contadorPreferencial) {
        this.contadorRegular = 0;
        this.contadorPreferencial = 0;
    }  

    public GeneradorFicha() {}
    
    //Metodos
    /**
     * Generar una ficha consecutiva para un paciente regular
     * Cada vez que se invoca, incrementa el contador
     * retornando una cadena con P + contador
     * @return Numero de ficha para un paciente Regular
     */
    public String generarRegular() {
        contadorRegular += 1;
        
        return "R" + contadorRegular;
    }
    
    /**
     * Generar una ficha consecutiva para un paciente preferencial
     * Cada vez que se invoca, incrementa el contador
     * retornando una cadena con P + contador
     * @return Numero de ficha para un paciente Preferencial
     */
    public String generarPreferencial(){
        contadorPreferencial += 1;
        
        return "P" + contadorPreferencial;
    }
}
