package co.com.ceiba.parqueadero.parqueaderoADN.dominio.unitarias.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio.ServicioActualizarSalidaVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.testdatabuilder.VehiculoTestDataBuilder;


public class ServicioActualizarVehiculoTest {

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
    public void  validarHoraMoto() {
        //Arrange
        double valorPorHora = 500;
        int hora = 7;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
                .tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
                .fechaIngreso(fecha.getTime())
                .cilindraje("200");

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valorPorHora * hora), parqueadero.getValor(),0);

    }
	
	@Test
    public void  validarHoraCarro() {
        //Arrange
        double valorPorHora = 1000;
        int hora = 7;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
                .tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
                .fechaIngreso(fecha.getTime());

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valorPorHora * hora),parqueadero.getValor(),0);

    }
	
	@Test
    public void  validarAdicionalMoto() {
        //Arrange
        double valorPorHora = 500;
        int hora = 7;
        int valorAdicional = 2000;

        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
                .fechaIngreso(fecha.getTime())
                .cilindraje("600");

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valorPorHora * hora)+valorAdicional,parqueadero.getValor(),0);
    }
	
	@Test
    public void  validarDiaCarro() {
        //Arrange
        double valorDia = 8000;
        int hora = 9;
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
        		.fechaIngreso(fecha.getTime());

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals(valorDia,parqueadero.getValor(),0);

    }
	
	@Test
    public void  validarDiaMotoCilindraje() {
        //Arrange
        double valorDia = 4000;
        int hora = 9;
        int valorAdicional = 2000;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
        		.cilindraje("650")
        		.fechaIngreso(fecha.getTime());

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals(valorDia + valorAdicional,parqueadero.getValor(),0);

    }
	
	@Test
    public void  validarDiaMoto() {
        //Arrange
        double valorDia = 4000;
        int hora = 9;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
        		.cilindraje("200")
        		.fechaIngreso(fecha.getTime());

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals(valorDia ,parqueadero.getValor(),0);

    }
	
	@Test
    public void  validarDiasCarro() {
        //Arrange
        double valorDia = 8000;
        double valorHora = 1000;
        int hora = 26;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)
        		.fechaIngreso(fecha.getTime());

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valorHora*2) + valorDia,parqueadero.getValor(),0);

    }
	
	@Test
    public void  validarDiasMoto() {
        //Arrange
        double valorDia = 4000;
        double valorHora = 500;
        int hora = 26;
        
        Calendar fecha = Calendar.getInstance();
        fecha.setTime(new Date());

        fecha.set(Calendar.HOUR, fecha.get(Calendar.HOUR) - hora);

        VehiculoTestDataBuilder parqueaderoDataBuilder = new VehiculoTestDataBuilder()
        		.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)
        		.cilindraje("200")
        		.fechaIngreso(fecha.getTime());

        Vehiculo parqueadero = parqueaderoDataBuilder.build();

        ServicioActualizarSalidaVehiculo salidaServicio = new ServicioActualizarSalidaVehiculo(parqueaderoRepositorio);
        when(parqueaderoRepositorio.buscarPorPlaca(parqueadero.getPlaca())).thenReturn(parqueadero);

        //Act
        salidaServicio.actualizar(parqueadero.getPlaca());

        //Assert
        assertEquals((valorHora*2)+valorDia,parqueadero.getValor(),0);

    }

}
