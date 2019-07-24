package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador.ManejadorIngresoVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador.ManejadorSalidaVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioActualizarSalidaVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioBuscarVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioCrearVehiculo;

@Configuration
public class ConfiguracionBean {
	
	@Bean
    public ManejadorIngresoVehiculo entradaVehiculoHandler(ServicioCrearVehiculo crearServicio) {
        return new ManejadorIngresoVehiculo(crearServicio);
    }

    @Bean
    public ServicioCrearVehiculo crearServicio(VehiculoRepositorio parqueaderoRepositorio){
        return new ServicioCrearVehiculo(parqueaderoRepositorio);
    }

    @Bean
    public ListaVehiculoHandler listaVehiculoHandler(ServicioBuscarVehiculo buscarListaServicio) {
        return new ListaVehiculoHandler(buscarListaServicio);
    }
    
    @Bean
    public  ServicioBuscarVehiculo listaVehiculoServicio(VehiculoRepositorio parqueaderoRepositorio){
        return new ServicioBuscarVehiculo(parqueaderoRepositorio);
    }
    
    @Bean
    public ManejadorSalidaVehiculo salidaVehiculoHandler(ServicioActualizarSalidaVehiculo actualizarServicio) {
        return new ManejadorSalidaVehiculo(actualizarServicio);
    }
    
    @Bean
    public ServicioActualizarSalidaVehiculo registerExitService(VehiculoRepositorio parqueaderoRepositorio){
        return new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
    }
    
    
}
