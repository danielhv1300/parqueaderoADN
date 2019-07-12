package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.excepcion;

public class ExcepcionInfraestructura {
    private String nombre;
    private String mensaje;

    public ExcepcionInfraestructura(String nombre, String mensaje) {
        this.nombre = nombre;
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensaje() {
        return mensaje;
    }
}
