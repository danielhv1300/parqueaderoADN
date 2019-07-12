package co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ActualizarSalidaVehiculoParqueaderoServicio;

public class ManejadorSalidaVehiculo {
	
	private final ActualizarSalidaVehiculoParqueaderoServicio actualizarVehiculoServicio;

    public ManejadorSalidaVehiculo(ActualizarSalidaVehiculoParqueaderoServicio servicio){
        this.actualizarVehiculoServicio = servicio;
    }

    public  void actualizar(String placa){
        this.actualizarVehiculoServicio.actualizar(placa);
    }

}
