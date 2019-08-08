package co.com.ceiba.parqueadero.adn.dominio.excepcion;

public class ExcepcionNoExisteRegistroVehiculo extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionNoExisteRegistroVehiculo(String mensaje) {
        super(mensaje);
    }

}
