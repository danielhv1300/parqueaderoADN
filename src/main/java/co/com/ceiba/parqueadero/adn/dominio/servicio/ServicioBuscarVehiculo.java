package co.com.ceiba.parqueadero.adn.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;

public class ServicioBuscarVehiculo {

private VehiculoRepositorio vehiculoRepositorio;
	
	public ServicioBuscarVehiculo(VehiculoRepositorio vehiculoRepositorio){
        this.vehiculoRepositorio = vehiculoRepositorio;
    }
	
	public List<Vehiculo> buscar(){
        return this.vehiculoRepositorio.buscarRegistroVehiculos();
    }
}
