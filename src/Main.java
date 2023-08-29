/*
 * @author: Nils Muralles Morales
 * @version: 1.0
 * @since: 24/8/2023
 * Clase Main que contiene el Driver Program
 */

// Importar las clases necesarias
import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    // Clase Main
    public static void main(String[] args) {

        // Atributos y objetos
        Scanner input = new Scanner(System.in);
        Hotel hotel = new Hotel(50, 100);

        // Primeras tres habitaciones
        hotel.habitacionesDefault();

        // Menú principal del Driver Program
        boolean seguir = true;
        while (seguir) {
            System.out.println("");
            System.out.println("---BIENVENIDO---");
            System.out.println("1. Recibir huésped");
            System.out.println("2. Asignar cliente a habitación");
            System.out.println("3. Crear una habitación");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción válida: ");
            String opcion = input.nextLine();

            // Validar que la opción seleccionada sea un entero
            try {
                int op = Integer.parseInt(opcion);

                // Opciones del menú
                switch (op) {
                    case 1: // Ingresar los datos del cliente
                        hotel.recibirHuesped();
                        break;
                    case 2: // Asignar huésped a habitación
                        hotel.asignarCliente();
                        break;
                    case 3: // Crear una habitación
                        hotel.crearHabitacion();
                        break;
                    case 4: // Salir
                        seguir = false;
                        break;
                    default: // Si se selecciona una opción válida
                        System.out.println("Seleccione una opción válida");
                        break;
                }

            } catch (Exception e) { // Si se ingresa algo que no sea un integer
                System.out.println("Ingreso inváliido. Por favor ingrese un número");
            }
        }
    }
}
