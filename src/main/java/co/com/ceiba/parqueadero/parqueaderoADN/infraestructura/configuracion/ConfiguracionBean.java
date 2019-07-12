package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador.ManejadorEntradaVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador.ManejadorSalidaVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ActualizarSalidaVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.BuscarVehiculoParqueaderoServicio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.CrearVehiculoParqueaderoServicio;

@Configuration
public class ConfiguracionBean {
	
	@Bean
    public ManejadorEntradaVehiculo entradaVehiculoHandler(CrearVehiculoParqueaderoServicio crearServicio) {
        return new ManejadorEntradaVehiculo(crearServicio);
    }

    @Bean
    public CrearVehiculoParqueaderoServicio crearServicio(VehiculoRepositorio parqueaderoRepositorio){
        return new CrearVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }

    @Bean
    public ListaVehiculoHandler listaVehiculoHandler(BuscarVehiculoParqueaderoServicio buscarListaServicio) {
        return new ListaVehiculoHandler(buscarListaServicio);
    }
    
    @Bean
    public  BuscarVehiculoParqueaderoServicio listaVehiculoServicio(VehiculoRepositorio parqueaderoRepositorio){
        return new BuscarVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }
    
    @Bean
    public ManejadorSalidaVehiculo salidaVehiculoHandler(ActualizarSalidaVehiculoParqueaderoServicio actualizarServicio) {
        return new ManejadorSalidaVehiculo(actualizarServicio);
    }
    
    @Bean
    public ActualizarSalidaVehiculoParqueaderoServicio registerExitService(VehiculoRepositorio parqueaderoRepositorio){
        return new ActualizarSalidaVehiculoParqueaderoServicio(parqueaderoRepositorio);
    }
    
    
}
