package co.com.ceiba.parqueadero.adn.dominio.excepcion;

public class ExcepcionSinCupoDisponible extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionSinCupoDisponible(String mensaje) {
        super(mensaje);
    }

}
