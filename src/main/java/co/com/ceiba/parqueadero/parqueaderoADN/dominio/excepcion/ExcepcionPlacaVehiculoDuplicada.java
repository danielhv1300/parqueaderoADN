package co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion;

public class ExcepcionPlacaVehiculoDuplicada extends RuntimeException {

	private static final long serialVersionUID = 4946499836914146493L;

	public ExcepcionPlacaVehiculoDuplicada(String mensaje) {
        super(mensaje);
    }

}
