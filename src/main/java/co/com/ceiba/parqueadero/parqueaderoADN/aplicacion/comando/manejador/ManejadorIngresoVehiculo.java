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

	public void crear(VehiculoComando vehiculoComando) {
		this.crearVehiculoServicio.crear(new Vehiculo(vehiculoComando.getId(), vehiculoComando.getPlaca(),
				vehiculoComando.getTipoVehiculo(), vehiculoComando.getCilindraje(), vehiculoComando.getFechaIngreso(),
				vehiculoComando.getFechaSalida(), vehiculoComando.getTotal()));
	}

}
