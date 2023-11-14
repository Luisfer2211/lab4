import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sistema {
    private List<Usuario> usuarios;
    private List<Reserva> reservas;
    private List<Confirmacion> confirmaciones;

    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.confirmaciones = new ArrayList<>();
    }

    // Métodos para gestionar usuarios
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario obtenerUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Confirmacion && ((Confirmacion) usuario).getUsuarioNombre().equals(nombreUsuario)) {
                return usuario;
            } else if (usuario instanceof Reserva && ((Reserva) usuario).getUsuarioNombre().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public Reserva obtenerReserva(String nombreUsuario) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuarioNombre().equals(nombreUsuario)) {
                return reserva;
            }
        }
        return null;
    }

    public void agregarConfirmacion(Confirmacion confirmacion) {
        confirmaciones.add(confirmacion);
    }

    public Confirmacion obtenerConfirmacion(String nombreUsuario) {
        for (Confirmacion confirmacion : confirmaciones) {
            if (confirmacion.getUsuarioNombre().equals(nombreUsuario)) {
                return confirmacion;
            }
        }
        return null;
    }
    public boolean esUsuarioPremium(String nombreUsuario) {
        String csvFile = "usuarios.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] usuario = line.split(cvsSplitBy);
    
                if (usuario.length == 5 && usuario[1].equals(nombreUsuario)) {
                    // Verificar si el usuario tiene un plan premium (columna 3)
                    return "VIP".equals(usuario[3]);
                }
            }
            System.out.println("Usuario no encontrado en el archivo de usuarios.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios.");
            e.printStackTrace();
        }
        return false; 
    }
}
