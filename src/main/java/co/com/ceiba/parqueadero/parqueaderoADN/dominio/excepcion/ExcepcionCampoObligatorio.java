package co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion;

public class ExcepcionCampoObligatorio extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionCampoObligatorio(String mensaje) {
        super(mensaje);
    }
}

