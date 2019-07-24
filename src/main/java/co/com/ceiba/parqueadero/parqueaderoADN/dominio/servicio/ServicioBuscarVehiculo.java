package co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;

public class ServicioBuscarVehiculo {

private VehiculoRepositorio vehiculoRepositorio;
	
	public ServicioBuscarVehiculo(VehiculoRepositorio parqueaderoRepositorio){
        this.vehiculoRepositorio = parqueaderoRepositorio;
    }
	
	public List<Vehiculo> buscar(){
        return this.vehiculoRepositorio.buscarRegistroVehiculos();
    }
}
