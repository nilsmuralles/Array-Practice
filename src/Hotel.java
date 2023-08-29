/*
 * @author: Nils Muralles Morales
 * @version: 1.0
 * @since: 24/8/2023
 * Clase Hotel que contiene toda la lógica del programa y utiliza otras clases
 */

// Importar las clases necesarias
import java.util.Scanner;

public class Hotel { // Clase Hotel

    // Atributos y objetos de Hotel
    private Habitacion[] listaDeHabitaciones;
    private Usuario[] listaDeEspera;
    Scanner input = new Scanner(System.in);

    public Hotel(int cantidadHabitaciones, int cantidadPersonas) { // Constructor de Hotel
        listaDeHabitaciones = new Habitacion[cantidadHabitaciones];
        listaDeEspera = new Usuario[cantidadPersonas];
    }

    // Setters y getters
    /**
     * @return Habitacion[]
     */
    public Habitacion[] getListaDeHabitaciones() {
        return listaDeHabitaciones;
    }

    /**
     * @param listaDeHabitaciones
     */
    public void setListaDeHabitaciones(Habitacion[] listaDeHabitaciones) {
        this.listaDeHabitaciones = listaDeHabitaciones;
    }

    /**
     * @return Usuario[]
     */
    public Usuario[] getlistaDeEspera() {
        return listaDeEspera;
    }

    /**
     * @param listaDeEspera
     */
    public void setlistaDeEspera(Usuario[] listaDeEspera) {
        this.listaDeEspera = listaDeEspera;
    }

    public void crearHabitacion() {

        // Ciclo que asegura que la habitación sea creada
        boolean habitacionCreada = false;

        while (!habitacionCreada) { // Ciclo para crear habitación

            // Variables que valida el tipo de habitación
            String tipo = null;
            boolean habitacionValidada = false;

            // Menú para crear una habitación
            System.out.println("");
            System.out.println("---CREAR HABITACIÓN---");
            System.out.print("Ingrese el número de habitación: ");
            String numeroHabitacion = input.nextLine();

            // Validar el tipo de habitación
            do {
                System.out.print("Ingrese el tipo de habitación (Estandar, Deluxe o Suite): ");
                String tipoHabitacion = input.nextLine();
                if (tipoHabitacion.equals("Estandar") || tipoHabitacion.equals("estandar")) {
                    tipo = "Estandar";
                    habitacionValidada = true;
                } else if (tipoHabitacion.equals("Deluxe") || tipoHabitacion.equals("deluxe")) {
                    tipo = "Deluxe";
                    habitacionValidada = true;
                } else if (tipoHabitacion.equals("Suite") || tipoHabitacion.equals("suite")) {
                    tipo = "Suite";
                    habitacionValidada = true;
                } else {
                    System.out.println("No es un tipo válido de habitación");
                }
            } while (!habitacionValidada);

            System.out.print("Ingrese la capacidad máxima de la habitación: ");
            String capacidadMax = input.nextLine();

            System.out.print("Ingrese el precio de la habitación: ");
            String costo = input.nextLine();

            // Validar los datos de la habitación
            try {
                int id = Integer.parseInt(numeroHabitacion);
                int capMax = Integer.parseInt(capacidadMax);
                double precio = Double.parseDouble(costo);

                // Nueva habitación
                Habitacion nuevaHabitacion = new Habitacion(tipo, id, capMax, precio);

                // Añadir la habitación a la lista de habitaciones
                boolean añadida = false;

                for (int i = 0; i < listaDeHabitaciones.length; i++) {
                    if (!añadida) {
                        if (listaDeHabitaciones[i] == null) {
                            listaDeHabitaciones[i] = nuevaHabitacion;
                            añadida = true;
                        }
                    }
                }

                System.out.println("Habitación agregada exitosamente");
                habitacionCreada = true;

            } catch (Exception e) {
                System.out.println("Error. Uno o más datos proporcionados no son válidos");
            }
        }

    }

