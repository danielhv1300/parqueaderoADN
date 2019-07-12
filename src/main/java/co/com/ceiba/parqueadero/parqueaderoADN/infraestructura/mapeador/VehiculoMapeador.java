package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.mapeador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.adaptador.entidad.VehiculoEntidad;

@Component
public class VehiculoMapeador {

	public Vehiculo convertirADominio(VehiculoEntidad parqueaderoEntidad) {
		Vehiculo parqueadero;

		if (parqueaderoEntidad == null) {
			parqueadero = null;
		} else {
			parqueadero = new Vehiculo(parqueaderoEntidad.getId(), parqueaderoEntidad.getPlaca(),
					parqueaderoEntidad.getTipoVehiculo(), parqueaderoEntidad.getCilindraje(),
					parqueaderoEntidad.getFechaIngreso(), parqueaderoEntidad.getFechaSalida(),
					parqueaderoEntidad.getValorTotal());
		}

		return parqueadero;
	}

	public VehiculoEntidad convertirAEntidad(Vehiculo parqueadero) {
		VehiculoEntidad parqueaderoEntidad;
		if (parqueadero == null) {
			parqueaderoEntidad = null;
		} else {
			parqueaderoEntidad = new VehiculoEntidad(parqueadero.getId(), parqueadero.getPlaca(),
					parqueadero.getTipoVehiculo(), parqueadero.getCilindraje(), parqueadero.getFechaIngreso(),
					parqueadero.getFechaSalida(), parqueadero.getValor());
		}

		return parqueaderoEntidad;
	}

	public List<Vehiculo> listaConvertirADominio(List<VehiculoEntidad> listaParqueaderoEntidad) {
		final List<Vehiculo> listParqueadero = new ArrayList<>();

		listaParqueaderoEntidad
				.forEach(parqueaderoEntidad -> listParqueadero.add(new Vehiculo(parqueaderoEntidad.getId(),
						parqueaderoEntidad.getPlaca(), parqueaderoEntidad.getTipoVehiculo(),
						parqueaderoEntidad.getCilindraje(), parqueaderoEntidad.getFechaIngreso(),
						parqueaderoEntidad.getFechaSalida(), parqueaderoEntidad.getValorTotal())));

		return listParqueadero;
	}

}
