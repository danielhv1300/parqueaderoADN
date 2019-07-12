package co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio;

import java.util.List;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;

public class BuscarVehiculoParqueaderoServicio {

private VehiculoRepositorio parqueaderoRepositorio;
	
	public BuscarVehiculoParqueaderoServicio(VehiculoRepositorio parqueaderoRepositorio){
        this.parqueaderoRepositorio = parqueaderoRepositorio;
    }
	
	public List<Vehiculo> buscar(){
        return this.parqueaderoRepositorio.buscarRegistroVehiculos();
    }
}
