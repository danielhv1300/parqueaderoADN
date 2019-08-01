package co.com.ceiba.parqueadero.parqueaderoADN.dominio.unitarias.modelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {
	private VehiculoRepositorio vehiculoRepositorio;
	private ServicioCrearVehiculo crearServicio;

	@Before
	public void alistarDatos() {
		this.vehiculoRepositorio = mock(VehiculoRepositorio.class);
		this.crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio);
	}

	@Test
	public void validarCrearVehiculo() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder();
		Vehiculo vehiculo = vehiculoDataBuilder.build();
		// Act-Assert
		when(vehiculoRepositorio.crearVehiculo(vehiculo)).thenReturn(vehiculo);
		Vehiculo vehiculoRta= this.crearServicio.crear(vehiculo);
		assertEquals(vehiculoRta, vehiculo);
	}
	

}
