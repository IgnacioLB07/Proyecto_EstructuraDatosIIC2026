package EstructurasBase;

/**
 *
 * @author EQUIPO
 */
public class Contacto {

    private int telefono;
    private String nombre;

    public Contacto(int telefono, String nombre) {
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
