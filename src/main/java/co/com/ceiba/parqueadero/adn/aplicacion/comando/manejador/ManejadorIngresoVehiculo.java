package co.com.ceiba.parqueadero.adn.aplicacion.comando.manejador;



import co.com.ceiba.parqueadero.adn.aplicacion.comando.VehiculoComando;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioCrearVehiculo;

public class ManejadorIngresoVehiculo {

	private final ServicioCrearVehiculo crearVehiculoServicio;

	public ManejadorIngresoVehiculo(ServicioCrearVehiculo servicio) {
		this.crearVehiculoServicio = servicio;
	}

	public void crear(VehiculoComando vehiculoComando) {
		this.crearVehiculoServicio.crear(new Vehiculo(vehiculoComando.getId(), vehiculoComando.getPlaca(),
				vehiculoComando.getTipoVehiculo(), vehiculoComando.getCilindraje(), 
				vehiculoComando.getValor()));
	}

}
