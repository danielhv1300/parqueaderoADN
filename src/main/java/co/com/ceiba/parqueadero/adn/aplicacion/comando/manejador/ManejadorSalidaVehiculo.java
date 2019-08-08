package co.com.ceiba.parqueadero.adn.aplicacion.comando.manejador;

import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioActualizarSalidaVehiculo;

public class ManejadorSalidaVehiculo {
	
	private final ServicioActualizarSalidaVehiculo actualizarVehiculoServicio;

    public ManejadorSalidaVehiculo(ServicioActualizarSalidaVehiculo servicio){
        this.actualizarVehiculoServicio = servicio;
    }

    public  double actualizar(String placa){
       return  this.actualizarVehiculoServicio.actualizar(placa);
    }

}
