package co.com.ceiba.parqueadero.adn.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.adn.aplicacion.comando.VehiculoComando;
import co.com.ceiba.parqueadero.adn.aplicacion.comando.manejador.ManejadorIngresoVehiculo;
import co.com.ceiba.parqueadero.adn.aplicacion.comando.manejador.ManejadorSalidaVehiculo;
import co.com.ceiba.parqueadero.adn.aplicacion.consulta.ListaVehiculoHandler;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/vehiculo")
public class VehiculoControlador {

	private ManejadorIngresoVehiculo entradaVehiculoHandler;
	private ManejadorSalidaVehiculo salidaVehiculoHandler;
	private ListaVehiculoHandler listaVehiculoHandler;

	public VehiculoControlador(ManejadorIngresoVehiculo entradaVehiculoHandler,
			ManejadorSalidaVehiculo salidaVehiculoHandler, ListaVehiculoHandler listaVehiculoHandler) {
		this.entradaVehiculoHandler = entradaVehiculoHandler;
		this.salidaVehiculoHandler = salidaVehiculoHandler;
		this.listaVehiculoHandler = listaVehiculoHandler;
	}

	@PostMapping
	public void getEntrada(@RequestBody VehiculoComando vehiculoComando) {
		this.entradaVehiculoHandler.crear(vehiculoComando);
	}

	@GetMapping
	public List<Vehiculo> listaVehiculos() {
		return this.listaVehiculoHandler.listaVehiculos();
	}

	@PutMapping("/{placa}")
	public double getSalida(@PathVariable("placa") String placa) {
		return this.salidaVehiculoHandler.actualizar(placa);
	}
}
