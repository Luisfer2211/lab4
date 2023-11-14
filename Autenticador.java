import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Autenticador {

  
    public static boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        String csvFile = "usuarios.csv";
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] usuario = line.split(cvsSplitBy);

                if (usuario.length == 5 && usuario[1].equals(nombreUsuario) && usuario[2].equals(contrasena)) {
                    System.out.println("¡Autenticación exitosa!");
                    return true;
                }
            }
            System.out.println("Credenciales inválidas. Verifique su nombre de usuario y contraseña.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios.");
            e.printStackTrace();
        }
        return false;
    }
}
