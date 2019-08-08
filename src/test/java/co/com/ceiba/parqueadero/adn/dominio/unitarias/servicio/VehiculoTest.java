package co.com.ceiba.parqueadero.adn.dominio.unitarias.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionSinCupoDisponible;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Fecha;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioActualizarSalidaVehiculo;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.parqueadero.adn.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	private VehiculoRepositorio vehiculoRepositorio;
	private Fecha fechaUtil;

	@Before
	public void alistarDatos() {
		// arrange
		this.vehiculoRepositorio = mock(VehiculoRepositorio.class);
		this.fechaUtil = mock(Fecha.class);
	}

	@Test
	public void vehiculoNoParqueado() {

		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio, fechaUtil);

		when(vehiculoRepositorio.crearVehiculo(vehiculo)).thenReturn(null);

		// Act

		try {
			salidaServicio.actualizar(vehiculo.getPlaca());
			fail();
		} catch (ExcepcionNoExisteRegistroVehiculo e) {
			// Assert
			assertEquals(Vehiculo.MENSAJE_VEHICULO_NO_EXISTE_EN_PARQUEADERO, e.getMessage());
		}
	}

	@Test
	public void crearParqueoMoto() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder().conPlaca(Constantes.PLACA_MOTO)
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).conCilindraje(660);
		
		Vehiculo vehiculo = vehiculoDataBuilder.build();
		
		
		ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);
		when(fechaUtil.getFechaActual()).thenCallRealMethod();


		when(vehiculoRepositorio.crearVehiculo(vehiculo)).thenReturn(vehiculo);
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
		when(vehiculoRepositorio.crearVehiculo(vehiculo)).thenReturn(vehiculo);

		// Act
		Vehiculo vehiculoRta = crearServicio.crear(vehiculo);

		// Assert
		assertEquals(vehiculoRta.getId(), vehiculo.getId());
	}

	@Test
	public void validarCupoMoto() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder().conPlaca(Constantes.PLACA_MOTO)
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).conCilindraje(600);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);

		when(vehiculoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO))
				.thenReturn(Constantes.CAPACIDAD_MAXIMA_MOTOS);

		// Act
		try {
			crearServicio.crear(vehiculo);
			fail();
		} catch (ExcepcionSinCupoDisponible e) {
			// Assert
			assertEquals(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES, e.getMessage());
		}
	}

	@Test
	public void validarCupoCarro() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder().conPlaca(Constantes.PLACA_CARRO)
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);

		when(vehiculoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO))
				.thenReturn(Constantes.CAPACIDAD_MAXIMA_CARROS);

		// Act
		try {
			crearServicio.crear(vehiculo);
			fail();
		} catch (ExcepcionSinCupoDisponible e) {
			// Assert
			assertEquals(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES, e.getMessage());
		}
	}

	
	//(expected = Test.None.class)
	@Test(expected = ExcepcionRestriccionPlaca.class)
	public void cuandoVehiculoConPlacaQueIniciaConLetraAIntentaIngresarAlParqueaderoEntoncesSistemaRetornaExcepcionNoPuedeEntrarHoyNoEsLunesODomingo() { 
	
		// Arrange
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conPlaca(Constantes.PLACA_CARRO_CON_A).conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
				.conFechaIngreso(fechaIngreso);
		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);
		// Act

	//	try {
			crearServicio.crear(vehiculo);
	//		fail();
	//	} catch (ExcepcionRestriccionPlaca e) {
			// Assert
	//		assertEquals(Vehiculo.MENSAJE_RESTRICCION_POR_PLACA, e.getMessage());
	//	}
	}

	@Test
	public void validarHoraMoto() {
		// Arrange
		double valorHora = 500;
		int hora = 1;
		Calendar fecha = Calendar.getInstance();
		fecha.setTime(new Date());

		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR));

		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).conFechaIngreso(fecha).conCilindraje(200);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio, fechaUtil);
		when(vehiculoRepositorio.buscarPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);

		// Act
		servicioSalida.actualizar(vehiculo.getPlaca());

		// Assert
		assertEquals((valorHora * hora), vehiculo.getValor(), 0);

	}

	@Test
	public void costoAdicionalAltoCilindrajeTest() {
		// Arrange
		double valorHora = 500;
		double valorAdicional = 2000;
		int hora = 1;

		Calendar fecha = Calendar.getInstance();


		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR));

		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).conFechaIngreso(fecha).conCilindraje(600);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio, fechaUtil);
		when(vehiculoRepositorio.buscarPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);

		// Act
		servicioSalida.actualizar(vehiculo.getPlaca());

		// Assert
		assertEquals((valorHora * hora) + valorAdicional, vehiculo.getValor(), 0);

	}

	@Test
	public void validarHoraCarro() {
		// Arrange
		double valorHora = 1000;
		int hora = 1;
		Calendar fecha = Calendar.getInstance();

		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR));

		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).conFechaIngreso(fecha);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio, fechaUtil);
		when(vehiculoRepositorio.buscarPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);

		// Act
		servicioSalida.actualizar(vehiculo.getPlaca());

		// Assert

		assertEquals((valorHora * hora), vehiculo.getValor(), 0);
	}

	@Test
	public void cobroDiaCarro() {
		// Arrange
		double valorDiaCarro = 8000;
		//int horasEnParqueadero = 15;

		Calendar fechaSalida = Calendar.getInstance();
		Calendar fechaIngreso = Calendar.getInstance();

		fechaSalida.set(2019,8,6,9,0,0);

		fechaIngreso.set(2019,8,6,0,0,0);
		
		
		
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).conFechaIngreso(fechaIngreso).conFechaSalida(fechaSalida);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		when(vehiculoRepositorio.buscarPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);
		when(fechaUtil.getFechaActual()).thenReturn(fechaSalida);
		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio, fechaUtil);		

		// Act
		servicioSalida.actualizar(vehiculo.getPlaca());

		// Assert
		assertEquals("El auto entró:" + vehiculo.getFechaIngreso().getTime() + " y salió"
				+ vehiculo.getFechaSalida().getTime(), valorDiaCarro, vehiculo.getValor(), 0);

	}

}