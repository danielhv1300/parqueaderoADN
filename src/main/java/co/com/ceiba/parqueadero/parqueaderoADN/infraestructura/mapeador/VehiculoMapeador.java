package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.mapeador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.adaptador.entidad.VehiculoEntidad;

@Component
public class VehiculoMapeador {

	public Vehiculo convertirADominio(VehiculoEntidad vehiculoEntidad) {
		Vehiculo vehiculo;

		if (vehiculoEntidad == null) {
			vehiculo = null;
		} else {
			vehiculo = new Vehiculo(vehiculoEntidad.getId(), vehiculoEntidad.getPlaca(),
					vehiculoEntidad.getTipoVehiculo(), vehiculoEntidad.getCilindraje(),
					vehiculoEntidad.getFechaIngreso(), vehiculoEntidad.getFechaSalida(),
					vehiculoEntidad.getValorTotal());
		}

		return vehiculo;
	}

	public VehiculoEntidad convertirAEntidad(Vehiculo vehiculo) {
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
						vehiculoEntidad.getFechaSalida(), vehiculoEntidad.getValorTotal())));

		return listVehiculo;
	}

}
