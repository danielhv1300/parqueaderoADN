package co.com.ceiba.parqueadero.adn.aplicacion.consulta;

import java.util.List;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;

public class ManejadorConsulta {
	private VehiculoRepositorio vehiculoRepositorio;

	public ManejadorConsulta(VehiculoRepositorio vehiculoRepositorio) {
		this.vehiculoRepositorio = vehiculoRepositorio;
	}

	public List<Vehiculo> buscar() {
		return this.vehiculoRepositorio.buscarRegistroVehiculos();
	}

}
