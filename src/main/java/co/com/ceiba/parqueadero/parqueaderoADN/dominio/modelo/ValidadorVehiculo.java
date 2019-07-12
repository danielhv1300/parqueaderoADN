package co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionCampoObligatorio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionTipoVehiculo;

public final class ValidadorVehiculo {

	private ValidadorVehiculo() {
	}
    
    public static void validarDatoObligatorio(Object dato, String mensaje){
        if(dato == null || dato.equals(Constantes.VACIO)) {
            throw new ExcepcionCampoObligatorio(mensaje);
        }
    }
    
    public static void validarTipoVehiculo(Object dato, String mensaje) {
	    if(!dato.equals(Constantes.TIPO_VEHICULO_CARRO) && !dato.equals(Constantes.TIPO_VEHICULO_MOTO)) {
	        throw new ExcepcionTipoVehiculo(mensaje);
	    }
    }

}
