package co.com.ceiba.parqueadero.adn.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.adn.aplicacion.comando.manejador.ManejadorIngresoVehiculo;
import co.com.ceiba.parqueadero.adn.aplicacion.comando.manejador.ManejadorSalidaVehiculo;
import co.com.ceiba.parqueadero.adn.aplicacion.consulta.ManejadorConsulta;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioActualizarSalidaVehiculo;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Fecha;

@Configuration
public class ConfiguracionBean { 
	
	
	
	@Bean
    public ManejadorIngresoVehiculo entradaVehiculoHandler(ServicioCrearVehiculo crearServicio) {
        return new ManejadorIngresoVehiculo(crearServicio);
    }

    @Bean
    public ServicioCrearVehiculo crearServicio(VehiculoRepositorio vehiculoRepositorio, Fecha fechaUtil){
        return new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);
    }

    @Bean
    public  ManejadorConsulta manejadorConsulta(VehiculoRepositorio vehiculoRepositorio){
        return new ManejadorConsulta(vehiculoRepositorio);
    }
    
    @Bean
    public ManejadorSalidaVehiculo salidaVehiculoHandler(ServicioActualizarSalidaVehiculo actualizarServicio) {
        return new ManejadorSalidaVehiculo(actualizarServicio);
    }
    
    @Bean
    public ServicioActualizarSalidaVehiculo registerExitService(VehiculoRepositorio vehiculoRepositorio, Fecha fechaUtil){
        return new ServicioActualizarSalidaVehiculo(vehiculoRepositorio, fechaUtil);
    }
    @Bean 
    public Fecha fecha() {
    	return new Fecha();
    }
    
    
}
