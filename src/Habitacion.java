/*
 * @author: Nils Muralles Morales
 * @version: 1.0
 * @since: 24/8/2023
 * Clase Habitación que modela una habitación del programa
 */

public class Habitacion { // Clase Habitacion

    // Atributos y objetos de Habitacion
    private String tipoHabitacion;
    private int numero;
    private int capacidadMax;
    private double precio;
    private Usuario[] listaClientes;

    // Constructor de habitación
    public Habitacion(String tipoHabitacion, int numero, int capacidadMax, double precio) {
        this.tipoHabitacion = tipoHabitacion;
        this.numero = numero;
        this.capacidadMax = capacidadMax;
        this.precio = precio;
        listaClientes = new Usuario[capacidadMax];
    }

    /**
     * @return String
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * @param tipoHabitacion
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     * @return int
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return int
     */
    public int getCapacidadMax() {
        return capacidadMax;
    }

    /**
     * @param capacidadMax
     */
    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    /**
     * @return double
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return Usuario[]
     */
    public Usuario[] getListaClientes() {
        return listaClientes;
    }

    /**
     * @param listaClientes
     */
    public void setListaClientes(Usuario[] listaClientes) {
        this.listaClientes = listaClientes;
    }

}
