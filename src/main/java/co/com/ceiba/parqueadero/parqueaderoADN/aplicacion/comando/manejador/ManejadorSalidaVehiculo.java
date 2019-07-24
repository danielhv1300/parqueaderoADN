package co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioActualizarSalidaVehiculo;

public class ManejadorSalidaVehiculo {
	
	private final ServicioActualizarSalidaVehiculo actualizarVehiculoServicio;

    public ManejadorSalidaVehiculo(ServicioActualizarSalidaVehiculo servicio){
        this.actualizarVehiculoServicio = servicio;
    }

    public  void actualizar(String placa){
        this.actualizarVehiculoServicio.actualizar(placa);
    }

}
