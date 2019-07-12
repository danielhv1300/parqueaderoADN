package co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionPlacaVehiculoDuplicada;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionSinCupoDisponible;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;

public class CrearVehiculoParqueaderoServicio {

	private VehiculoRepositorio parqueaderoRepositorio;
	
	public CrearVehiculoParqueaderoServicio(VehiculoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public Vehiculo crear(Vehiculo parqueadero){
		validarRegistro(parqueadero.getPlaca());
		validarCupo(parqueadero.getTipoVehiculo());
		validarEntrada(parqueadero.getPlaca(),parqueadero.getFechaIngreso());
        return this.parqueaderoRepositorio.crearVehiculo(parqueadero);
    }
	
	private void validarRegistro(String placa) {
        boolean existe = parqueaderoRepositorio.existeVehiculo(placa);
        if(existe) {
            throw new ExcepcionPlacaVehiculoDuplicada(Vehiculo.MENSAJE_VEHICULO_YA_EXISTE_EN_PARQUEADERO);
        }
    }
	
	private void validarCupo(String tipoVehiculo) {
		if(tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO) && 
		   parqueaderoRepositorio.cuposPorTipoVehiculo(tipoVehiculo) == Constantes.CAPACIDAD_MAXIMA_MOTOS) {
			throw new ExcepcionSinCupoDisponible(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES);
		}
		if(tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_CARRO) && 
		   parqueaderoRepositorio.cuposPorTipoVehiculo(tipoVehiculo) == Constantes.CAPACIDAD_MAXIMA_CARROS) {
			throw new ExcepcionSinCupoDisponible(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES);
		}
    }
	
	private void validarEntrada(String placa, Date fechaIngreso) {
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.setTimeInMillis(fechaIngreso.getTime());
		int day = fechaActual.get(Calendar.DAY_OF_WEEK);
		if (placa.startsWith(Vehiculo.LETRA_DE_RESTRICCION_POR_PLACA) || placa.startsWith("a") && (day != Calendar.MONDAY || day != Calendar.SUNDAY)) {
			throw new ExcepcionRestriccionPlaca(Vehiculo.MENSAJE_RESTRICCION_POR_PLACA);
		}
    }
}
