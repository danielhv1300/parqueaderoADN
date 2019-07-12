package co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion;

public class ExcepcionSinCupoDisponible extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionSinCupoDisponible(String mensaje) {
        super(mensaje);
    }

}