    public void habitacionesDefault() {

        System.out.println("");
        System.out.println("---PRIMERAS TRES HABITACIONES---");
        for (int i = 0; i < 3; i++) { // Crea las primeras tres habitaciones
            crearHabitacion();
        }
    }

    public void recibirHuesped() {

        // Ciclo que asegura que se agregue el cliente
        boolean huespedRecibido = false;
        String tipoClienteAsignado;

        while (!huespedRecibido) { // Ciclo que crea al cliente

            // Menú para un nuevo cliente
            System.out.println("");
            System.out.println("---NUEVO CLIENTE---");
            System.out.print("Nombre del cliente: ");
            String nombreCliente = input.nextLine();

            System.out.print("Veces que ha visitado el hotel: ");
            String vecesVisitado = input.nextLine();

            // Validar los datos del cliente
            try {
                int veces = Integer.parseInt(vecesVisitado);

                // Asignar un tipo al cliente en función del número de veces visitado
                if (veces >= 5 && veces < 10) {
                    tipoClienteAsignado = "Frecuente";
                } else if (veces >= 10) {
                    tipoClienteAsignado = "VIP";
                } else {
                    tipoClienteAsignado = "Regular";
                }

                // Nuevo cliente
                Usuario nuevoCliente = new Usuario(nombreCliente, veces, tipoClienteAsignado);

                // Añadir al cliente a la lista de clientes
                boolean añadido = false;

                for (int i = 0; i < listaDeEspera.length; i++) {
                    if (!añadido) {
                        if (listaDeEspera[i] == null) {
                            listaDeEspera[i] = nuevoCliente;
                            añadido = true;
                        }
                    }
                }

                System.out.println("Cliente creado exitosamente");
                huespedRecibido = true;

            } catch (Exception e) {
                System.out.println("Ingrese un número");
            }
        }
    }

