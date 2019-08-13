package co.com.ceiba.parqueadero.adn.dominio.unitarias.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionCampoObligatorio;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionSinCupoDisponible;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionTipoVehiculo;
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
	@Test
	public void cuandoVehiculoConPlacaQueIniciaConLetraAIntentaIngresarAlParqueaderoEntoncesSistemaRetornaExcepcionNoPuedeEntrarHoyNoEsLunesODomingo() {

		// Arrange
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);

		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.conPlaca(Constantes.PLACA_CARRO_CON_A).conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
				.conFechaIngreso(fechaIngreso);

		Vehiculo vehiculo = vehiculoDataBuilder.build();
		crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);
		when(fechaUtil.getFechaActual()).thenCallRealMethod();
		// Act
		try {
			crearServicio.crear(vehiculo);
			fail();
		} catch (ExcepcionRestriccionPlaca e) {
			// Assert
			assertEquals(Vehiculo.MENSAJE_RESTRICCION_POR_PLACA, e.getMessage());
		}
	}
	@Test
	public void validarCupoCarro() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder().conPlaca(Constantes.PLACA_CARRO)
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);

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
	
	@Test(expected = ExcepcionCampoObligatorio.class)
    public void validarCampoPlacaObligatoria() {
        //Arrange - Act - Assert
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();

        vehiculoTestDataBuilder.conPlaca(null);
        
        vehiculoTestDataBuilder.build();
    }
	
	
	@Test(expected = ExcepcionCampoObligatorio.class)
    public void validarCampoTipoVehiculoObligatorio() {
        //Arrange - Act - Assert
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();

        vehiculoTestDataBuilder.conTipoVehiculo(null);
    
        vehiculoTestDataBuilder.build();
    }
	
	@Test(expected = ExcepcionCampoObligatorio.class)
    public void validarCampoCilindrajeObligatorio() {
        //Arrange - Act - Assert
        VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();

        vehiculoTestDataBuilder.conTipoVehiculo(null);
        
       vehiculoTestDataBuilder.build();
    }
	
	
	
	@Test
	public void validarCupoMoto() {
		// Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder().conPlaca(Constantes.PLACA_MOTO)
				.conTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO).conCilindraje(600);

		Vehiculo vehiculo = vehiculoDataBuilder.build();

		crearServicio = new ServicioCrearVehiculo(vehiculoRepositorio, fechaUtil);

		when(vehiculoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO))
				.thenReturn(Constantes.CAPACIDAD_MAXIMA_MOTOS);

		// Act
		try {
			crearServicio.crear(vehiculo);
			fail();
		} catch (ExcepcionSinCupoDisponible e) {
			// Assert - Act - Assert
			assertEquals(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES, e.getMessage());
		}
	}
	
    @Test(expected= ExcepcionTipoVehiculo.class)
    public void validarTipoVehiculoIncorrecto() {
        //Arrange
    	VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
    	String tipoVehiculo = "carr";
        vehiculoTestDataBuilder.conTipoVehiculo(tipoVehiculo);

        //
        vehiculoTestDataBuilder.build();
    }

}


