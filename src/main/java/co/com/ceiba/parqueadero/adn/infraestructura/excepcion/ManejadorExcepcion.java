package co.com.ceiba.parqueadero.adn.infraestructura.excepcion;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorExcepcion.class);
	private static final ConcurrentHashMap<String, Integer> ESTADO_PETICION = new ConcurrentHashMap<>();
	private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ha occurrido un error, contate al administrador";
	
	public ManejadorExcepcion() {
		ESTADO_PETICION.put(ExcepcionCampoObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionPlacaVehiculoDuplicada.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionRestriccionPlaca.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionTipoVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionSinCupoDisponible.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionNoExisteRegistroVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
		ESTADO_PETICION.put(ExcepcionImposibleActualizar.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
	}
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcepcionInfraestructura> handleAllExceptions(ExcepcionInfraestructura excepcion) {
        ResponseEntity<ExcepcionInfraestructura> response;

        String nombre = excepcion.getClass().getSimpleName();
        String mensaje = excepcion.getMensaje();
        Integer code = ESTADO_PETICION.get(nombre);

        if (code != null) {
        	ExcepcionInfraestructura error = new ExcepcionInfraestructura(nombre, mensaje);
            response = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        } else {
            LOGGER .error(nombre, excepcion);
            ExcepcionInfraestructura error = new ExcepcionInfraestructura(nombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            response = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

}
