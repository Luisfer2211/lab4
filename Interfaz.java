import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Interfaz {

    private Sistema sistema;
    private Scanner scanner;
    private Usuario usuarioAutenticado; 

    // Constructor
    public Interfaz(Sistema sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    // Método principal para iniciar la interfaz
    public void iniciarInterfaz() {
        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

     // Método para mostrar el menú
     private void mostrarMenu() {
        System.out.println("=== Menú ===");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Crear nuevo usuario");
        System.out.println("0. Salir");
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

    // Método para procesar la opción del usuario
    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                crearNuevoUsuario();
                break;
            case 0:
                System.out.println("Saliendo del sistema. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }


    // Método para iniciar sesión
    private void iniciarSesion() {
        System.out.println("=== Iniciar Sesión ===");
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.next();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.next();
    
        if (Autenticador.autenticarUsuario(nombreUsuario, contrasena)) {
            usuarioAutenticado = sistema.obtenerUsuario(nombreUsuario);
            if (usuarioAutenticado != null) {
                System.out.println("¡Autenticación exitosa!");
                mostrarMenuUsuario(usuarioAutenticado); 
            } else {
                System.out.println("Error al obtener información del usuario.");
            }
        } else {
            System.out.println("Credenciales inválidas. Verifique su nombre de usuario y contraseña.");
        }
    }
    
    
    // Método para crear un nuevo usuario
    private void crearNuevoUsuario() {
        System.out.println("=== Crear Nuevo Usuario ===");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.next();
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.next();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.next();
        System.out.print("Ingrese su plan (base o premium): ");
        String plan = scanner.next();
        System.out.print("Ingrese su fecha de nacimiento: ");
        String fechaNacimiento = scanner.next();
    
        // Verificar si el usuario ya existe
        if (sistema.obtenerUsuario(nombreUsuario) == null) {
            // Crear usuario
            Usuario usuario = new Reserva(nombreUsuario, null, false, 0, null); 
    
            // Agregar usuario al sistema
            sistema.agregarUsuario(usuario);
    
            // Agregar usuario al archivo CSV
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.csv", true))) {
                writer.write(nombre + "," + nombreUsuario + "," + contrasena + "," + plan + "," + fechaNacimiento);
                writer.newLine();
                System.out.println("Usuario creado exitosamente. ¡Bienvenido, " + nombreUsuario + "!");
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo de usuarios.");
                e.printStackTrace();
            }
        } else {
            System.out.println("El nombre de usuario ya está en uso. Por favor, elija otro nombre de usuario.");
        }
    }

    private void mostrarMenuUsuario(Usuario usuario) {
        String nombreUsuario = obtenerNombreUsuario(usuario);
        System.out.println("¡Bienvenido, " + nombreUsuario + "!");
        int opcion;
        do {
            mostrarMenuOpcionesUsuario(usuario);
            opcion = obtenerOpcion();
            procesarOpcionUsuario(opcion, usuario);
        } while (opcion != 0);
    }
    private String obtenerNombreUsuario(Usuario usuario) {
        if (usuario instanceof Reserva) {
            return ((Reserva) usuario).getUsuarioNombre();
        } else if (usuario instanceof Confirmacion) {
            // Ajusta según la implementación de Confirmacion
            return ((Confirmacion) usuario).getUsuarioNombre();
        } else {
            // Lógica para otras implementaciones de Usuario
            return "Nombre de usuario no disponible";
        }
    }
    
    // Métodos para mostrar el menú de opciones y procesar la opción del usuario
    private void mostrarMenuOpcionesUsuario(Usuario usuario) {
        System.out.println("=== Menú de Opciones ===");
        System.out.println("1. Realizar reserva");
        System.out.println("2. Generar confirmación");
        System.out.println("3. Modificar perfil");
        System.out.println("0. Cerrar sesión");
    }
    
    private void procesarOpcionUsuario(int opcion, Usuario usuario) {
        switch (opcion) {
            case 1:
                usuario.realizarReserva();
                break;
            case 2:
                usuario.generarConfirmacion();
                break;
            case 3:
                usuario.modificarPerfil();
                break;
            case 0:
                System.out.println("Cerrando sesión. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
}
public Usuario getUsuarioAutenticado() {
    return usuarioAutenticado;
}
}