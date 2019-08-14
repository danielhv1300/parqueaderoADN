//package co.com.ceiba.parqueadero.adn.infraestructura.unitarias;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import co.com.ceiba.parqueadero.adn.dominio.modelo.Fecha;
//import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
//import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;
//import co.com.ceiba.parqueadero.adn.dominio.servicio.ServicioCrearVehiculo;
//import co.com.ceiba.parqueadero.adn.infraestructura.adaptador.entidad.VehiculoEntidad;
//import co.com.ceiba.parqueadero.adn.infraestructura.mapeador.VehiculoMapeador;
//import co.com.ceiba.parqueadero.adn.testdatabuilder.VehiculoTestDataBuilder;
//
//public class VehiculoMapeadorTest {
//	private VehiculoRepositorio vehiculoRepositorio;
//	private Fecha fechaUtil;
//
//	@Before
//	public void alistarDatos() {
//		// arrange
//		this.vehiculoRepositorio = mock(VehiculoRepositorio.class);
//		this.fechaUtil = mock(Fecha.class);
//		
//	}
//	@Test
//	public void convertirAEntidadCuandoVehiculoEsNull() {
//		//Arrange
//		VehiculoTestDataBuilder vehiculoDataBuilder = new VehiculoTestDataBuilder();
////		List<VehiculoEntidad> listaVehiculo = new ArrayList();
////		List<VehiculoTestDataBuilder> listVehiculoDataBuilder = new ArrayList();
////		listVehiculoDataBuilder.add(vehiculoDataBuilder);
//		
//		
//		
////		VehiculoMapeador vehiculoMapeador = new VehiculoMapeador();
//		
////		vehiculoMapeador.listaConvertirADominio(listVehiculoDataBuilder);
//		
//		Vehiculo vehiculo = vehiculoDataBuilder.build();
//		when(vehiculoRepositorio.crear(vehiculo)).thenReturn(vehiculo);
//		when(fechaUtil.getFechaActual()).thenCallRealMethod();
//		//Vehiculo vehiculoRta = this.crear(vehiculo);
//		
//		//Act
//		VehiculoMapeador.convertirAEntidad(vehiculo);
//		
//		//Assert
//		assertEquals(vehiculoEntidad,vehiculo);
//		
//		 
//	}
//
//}
