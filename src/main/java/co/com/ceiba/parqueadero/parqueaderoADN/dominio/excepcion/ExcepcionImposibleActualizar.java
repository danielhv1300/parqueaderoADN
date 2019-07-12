package co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion;

public class ExcepcionImposibleActualizar extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionImposibleActualizar(String mensaje) {
        super(mensaje);
    }

}
