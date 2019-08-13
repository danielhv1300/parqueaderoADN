package co.com.ceiba.parqueadero.adn.dominio.excepcion;

public class ExcepcionImposibleActualizar extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionImposibleActualizar(String mensaje) {
		super(mensaje);
	}

}
