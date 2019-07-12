package co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion;

public class ExcepcionRestriccionPlaca extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionRestriccionPlaca(String mensaje) {
        super(mensaje);
    }

}
