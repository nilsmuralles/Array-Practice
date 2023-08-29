/*
 * @author: Nils Muralles Morales
 * @version: 1.0
 * @since: 24/8/2023
 * Clase Usuario que modela a los clientes del hotel
 */

public class Usuario { // Clase usuario

    // Atributos y objetos de Usuario
    private String nombre;
    private String tipoUsuario;
    private int cantidadVisitas;

    public Usuario(String nombre, int cantidadVisitas, String tipoUsuario) { // Constructor de Usuario
        this.nombre = nombre;
        this.cantidadVisitas = cantidadVisitas;
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * @param tipoUsuario
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * @return int
     */
    public int getCantidadVisitas() {
        return cantidadVisitas;
    }

    /**
     * @param cantidadVisitas
     */
    public void setCantidadVisitas(int cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

}
