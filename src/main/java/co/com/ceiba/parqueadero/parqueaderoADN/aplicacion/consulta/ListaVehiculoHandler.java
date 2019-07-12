package co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.consulta;

import java.util.List;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.BuscarVehiculoParqueaderoServicio;

public class ListaVehiculoHandler {

	private final BuscarVehiculoParqueaderoServicio buscarServicio;

    public ListaVehiculoHandler(BuscarVehiculoParqueaderoServicio servicio){
        this.buscarServicio = servicio;
    }

    public List<Vehiculo> listaVehiculos(){
        return this.buscarServicio.buscar();
    }
}
