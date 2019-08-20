package co.com.ceiba.parqueadero.adn.dominio.modelo;

import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionCampoObligatorio;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionTipoVehiculo;

public final class ValidadorVehiculo {

	private ValidadorVehiculo() {
	}

	public static void validarDatoObligatorio(Object dato, String mensaje){
		if (dato == null || dato.equals(Constantes.VACIO)) {
			throw new ExcepcionCampoObligatorio(mensaje);
		}
	}


	public static void validarCilindrajeObligatorio(int dato, String mensaje){
		if (dato == 0) {
			throw new ExcepcionCampoObligatorio(mensaje);
		}
	}

}
