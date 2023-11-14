import java.util.Date;

public class Reserva implements Usuario {
    private String usuarioNombre;
    private Date fechaViaje;
    private boolean idaYVuelta;
    private int cantidadBoletos;
    private String aerolinea;
    private String tipoCliente;

    // Constructor
    public Reserva(String usuarioNombre, Date fechaViaje, boolean idaYVuelta, int cantidadBoletos, String aerolinea) {
        this.usuarioNombre = usuarioNombre;
        this.fechaViaje = fechaViaje;
        this.idaYVuelta = idaYVuelta;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.tipoCliente = "Regular";
    }

    @Override
    public void realizarReserva() {
        System.out.println("Realizando reserva para: " + usuarioNombre);
        mostrarInfoReserva();
    }

    @Override
    public void generarConfirmacion() {
        System.out.println("Función no disponible para Reserva");
    }

    @Override
    public void modificarPerfil() {
        System.out.println("Función no disponible para Reserva");
    }
    public String getTipoCliente() {
        return tipoCliente;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public boolean isIdaYVuelta() {
        return idaYVuelta;
    }

    public void setIdaYVuelta(boolean idaYVuelta) {
        this.idaYVuelta = idaYVuelta;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNombreUsuario() {
        return this.usuarioNombre;  
    }
    public void mostrarInfoReserva() {
        System.out.println("Reserva para: " + usuarioNombre);
        System.out.println("Fecha de viaje: " + fechaViaje);
        System.out.println("Tipo de vuelo: " + (idaYVuelta ? "Ida y vuelta" : "Solo ida"));
        System.out.println("Cantidad de boletos: " + cantidadBoletos);
        System.out.println("Aerolínea: " + aerolinea);
    }
}
