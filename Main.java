public class Main {

    public static void main(String[] args) {
        Sistema sistema = new Sistema();  
        Interfaz interfaz = new Interfaz(sistema);
        MenuNoPremium menuNoPremium = new MenuNoPremium(sistema);

        interfaz.iniciarInterfaz(); 

        Usuario usuario = interfaz.getUsuarioAutenticado();
        if (usuario != null) {
            String nombreUsuario = obtenerNombreUsuario(usuario);
            boolean esPremium = sistema.esUsuarioPremium(nombreUsuario);

            if (!esPremium) {
                menuNoPremium.mostrarMenuNoPremium(usuario);
            } else {
                System.out.println("Menú Premium: Próximamente");
            }
        } else {
            System.out.println("Cierre de la aplicación. ¡Hasta luego!");
        }
    }

    private static String obtenerNombreUsuario(Usuario usuario) {
        return usuario != null ? ((Reserva) usuario).getNombreUsuario() : "";
    }
}
