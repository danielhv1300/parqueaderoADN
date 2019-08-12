package co.com.ceiba.parqueadero.adn.dominio.unitarias.modelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Fecha;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.parqueadero.adn.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {
	private VehiculoRepositorio vehiculoRepositorio;
	private Fecha fechaUtil;
	private ServicioCrearVehiculo crearServicio;

	@Before
	public void alistarDatos() {
		this.vehiculoRepositorio = mock(VehiculoRepositorio.class);
		this.fechaUtil = mock(Fecha.class);
		this.crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);
	}

	@Test
	public void validarCrearVehiculo() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoDataBuilder.build();
		// Act-Assert
		when(vehiculoRepositorio.crear(vehiculo)).thenReturn(vehiculo);
		when(fechaUtil.getFechaActual()).thenCallRealMethod();
		Vehiculo vehiculoRta= this.crearServicio.crear(vehiculo);
		assertEquals(vehiculoRta, vehiculo);
	}
	

}
