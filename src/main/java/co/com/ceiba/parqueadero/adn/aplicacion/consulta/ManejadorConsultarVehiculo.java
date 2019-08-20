package co.com.ceiba.parqueadero.adn.aplicacion.consulta;

import java.util.List;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;

public class ManejadorConsultarVehiculo {
	private VehiculoRepositorio vehiculoRepositorio;

	public ManejadorConsultarVehiculo(VehiculoRepositorio vehiculoRepositorio) {
		this.vehiculoRepositorio = vehiculoRepositorio;
	}

	public List<Vehiculo> buscar() {
		return this.vehiculoRepositorio.buscarRegistroVehiculos();
	}

}
