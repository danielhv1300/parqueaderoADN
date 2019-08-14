package co.com.ceiba.parqueadero.adn.infraestructura.integracion;

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
		mockMvc.perform(get("/vehiculo").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString();
	}

	@Test
	public void postIngresarVehiculoTest() throws Exception {
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

	private String jsonToString(VehiculoComando json) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(json);
	}
}