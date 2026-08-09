package Estructura;

/**
 * Nodo utilizado para almacenar un diagnóstico
 * y la cantidad de veces que aparece.
 *
 * @author nelson
 */
public class NodoDiagnostico {

    private String diagnostico;
    private int cantidad;
    private boolean mostrado;
    private NodoDiagnostico siguiente;

    /**
     * Constructor.
     *
     * @param diagnostico nombre del diagnóstico
     */
    public NodoDiagnostico(String diagnostico) {

        this.diagnostico = diagnostico;
        this.cantidad = 1;
        this.mostrado = false;
        this.siguiente = null;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isMostrado() {
        return mostrado;
    }

    public void setMostrado(boolean mostrado) {
        this.mostrado = mostrado;
    }

    public NodoDiagnostico getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(
            NodoDiagnostico siguiente) {

        this.siguiente = siguiente;
    }

    /**
     * Aumenta en uno la cantidad de casos.
     */
    public void aumentarCantidad() {

        cantidad++;
    }
}