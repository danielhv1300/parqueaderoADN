package co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.VehiculoComando;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioCrearVehiculo;

public class ManejadorIngresoVehiculo {

	private final ServicioCrearVehiculo crearVehiculoServicio;

	public ManejadorIngresoVehiculo(ServicioCrearVehiculo servicio) {
		this.crearVehiculoServicio = servicio;
	}

	public void crear(VehiculoComando parqueaderoComando) {
		this.crearVehiculoServicio.crear(new Vehiculo(parqueaderoComando.getId(), parqueaderoComando.getPlaca(),
				parqueaderoComando.getTipoVehiculo(), parqueaderoComando.getCilindraje(), new Date(),
				parqueaderoComando.getFechaSalida(), parqueaderoComando.getTotal()));
	}

}
