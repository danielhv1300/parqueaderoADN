package co.com.ceiba.parqueadero.adn.aplicacion.consulta;

import java.util.List;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioBuscarVehiculo;

public class ListaVehiculoHandler {

	private final ServicioBuscarVehiculo buscarServicio;

	public ListaVehiculoHandler(ServicioBuscarVehiculo servicio) {
		this.buscarServicio = servicio;
	}

	public List<Vehiculo> listaVehiculos() {
		return this.buscarServicio.buscar();
	}
}
