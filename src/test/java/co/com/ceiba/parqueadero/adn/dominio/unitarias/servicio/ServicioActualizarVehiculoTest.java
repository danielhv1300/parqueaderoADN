package co.com.ceiba.parqueadero.adn.dominio.unitarias.servicio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Fecha;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioActualizarSalidaVehiculo;
import co.com.ceiba.parqueadero.adn.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioActualizarVehiculoTest {
	private VehiculoRepositorio vehiculoRepositorio;
	private Fecha fechaUtil;

	@Before
	public void alistarDatos() {
		// arrange
		this.vehiculoRepositorio = mock(VehiculoRepositorio.class);
		this.fechaUtil = mock(Fecha.class);
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

		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio,
				fechaUtil);
		when(fechaUtil.getFechaActual()).thenCallRealMethod();
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
		double valor = (valorHora * hora) + valorAdicional;

		Calendar fecha = Calendar.getInstance();

		fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR));
		
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).conFechaIngreso(fecha).conCilindraje(600);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio,
				fechaUtil);
		when(fechaUtil.getFechaActual()).thenCallRealMethod();
		when(vehiculoRepositorio.buscarPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);

		// Act
		servicioSalida.actualizar(vehiculo.getPlaca());

		// Assert
		assertEquals(valor, vehiculo.getValor(), 0);

	}
	
	@Test
    public void  validarDiaMotoAltoCilindraje() {
        //Arrange
        double valorDia = Constantes.VALOR_DIA_MOTO+Constantes.VALOR_HORA_MOTO;
        int hora = 9;
        int valorAdicional = 2000;
        
        Calendar fecha = Calendar.getInstance();
      

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder()
        		.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
        		.conFechaIngreso(fecha)
        		.conCilindraje(660);

        Vehiculo vehiculo = vehiculoTestDataBuilder.build();

        ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio,
				fechaUtil);
        when(fechaUtil.getFechaActual()).thenCallRealMethod();
        when(vehiculoRepositorio.buscarPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);

        //Act
        servicioSalida.actualizar(vehiculo.getPlaca());

        //Assert
        assertEquals(valorDia + valorAdicional,vehiculo.getValor(),0);

    }
	

	@Test
	public void validarDiaMoto() {
		// Arrange
		double valorDiaMoto = Constantes.VALOR_DIA_MOTO+Constantes.VALOR_HORA_MOTO;

		Calendar fechaSalida = Calendar.getInstance();
		Calendar fechaIngreso = Calendar.getInstance();

		fechaSalida.set(2019, 8, 6, 9, 0, 0);

		fechaIngreso.set(2019, 8, 6, 0, 0, 0);

		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).conFechaIngreso(fechaIngreso)
				.conFechaSalida(fechaSalida);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		when(vehiculoRepositorio.buscarPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);
		when(fechaUtil.getFechaActual()).thenReturn(fechaSalida);
		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio,
				fechaUtil);

		// Act
		servicioSalida.actualizar(vehiculo.getPlaca());

		// Assert
		assertEquals(valorDiaMoto, vehiculo.getValor(), 0);

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

		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio,
				fechaUtil);
		when(fechaUtil.getFechaActual()).thenCallRealMethod();
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

		Calendar fechaSalida = Calendar.getInstance();
		Calendar fechaIngreso = Calendar.getInstance();

		fechaSalida.set(2019, 8, 6, 9, 0, 0);

		fechaIngreso.set(2019, 8, 6, 0, 0, 0);

		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).conFechaIngreso(fechaIngreso)
				.conFechaSalida(fechaSalida);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		when(vehiculoRepositorio.buscarPorPlaca(vehiculo.getPlaca())).thenReturn(vehiculo);
		when(fechaUtil.getFechaActual()).thenReturn(fechaSalida);
		ServicioActualizarSalidaVehiculo servicioSalida = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio,
				fechaUtil);

		// Act
		servicioSalida.actualizar(vehiculo.getPlaca());

		// Assert
		assertEquals("El auto entró:" + vehiculo.getFechaIngreso().getTime() + " y salió"
				+ vehiculo.getFechaSalida().getTime(), valorDiaCarro, vehiculo.getValor(), 0);

	}
	
	@Test
	public void vehiculoNoParqueado() {

		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(vehiculoRepositorio,
				fechaUtil);

		when(vehiculoRepositorio.crear(vehiculo)).thenReturn(null);

		// Act

		try {
			salidaServicio.actualizar(vehiculo.getPlaca());
			fail();
		} catch (ExcepcionNoExisteRegistroVehiculo e) {
			// Assert
			assertEquals(Vehiculo.MENSAJE_VEHICULO_NO_EXISTE_EN_PARQUEADERO, e.getMessage());
		}
	}
	
	

}

