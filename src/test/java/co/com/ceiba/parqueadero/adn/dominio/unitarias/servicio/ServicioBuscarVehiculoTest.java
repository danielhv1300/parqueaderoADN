package co.com.ceiba.parqueadero.adn.dominio.unitarias.servicio;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioBuscarVehiculo;
import co.com.ceiba.parqueadero.adn.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioBuscarVehiculoTest {
	
	private VehiculoRepositorio vehiculoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.vehiculoRepositorio = mock(VehiculoRepositorio.class);
	}

	@Test
	public void listarParqueadero() {
		//Arrange
        VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
                .conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);
        
        Vehiculo vehiculo = vehiculoDataBuilder.build();

        ServicioBuscarVehiculo listarServicio = new ServicioBuscarVehiculo(vehiculoRepositorio);
        when(vehiculoRepositorio.crear(vehiculo)).thenReturn(vehiculo);
        
        List<Vehiculo> listaVehiculos = listarServicio.buscar();
        assertNotNull(listaVehiculos);
	}
}