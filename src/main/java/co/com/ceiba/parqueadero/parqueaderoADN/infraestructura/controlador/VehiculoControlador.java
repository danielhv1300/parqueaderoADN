package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.VehiculoComando;
import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador.ManejadorIngresoVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.manejador.ManejadorSalidaVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/vehiculo") 
public class VehiculoControlador {

	private ManejadorIngresoVehiculo entradaVehiculoHandler;
	private ManejadorSalidaVehiculo salidaVehiculoHandler;
	private ListaVehiculoHandler listaVehiculoHandler;
	
	@Autowired
    public VehiculoControlador(ManejadorIngresoVehiculo entradaVehiculoHandler, 
    		ManejadorSalidaVehiculo salidaVehiculoHandler, ListaVehiculoHandler listaVehiculoHandler){
        this.entradaVehiculoHandler = entradaVehiculoHandler;
        this.salidaVehiculoHandler = salidaVehiculoHandler;
        this.listaVehiculoHandler = listaVehiculoHandler;
    }
	

    @PostMapping
    @ApiOperation("crear")
    public void getEntrada(@RequestBody VehiculoComando parqueaderoComando) {
        this.entradaVehiculoHandler.crear(parqueaderoComando);
    }
    
    @GetMapping
	@ApiOperation("listar")
    public List<Vehiculo> listaVehiculos() {
        return this.listaVehiculoHandler.listaVehiculos();
    }

    @PutMapping("/{placa}")
    @ApiOperation("salida")
    public void getSalida(@PathVariable("placa") String placa) {
        this.salidaVehiculoHandler.actualizar(placa);
    }
}
