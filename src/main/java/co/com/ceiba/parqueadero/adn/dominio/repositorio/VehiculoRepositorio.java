package co.com.ceiba.parqueadero.adn.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;

public interface VehiculoRepositorio {

//Registra el vehiculo en el parqueadero
	/**
	 * dfdfdfdfd
	 * @param vehiculo
	 * @return
	 */
	public Vehiculo crearVehiculo(Vehiculo vehiculo);

//Cupos disponibles por tipo de vehiculo

	public int cuposPorTipoVehiculo(String tipoVehiculo);

//Muestra si el vehiculo ya ha sido registrado 

	public boolean existeVehiculo(String placa);

//Lista los vehiculos registrados

	public List<Vehiculo> buscarRegistroVehiculos();

//Retorna vehiculo que aun se encuentra en parqueadero por placa

	public Vehiculo buscarPorPlaca(String placa);
}
