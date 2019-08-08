package co.com.ceiba.parqueadero.adn.dominio.excepcion;

public class ExcepcionPlacaVehiculoDuplicada extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionPlacaVehiculoDuplicada(String mensaje) {
        super(mensaje);
    }

}
