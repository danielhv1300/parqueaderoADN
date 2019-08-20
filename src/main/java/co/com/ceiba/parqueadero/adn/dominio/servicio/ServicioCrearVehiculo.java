package co.com.ceiba.parqueadero.adn.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionPlacaVehiculoDuplicada;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.parqueadero.adn.dominio.excepcion.ExcepcionSinCupoDisponible;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Fecha;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.adn.dominio.repositorio.VehiculoRepositorio;

public class ServicioCrearVehiculo {

	private VehiculoRepositorio vehiculoRepositorio;
	private Fecha fechaUtil;

	public ServicioCrearVehiculo(VehiculoRepositorio vehiculoRepositorio, Fecha fechaUtil) {
		this.vehiculoRepositorio = vehiculoRepositorio;
		this.fechaUtil = fechaUtil;
	}

	public Vehiculo crear(Vehiculo vehiculo) {
		validarRegistro(vehiculo.getPlaca());
		validarCupo(vehiculo.getTipoVehiculo());
		validarEntrada(vehiculo.getPlaca());
		vehiculo.setFechaIngreso(fechaUtil.getFechaActual());
		return this.vehiculoRepositorio.crear(vehiculo);
	}

	private void validarRegistro(String placa) {
		boolean existe = vehiculoRepositorio.existe(placa);
		if (existe) {
			throw new ExcepcionPlacaVehiculoDuplicada(Vehiculo.MENSAJE_VEHICULO_YA_EXISTE_EN_PARQUEADERO);
		}
	}

	private void validarCupo(String tipoVehiculo) {
		if (tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)
				&& vehiculoRepositorio.cuposPorTipoVehiculo(tipoVehiculo) == Constantes.CAPACIDAD_MAXIMA_MOTOS) {
			throw new ExcepcionSinCupoDisponible(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES);
		}
		if (tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_CARRO)
				&& vehiculoRepositorio.cuposPorTipoVehiculo(tipoVehiculo) == Constantes.CAPACIDAD_MAXIMA_CARROS) {
			throw new ExcepcionSinCupoDisponible(Vehiculo.MENSAJE_SIN_CUPOS_DISPONIBLES);
		}
	}

	private void validarEntrada(String placa) {
		Calendar fecha = fechaUtil.getFechaActual();
		int dia = fecha.get(Calendar.DAY_OF_WEEK);
		if (placa.toUpperCase().charAt(0) == Vehiculo.LETRA_DE_RESTRICCION_POR_PLACA && (dia !=Calendar.MONDAY || dia !=Calendar.SUNDAY )  ) {
			throw new ExcepcionRestriccionPlaca(Vehiculo.MENSAJE_RESTRICCION_POR_PLACA);
		}
	}
}
