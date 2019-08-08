package co.com.ceiba.parqueadero.adn.dominio.excepcion;

public class ExcepcionCampoObligatorio extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionCampoObligatorio(String mensaje) {
        super(mensaje);
    }
}