    public void asignarCliente() {
        boolean validado = false;

        // Ciclo que verifica que se asigne el cliente
        boolean asignacion = true;

        while (asignacion) { // Ciclo que asigna al cliente

            if (listaDeEspera[0] == null) { // Verificar que hayan clientes
                System.out.println("No hay clientes en la lista de espera");
                asignacion = false;

            } else { // Si si hay clientes

                // Muestra la lista de espera
                System.out.println("");
                System.out.println("---LISTA DE ESPERA---");

                for (int i = 0; i < listaDeEspera.length; i++) { // Ciclo que muestra la lista de espera
                    boolean mostrar = true;
                    if (mostrar) {
                        if (listaDeEspera[i] != null) {
                            String datosCliente = listaDeEspera[i].getNombre() + ", cliente "
                                    + listaDeEspera[i].getTipoUsuario() + " con "
                                    + listaDeEspera[i].getCantidadVisitas() + " visitas.";
                            System.out.println(i + 1 + ". " + datosCliente);
                            mostrar = false;
                        }
                    }
                }

                // Muestra la lista de habitaciones
                System.out.println("");
                System.out.println("---LISTA DE HABITACIONES---");

                for (int i = 0; i < listaDeHabitaciones.length; i++) { // Ciclo que muestra las habitaciones
                    boolean mostrar = true;
                    if (mostrar) {
                        if (listaDeHabitaciones[i] != null && listaDeHabitaciones[i].getCapacidadMax() > 0) {
                            String datosHabitacion = ". No. " + listaDeHabitaciones[i].getNumero() + ", tipo: "
                                    + listaDeHabitaciones[i].getTipoHabitacion()
                                    + ", con capacidad para " + listaDeHabitaciones[i].getCapacidadMax()
                                    + " y con un precio de: Q" + listaDeHabitaciones[i].getPrecio();
                            System.out.println(i + 1 + datosHabitacion);
                            mostrar = false;
                        }
                    }
                }

                // Pide los datos del cliente al que se va a asignar
                System.out.println("");
                System.out.print("¿A qué cliente desea asignar? Ingrese el nombre: ");
                String clienteActual = input.nextLine();

                System.out.print("¿En qué habitación será asignado? Ingrese el número: ");
                String habitacionSeleccionada = input.nextLine();

                // Valida los datos del cliente que se va a asignar
                try {
                    int hab = Integer.parseInt(habitacionSeleccionada);
                    boolean buscando = true;
                    boolean buscandoHab = true;

                    // Verificar que se encuentre en la lista de espera
                    if (buscando) {
                        for (int i = 0; i < listaDeEspera.length; i++) { // Ciclo que busca al cliente
                            if (buscando) {
                                if (listaDeEspera[i].getNombre().equals(clienteActual)) { // Si lo encuentra

                                    // Verificar que la habitación este en la lista de habitaciones
                                    if (buscandoHab) {
                                        for (i = 0; i < listaDeHabitaciones.length; i++) { // Ciclo que busca la
                                                                                           // habitación
                                            if (buscandoHab) {
                                                if (listaDeHabitaciones[i].getNumero() == hab) { // Si la encuentra
                                                    buscandoHab = false;
                                                    validado = true;
                                                }
                                            }
                                        }
                                    }
                                    buscando = false;
                                }
                            }
                        }
                    }

                    if (validado) { // Si se pasaron todas las validaciones lógicas
                        boolean isClienteActual = false;
                        boolean isHabActual = false;

                        for (int i = 0; i < listaDeEspera.length; i++) {
                            if (!isClienteActual) {
                                if (listaDeEspera[i].getNombre().equals(clienteActual)) {
                                    for (int j = 0; j < listaDeHabitaciones.length; j++) {
                                        if (!isHabActual) {
                                            if (listaDeHabitaciones[j].getNumero() == hab) { // Asignar el cliente a la
                                                                                             // habitación
                                                agregarClienteHabitacion(listaDeEspera[i], listaDeHabitaciones[j]);
                                                isHabActual = true;
                                            }
                                        }
                                    }

                                    isClienteActual = true;
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Ingreso de datos inválido. Verifique los datos ingresados");
                }

                asignacion = false; // Rompe el ciclo
            }
        }
    }

    /**
     * @param usuario
     * @param habitacion
     */
    public void agregarClienteHabitacion(Usuario usuario, Habitacion habitacion) {

        // Validaciones del usuario
        boolean isAptoParaReservar = false;

        // Validar que haya espacio en la habitación
        if (habitacion.getCapacidadMax() != 0) {

            switch (usuario.getTipoUsuario()) { // Control flow del tipo de cliente

                case "Frecuente":
                    if (habitacion.getTipoHabitacion().equals("Estandar")
                            || habitacion.getTipoHabitacion().equals("Deluxe")) {
                        isAptoParaReservar = true;
                    } else {
                        System.out.println("Los clientes frecuentes no pueden ser asignados a habitaciones Suite");
                    }
                    break;

                case "Regular":
                    if (habitacion.getTipoHabitacion().equals("Estandar")) {
                        isAptoParaReservar = true;
                    } else {
                        System.out.println("Los clientes regulares solo pueden reservar habitaciones Estándar");
                    }
                    break;

                case "VIP":
                    isAptoParaReservar = true;

                default:
                    break;
            }
        }

        if (isAptoParaReservar) { // Si el cliente es apto para reservar

            // Agregar el cliente a la lista de clientes de una habitación
            boolean añadido = false;

            for (int i = 0; i < habitacion.getListaClientes().length; i++) {
                if (!añadido && habitacion.getCapacidadMax() > 0) {
                    if (habitacion.getListaClientes()[i] == null) {
                        habitacion.getListaClientes()[i] = usuario;
                        habitacion.setCapacidadMax(habitacion.getCapacidadMax() - 1);
                        añadido = true;
                    }
                }
            }

            // Eliminar al cliente de la lista de espera
            boolean eliminado = false;

            for (int i = 0; i < listaDeEspera.length; i++) {
                if (!eliminado) {
                    if (listaDeEspera[i].getNombre().equals(usuario.getNombre())) {
                        listaDeEspera[i] = null;
                        eliminado = true;
                    }
                }
            }

            System.out
                    .println("El cliente " + usuario.getNombre() + " será asignado a la No. " + habitacion.getNumero());
        }

    }
}
