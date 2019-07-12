package co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.VehiculoComando;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.CrearVehiculoParqueaderoServicio;

public class ManejadorEntradaVehiculo {

	private final CrearVehiculoParqueaderoServicio crearVehiculoServicio;

	public ManejadorEntradaVehiculo(CrearVehiculoParqueaderoServicio servicio) {
		this.crearVehiculoServicio = servicio;
	}

	public void crear(VehiculoComando parqueaderoComando) {
		this.crearVehiculoServicio.crear(new Vehiculo(parqueaderoComando.getId(), parqueaderoComando.getPlaca(),
				parqueaderoComando.getTipoVehiculo(), parqueaderoComando.getCilindraje(), new Date(),
				parqueaderoComando.getFechaSalida(), parqueaderoComando.getTotal()));
	}

}
