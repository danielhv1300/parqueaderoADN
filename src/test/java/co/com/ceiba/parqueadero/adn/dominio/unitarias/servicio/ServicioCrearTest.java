package co.com.ceiba.parqueadero.adn.dominio.unitarias.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Fecha;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioActualizarSalidaVehiculo;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.parqueadero.adn.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearTest {

	private VehiculoRepositorio vehiculoRepositorio;
	private Fecha fechaUtil;

	@Before
	public void alistarDatos() {
		// arrange
		this.vehiculoRepositorio = mock(VehiculoRepositorio.class);
		this.fechaUtil = mock(Fecha.class);
	}

	@Test
	public void crearParqueoMoto() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder().conPlaca(Constantes.PLACA_MOTO)
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).conCilindraje(660);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);
		when(fechaUtil.getFechaActual()).thenCallRealMethod();

		when(vehiculoRepositorio.crear(vehiculo)).thenReturn(vehiculo);
		// Act
		Vehiculo vehiculoCopia = crearServicio.crear(vehiculo);

		// Assert
		assertEquals(vehiculoCopia.getId(), vehiculo.getId());
	}

	@Test
	public void crearParqueoCarro() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder().conPlaca(Constantes.PLACA_CARRO)
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);

		when(fechaUtil.getFechaActual()).thenCallRealMethod();
		when(vehiculoRepositorio.crear(vehiculo)).thenReturn(vehiculo);

		// Act
		Vehiculo vehiculoRta = crearServicio.crear(vehiculo);

		// Assert
		assertEquals(vehiculoRta.getId(), vehiculo.getId());
	}

}