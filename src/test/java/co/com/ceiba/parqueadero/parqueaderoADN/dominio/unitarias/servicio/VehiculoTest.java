package co.com.ceiba.parqueadero.parqueaderoADN.dominio.unitarias.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;


import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionSinCupoDisponible;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioActualizarSalidaVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.testdatabuilder.VehiculoTestDataBuilder;


public class VehiculoTest {

	private VehiculoRepositorio parqueaderoRepositorio;

	@Before
	public void prepararDatos() {
		// arrange
		this.parqueaderoRepositorio = mock(VehiculoRepositorio.class);
	}
	
	@Test
	public void vehiculoNoParqueado() {
		
		//Arrange
		VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
				.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);

        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(null);

        //Act

        try {
        	salidaServicio.actualizar(parqueadero.getPlaca());
            fail();
        }catch (ExcepcionNoExisteRegistroVehiculo e){
            // Assert
            assertEquals(Vehiculo.MENSAJE_VEHICULO_NO_EXISTE_EN_PARQUEADERO, e.getMessage());
        }
	}

	
	@Test
	public void crearParqueoMoto() {
		//Arrange
		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder()
				.placa(Constantes.PLACA_MOTO)
                .tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
                .cilindraje(660);

        Vehiculo vehiculo = vehiculoDataBuilder.build();

        ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(parqueaderoRepositorio);

        when(parqueaderoRepositorio.crearVehiculo(vehiculo)).thenReturn(vehiculo);

        //Act
        Vehiculo parqueaderoCopia =  crearServicio.crear(vehiculo);

        //Assert
        assertEquals(parqueaderoCopia.getId(),vehiculo.getId());
	}
	
	@Test
	public void crearParqueoCarro() {
		//Arrange
		VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
				.placa(Constantes.PLACA_CARRO)
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(parqueaderoRepositorio);

        when(parqueaderoRepositorio.crearVehiculo(parqueadero)).thenReturn(parqueadero);

        //Act
        Vehiculo parqueaderoCopia =  crearServicio.crear(parqueadero);

        //Assert
        assertEquals(parqueaderoCopia.getId(), parqueadero.getId());
	}
	
	@Test
	public void validarCupoMoto() {
		//Arrange
		VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
				.placa(Constantes.PLACA_MOTO)
                .tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
                .cilindraje(600);

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(parqueaderoRepositorio);

        when(parqueaderoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(Constantes.CAPACIDAD_MAXIMA_MOTOS);

        //Act
        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (ExcepcionSinCupoDisponible e){
            // Assert
            assertEquals(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES, e.getMessage());
        }
	}
	
	@Test
	public void validarCupoCarro() {
		//Arrange
		VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
				.placa(Constantes.PLACA_CARRO)
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO);

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(parqueaderoRepositorio);

        when(parqueaderoRepositorio.cuposPorTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.CAPACIDAD_MAXIMA_CARROS);

        //Act
        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (ExcepcionSinCupoDisponible e){
            // Assert
            assertEquals(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES, e.getMessage());
        }
	}
	
	@Test
    public void validarRestriccionLetraPlaca(){
        //Arrange
        Calendar fechaIngreso = Calendar.getInstance();
        fechaIngreso.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder().placa("ADF123")
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO).fechaIngreso(fechaIngreso.getTime());
        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioCrearVehiculo crearServicio = new ServicioCrearVehiculo(parqueaderoRepositorio);
        //Act

        try {
        	crearServicio.crear(parqueadero);
            fail();
        }catch (ExcepcionRestriccionPlaca e){
            // Assert
            assertEquals(Vehiculo.MENSAJE_RESTRICCION_POR_PLACA, e.getMessage());
        }
    }

}
