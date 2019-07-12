package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.excepcion;


import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionCampoObligatorio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionImposibleActualizar;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionPlacaVehiculoDuplicada;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionSinCupoDisponible;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionTipoVehiculo;

@ControllerAdvice
public class ManejadorExcepcion {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorExcepcion.class);
    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrio un error, favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorExcepcion(){
        CODIGOS_ESTADO.put(ExcepcionCampoObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionPlacaVehiculoDuplicada.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionRestriccionPlaca.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionTipoVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionSinCupoDisponible.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionNoExisteRegistroVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionImposibleActualizar.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcepcionInfraestructura> handleAllExceptions(ExcepcionInfraestructura excepcion) {
        ResponseEntity<ExcepcionInfraestructura> response;

        String nombre = excepcion.getClass().getSimpleName();
        String mensaje = excepcion.getMensaje();
        Integer code = CODIGOS_ESTADO.get(nombre);

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
