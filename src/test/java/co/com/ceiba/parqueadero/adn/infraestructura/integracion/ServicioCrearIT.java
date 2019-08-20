package co.com.ceiba.parqueadero.adn.infraestructura.integracion;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.parqueadero.adn.ParqueaderoAdnApplication;
import co.com.ceiba.parqueadero.adn.aplicacion.comando.VehiculoComando;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionCampoObligatorio;
import co.com.ceiba.parqueadero.adn.testdatabuilder.VehiculoComandoTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ParqueaderoAdnApplication.class)
@AutoConfigureMockMvc

public class ServicioCrearIT {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setupMock() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getListaTest() throws Exception {
		// Arrange , Act y Assert
		mockMvc.perform(get("/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
	}

	@Test
	public void postIngresarVehiculoTest() throws Exception  {
		// Arrange
		VehiculoComandoTestDataBuilder vehiculoComandoTestDataBuilder = new VehiculoComandoTestDataBuilder();
		VehiculoComando vehiculoComando = vehiculoComandoTestDataBuilder.build();

		// Act y Assert
		mockMvc.perform(
				post("/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonToString(vehiculoComando)))
				.andExpect(status().isOk());	
	}

	@Test
	public void putSalidaVehiculoTest() throws Exception {
		// Arrange
		String placa = "MMM000";
		// Act y Assert
		mockMvc.perform(put("/vehiculo/" + placa).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}
	
	@Test
	public void postIngresarVehiculoTestPlacaA() {
		// Arrange
		VehiculoComandoTestDataBuilder vehiculoComandoTestDataBuilder = new VehiculoComandoTestDataBuilder();
		vehiculoComandoTestDataBuilder.placa("AAA123");
		VehiculoComando vehiculoComando = vehiculoComandoTestDataBuilder.build();

		
		assertThatThrownBy(() -> {
			mockMvc.perform(
					post("/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonToString(vehiculoComando)));
		}).hasMessageContaining("Los vehiculos que inician con la letra A en su placa, solo ingresan los dias domingos y lunes");
	}
	
	
	@Test
	public void postIngresarVehiculoTestSinCilindraje() {
		// Arrange
		VehiculoComandoTestDataBuilder vehiculoComandoTestDataBuilder = new VehiculoComandoTestDataBuilder();
		vehiculoComandoTestDataBuilder.cilindraje(0);
		vehiculoComandoTestDataBuilder.tipoVehiculo("MOTO");
		VehiculoComando vehiculoComando = vehiculoComandoTestDataBuilder.build();

		
		assertThatThrownBy(() -> {
			mockMvc.perform(
					post("/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonToString(vehiculoComando))).andReturn();
					
		}).hasMessageContaining("Es obligatorio indicar el cilindraje de la moto");
	}
	
	@Test
	public void postIngresarVehiculoTestSinPlacaCarro() {
		// Arrange
		VehiculoComandoTestDataBuilder vehiculoComandoTestDataBuilder = new VehiculoComandoTestDataBuilder();
		vehiculoComandoTestDataBuilder.placa("");
		vehiculoComandoTestDataBuilder.tipoVehiculo("CARRO");
		VehiculoComando vehiculoComando = vehiculoComandoTestDataBuilder.build();

		
		assertThatThrownBy(() -> {
			mockMvc.perform(
					post("/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonToString(vehiculoComando))).andReturn();
					
		}).hasMessageContaining("Es necesario que ingrese la placa del vehiculo");
	}
	
	@Test
	public void postIngresarVehiculoTestSinPlacaMoto() {
		// Arrange
		VehiculoComandoTestDataBuilder vehiculoComandoTestDataBuilder = new VehiculoComandoTestDataBuilder();
		vehiculoComandoTestDataBuilder.placa("");
		vehiculoComandoTestDataBuilder.tipoVehiculo("MOTO");
		vehiculoComandoTestDataBuilder.cilindraje(300);
		VehiculoComando vehiculoComando = vehiculoComandoTestDataBuilder.build();

		
		assertThatThrownBy(() -> {
			mockMvc.perform(
					post("/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonToString(vehiculoComando))).andReturn();
					
		}).hasMessageContaining("Es necesario que ingrese la placa del vehiculo");
	}
	
	@Test
	public void postIngresarVehiculoTestSinTipoVehiculo() {
		// Arrange
		VehiculoComandoTestDataBuilder vehiculoComandoTestDataBuilder = new VehiculoComandoTestDataBuilder();
		vehiculoComandoTestDataBuilder.tipoVehiculo("");
		VehiculoComando vehiculoComando = vehiculoComandoTestDataBuilder.build();

		
		assertThatThrownBy(() -> {
			mockMvc.perform(
					post("/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonToString(vehiculoComando))).andReturn();
					
		}).hasMessageContaining("El tipo de vehiculo no puede estar vacio.");
	}

	private String jsonToString(VehiculoComando json) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(json);
	}
}