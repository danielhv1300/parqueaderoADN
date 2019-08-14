package co.com.ceiba.parqueadero.adn.infraestructura.mapeador;


import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.infraestructura.adaptador.entidad.VehiculoEntidad;

@Component
public final class VehiculoMapeador {
	
	private VehiculoMapeador() {
		super();
	}

	public static Vehiculo convertirADominio(VehiculoEntidad vehiculoEntidad) {

		return new Vehiculo(vehiculoEntidad.getId(), vehiculoEntidad.getPlaca(), vehiculoEntidad.getTipoVehiculo(),
				vehiculoEntidad.getCilindraje(), vehiculoEntidad.getFechaIngreso(), vehiculoEntidad.getFechaSalida(),
				vehiculoEntidad.getValor());
	}

	public static VehiculoEntidad convertirAEntidad(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad;
		if (vehiculo == null) {
			vehiculoEntidad = null;
		} else {
			vehiculoEntidad = new VehiculoEntidad(vehiculo.getId(), vehiculo.getPlaca(), vehiculo.getTipoVehiculo(),
					vehiculo.getCilindraje(), vehiculo.getFechaIngreso(), vehiculo.getFechaSalida(),
					vehiculo.getValor());
		}

		return vehiculoEntidad;
	}


}
