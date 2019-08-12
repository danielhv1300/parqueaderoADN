package co.com.ceiba.parqueadero.adn.infraestructura.mapeador;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.infraestructura.adaptador.entidad.VehiculoEntidad;

@Component
public final class VehiculoMapeador {

	public static Vehiculo convertirADominio(VehiculoEntidad vehiculoEntidad) {
		
		return new Vehiculo(vehiculoEntidad.getId(), vehiculoEntidad.getPlaca(),
				vehiculoEntidad.getTipoVehiculo(), vehiculoEntidad.getCilindraje(),
				vehiculoEntidad.getFechaIngreso(), vehiculoEntidad.getFechaSalida(),
				vehiculoEntidad.getValor());
	}

	public static VehiculoEntidad convertirAEntidad(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad;
		if (vehiculo == null) {
			vehiculoEntidad = null;
		} else {
			vehiculoEntidad = new VehiculoEntidad(vehiculo.getId(), vehiculo.getPlaca(),
					vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(), vehiculo.getFechaIngreso(),
					vehiculo.getFechaSalida(), vehiculo.getValor());
		}

		return vehiculoEntidad;
	}
	
	
	
	public List<Vehiculo> listaConvertirADominio(List<VehiculoEntidad> listaVehiculoEntidad) {
		final List<Vehiculo> listVehiculo = new ArrayList<>();

		listaVehiculoEntidad
				.forEach(vehiculoEntidad -> listVehiculo.add(new Vehiculo(vehiculoEntidad.getId(),
						vehiculoEntidad.getPlaca(), vehiculoEntidad.getTipoVehiculo(),
						vehiculoEntidad.getCilindraje(), vehiculoEntidad.getFechaIngreso(),
						vehiculoEntidad.getFechaSalida(), vehiculoEntidad.getValor())));

		return listVehiculo;
	

}
}
