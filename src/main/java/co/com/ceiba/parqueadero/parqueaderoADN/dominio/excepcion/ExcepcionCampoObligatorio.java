package co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion;

public class ExcepcionCampoObligatorio extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionCampoObligatorio(String mensaje) {
        super(mensaje);
    }
}

