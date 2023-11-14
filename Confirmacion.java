public class Confirmacion implements Usuario {
    private String usuarioNombre;
    private String numeroTarjeta;
    private int cantidadCuotas;
    private String claseVuelo;
    private int cantidadMaletas;
    private String cuponesAplicados;

    // Constructor
    public Confirmacion(String usuarioNombre, String numeroTarjeta, int cantidadCuotas, String claseVuelo, int cantidadMaletas, String cuponesAplicados) {
        this.usuarioNombre = usuarioNombre;
        this.numeroTarjeta = numeroTarjeta;
        this.cantidadCuotas = cantidadCuotas;
        this.claseVuelo = claseVuelo;
        this.cantidadMaletas = cantidadMaletas;
        this.cuponesAplicados = cuponesAplicados;
    }

    @Override
    public void realizarReserva() {
        System.out.println("Función no disponible para Confirmación");
    }

    @Override
    public void generarConfirmacion() {
        System.out.println("Confirmación generada para: " + usuarioNombre);
        System.out.println("Número de tarjeta: " + numeroTarjeta);
        System.out.println("Cuotas: " + cantidadCuotas);
        System.out.println("Clase de vuelo: " + claseVuelo);
        System.out.println("Cantidad de maletas: " + cantidadMaletas);
        System.out.println("Cupones aplicados: " + cuponesAplicados);
    }

    @Override
    public void modificarPerfil() {
        System.out.println("Función no disponible para Confirmación");
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }
    
    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public int getCantidadCuotas() {
        return cantidadCuotas;
    }
    
    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }
    
    public String getClaseVuelo() {
        return claseVuelo;
    }
    
    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }
    
    public int getCantidadMaletas() {
        return cantidadMaletas;
    }
    
    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }
    
    public String getCuponesAplicados() {
        return cuponesAplicados;
    }
    
    public void setCuponesAplicados(String cuponesAplicados) {
        this.cuponesAplicados = cuponesAplicados;
    }
    
}
