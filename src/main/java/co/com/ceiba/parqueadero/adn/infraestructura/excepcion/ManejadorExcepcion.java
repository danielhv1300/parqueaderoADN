package co.com.ceiba.parqueadero.adn.infraestructura.excepcion;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionCampoObligatorio;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionImposibleActualizar;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionPlacaVehiculoDuplicada;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionSinCupoDisponible;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionTipoVehiculo;

@ControllerAdvice
public class ManejadorExcepcion extends ResponseEntityExceptionHandler {
	
	private static final ConcurrentHashMap<String, Integer> ESTADO_PETICION = new ConcurrentHashMap<>();

	
	public ManejadorExcepcion() {
		ESTADO_PETICION.put(ExcepcionCampoObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionPlacaVehiculoDuplicada.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionRestriccionPlaca.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionTipoVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionSinCupoDisponible.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionNoExisteRegistroVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionImposibleActualizar.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	}
	
}
