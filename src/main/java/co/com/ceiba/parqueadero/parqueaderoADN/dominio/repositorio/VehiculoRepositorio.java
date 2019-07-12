package co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;

public interface VehiculoRepositorio {	
	
	
//Registra el vehiculo en el parqueadero
     
	public Vehiculo crearVehiculo(Vehiculo parqueadero);
	
	
//Cupos disponibles por tipo de vehiculo
     
	public int cuposPorTipoVehiculo(String tipoVehiculo);
		
	
//Muestra si el vehiculo ya ha sido registrado 

	public boolean existeVehiculo(String placa);
	
//Lista los vehiculos registrados
    
	public List<Vehiculo> buscarRegistroVehiculos();
	

//Retorna vehiculo que aún se encuentra en parqueadero por placa

	public Vehiculo buscarPorPlaca(String placa);
}
