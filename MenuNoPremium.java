import java.util.Scanner;

public class MenuNoPremium {

    private Scanner scanner;

    // Constructor
    public MenuNoPremium(Sistema sistema) {
        this.scanner = new Scanner(System.in);
    }

    // Método principal para mostrar el menú no premium
    public void mostrarMenuNoPremium(Usuario usuario) {
        int opcion;
        do {
            mostrarOpcionesNoPremium();
            opcion = obtenerOpcion();
            procesarOpcionNoPremium(opcion, usuario);
        } while (opcion != 0);
    }

    // Método para mostrar las opciones no premium
    private void mostrarOpcionesNoPremium() {
        System.out.println("=== Menú No Premium ===");
        System.out.println("1. Modificar tipo de cliente");
        System.out.println("2. Aplicar cupón de descuento");
        System.out.println("3. Cambiar contraseña");
        System.out.println("0. Volver al menú principal");
    }

    // Método para obtener la opción del usuario
    private int obtenerOpcion() {
        System.out.print("Ingrese su opción: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // Método para procesar la opción no premium
    private void procesarOpcionNoPremium(int opcion, Usuario usuario) {
        switch (opcion) {
            case 1:
                modificarTipoCliente(usuario);
                break;
            case 2:
                aplicarCuponDescuento(usuario);
                break;
            case 3:
                cambiarContrasena(usuario);
                break;
            case 0:
                System.out.println("Volviendo al menú principal.");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }

    // Métodos específicos para las opciones no premium
    private void modificarTipoCliente(Usuario usuario) {
        System.out.println("=== Modificar Tipo de Cliente ===");
    
        if (usuario instanceof Reserva) {
            Reserva reservaUsuario = (Reserva) usuario;
            System.out.println("Tipo de Cliente actual: " + reservaUsuario.getTipoCliente());
    
            System.out.println("Seleccione el nuevo Tipo de Cliente:");
            System.out.println("1. Regular");
            System.out.println("2. VIP");
            int opcion = obtenerOpcion();
    
            switch (opcion) {
                case 1:
                    reservaUsuario.setTipoCliente("Regular");
                    System.out.println("Tipo de Cliente modificado a Regular.");
                    break;
                case 2:
                    System.out.println("La opción VIP requiere una suscripción premium. Próximamente.");
                    break;
                default:
                    System.out.println("Opción no válida. No se realizaron cambios en el Tipo de Cliente.");
            }
        } else {
            System.out.println("Error al modificar el Tipo de Cliente. Usuario no válido.");
        }
    }
    

    private void aplicarCuponDescuento(Usuario usuario) {
        System.out.println("Función no disponible para usuarios no premium. Próximamente.");
    }

    private void cambiarContrasena(Usuario usuario) {
        System.out.println("Función no disponible para usuarios no premium. Próximamente.");
    }
}
