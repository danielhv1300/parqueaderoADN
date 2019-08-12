package co.com.ceiba.parqueadero.adn.infraestructura.adaptador;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.adn.infraestructura.adaptador.entidad.VehiculoEntidad;
import co.com.ceiba.parqueadero.adn.infraestructura.adaptador.repositorio.RepositorioVehiculoJPA;
import co.com.ceiba.parqueadero.adn.infraestructura.mapeador.VehiculoMapeador;

@Repository
public class RepositorioVehiculoH2Adaptador implements VehiculoRepositorio {

	private RepositorioVehiculoJPA repositorioVehiculoJPA;
	

	public RepositorioVehiculoH2Adaptador(RepositorioVehiculoJPA vehiculoRepositorioJPA) {
		this.repositorioVehiculoJPA = vehiculoRepositorioJPA;
	}

	@Override
	public Vehiculo crear(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = repositorioVehiculoJPA.save(VehiculoMapeador.convertirAEntidad(vehiculo));
		return VehiculoMapeador.convertirADominio(vehiculoEntidad);
	}

	@Override
	public int cuposPorTipoVehiculo(String tipoVehiculo) {
		return repositorioVehiculoJPA.cuposPorTipoVehiculo(tipoVehiculo);
	}

	@Override
	public boolean existe(String placa) {
		return repositorioVehiculoJPA.existeVehiculo(placa);
	}

	@Override
	public List<Vehiculo> buscarRegistroVehiculos() {
		List<VehiculoEntidad> listaVehiculoEntidad = repositorioVehiculoJPA.buscarRegistroVehiculos();
		return listaVehiculoEntidad.stream().map(VehiculoMapeador::convertirADominio).collect(Collectors.toList());
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		VehiculoEntidad vehiculoEntidad = repositorioVehiculoJPA.buscarPorPlaca(placa);
		return VehiculoMapeador.convertirADominio(vehiculoEntidad);
	}

}
