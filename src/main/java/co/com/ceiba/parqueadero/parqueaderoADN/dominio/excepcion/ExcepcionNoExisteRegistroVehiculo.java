package co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion;

public class ExcepcionNoExisteRegistroVehiculo extends RuntimeException {

	private static final long serialVersionUID = -1775402230956286492L;

	public ExcepcionNoExisteRegistroVehiculo(String mensaje) {
        super(mensaje);
    }

}
