package co.com.ceiba.parqueadero.adn.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;

public interface VehiculoRepositorio {

	/**
	 * Registra el vehiculo en el parqueadero
	 * 
	 * @param vehiculo
	 * @return mapeador.convertirADominio(vehiculoEntidad)
	 */
	public Vehiculo crear(Vehiculo vehiculo);

	/**
	 * Cupos disponibles por tipo de vehiculo
	 * 
	 * @param tipoVehiculo
	 * @return repositorioVehiculoJPA.cuposPorTipoVehiculo(tipoVehiculo)
	 */

	public int cuposPorTipoVehiculo(String tipoVehiculo);

	public boolean existe(String placa);

	/**
	 * Lista los vehiculos registrados
	 */

	public List<Vehiculo> buscarRegistroVehiculos();

	/**
	 * Retorna vehiculo que aun se encuentra en parqueadero por placa
	 * 
	 * @param placa
	 * @return mapeador.convertirADominio(vehiculoEntidad)
	 */

	public Vehiculo buscarPorPlaca(String placa);
}
