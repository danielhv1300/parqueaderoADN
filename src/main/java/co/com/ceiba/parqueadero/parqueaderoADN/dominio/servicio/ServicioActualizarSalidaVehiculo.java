package co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.ValidadorVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;

public class ServicioActualizarSalidaVehiculo {

	private VehiculoRepositorio vehiculoRepositorio;

	public ServicioActualizarSalidaVehiculo(VehiculoRepositorio vehiculoRepositorio) {
		this.vehiculoRepositorio = vehiculoRepositorio;
	}

	public double actualizar(String placa) {
		ValidadorVehiculo.validarDatoObligatorio(placa, Vehiculo.MENSAJE_CAMPO_PLACA_OBLIGATORIO);
		Vehiculo vehiculo = validarRegistro(placa);
		vehiculo.setFechaSalida(Calendar.getInstance());
		if (vehiculo.getTipoVehiculo().equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
			calcularPrecioMoto(vehiculo);
		} else {
			calcularPrecioCarro(vehiculo);
		}

		this.vehiculoRepositorio.crearVehiculo(vehiculo);
		return vehiculo.getValor();
	}

	private Vehiculo validarRegistro(String placa) {
		Vehiculo vehiculo = this.vehiculoRepositorio.buscarPorPlaca(placa);
		if (vehiculo == null) {
			throw new ExcepcionNoExisteRegistroVehiculo(Vehiculo.MENSAJE_VEHICULO_NO_EXISTE_EN_PARQUEADERO);
		}
		return vehiculo;
	}

	public void calcularPrecioMoto(Vehiculo vehiculo) {
		double value;
		Date fechaIngreso = vehiculo.getFechaIngreso().getTime();
		Date fechaSalida = vehiculo.getFechaSalida().getTime();
		double miliSegundo = (fechaSalida.getTime() - fechaIngreso.getTime());
		double hora = (miliSegundo / 3600000);
		double minuto = (miliSegundo / 60000);
		long totalHora = Math.round(hora);
		long totalMinutos = Math.round(minuto);
		int totalDia = (int) totalHora / Constantes.FIN_EN_HORAS_PARA_COBRO_POR_DIA;
		int totalHoraNuevoDia = (int) totalHora % Constantes.FIN_EN_HORAS_PARA_COBRO_POR_DIA;

		if (totalHora < Constantes.VALOR_HORA_MOTO) {
			if ((totalMinutos >= 0) && (totalHora == 0)) {
				value = Constantes.VALOR_HORA_MOTO;
			} else {
				value = totalHora * Constantes.VALOR_HORA_MOTO;
			}
		} else if (totalHoraNuevoDia == 0 || (totalHoraNuevoDia >= Constantes.INICIO_EN_HORAS_PARA_COBRO_POR_DIA
				&& totalHoraNuevoDia < Constantes.FIN_EN_HORAS_PARA_COBRO_POR_DIA)) {
			value = (Constantes.VALOR_DIA_MOTO);
		} else {
			value = ((Constantes.VALOR_DIA_MOTO * totalDia) + (totalHoraNuevoDia * Constantes.VALOR_HORA_MOTO));
		}

		if (Integer.valueOf(vehiculo.getCilindraje()) >= Constantes.ALTO_CILINDRAJE_MOTO) {
			value = value + Constantes.VALOR_ADICIONAL_MOTO_POR_CILINDRAJE;
		}

		vehiculo.setValor(value);
	}

	public void calcularPrecioCarro(Vehiculo vehiculo) {
		double valor;
		Date fechaIngreso = vehiculo.getFechaIngreso().getTime();
		Date fechaSalida = vehiculo.getFechaSalida().getTime();
		double miliSegundo = (fechaSalida.getTime() - fechaIngreso.getTime());
		double horaCarro = (miliSegundo / 3600000);
		double minutosCarro = (miliSegundo / 60000);
		long totalHora = Math.round(horaCarro);
		long totalMinutos = Math.round(minutosCarro);
		int totalDia = (int) totalHora / Constantes.FIN_EN_HORAS_PARA_COBRO_POR_DIA;
		int totalHoraNuevoDia = (int) totalHora % Constantes.FIN_EN_HORAS_PARA_COBRO_POR_DIA;

		if (totalHora < Constantes.VALOR_HORA_CARRO) {
			if ((totalMinutos >= 0) && (totalHora == 0)) {
				valor = Constantes.VALOR_HORA_CARRO;
			} else {
				valor = totalHora * Constantes.VALOR_HORA_CARRO;
			}
		} else if (totalHoraNuevoDia == 0 || (totalHoraNuevoDia >= Constantes.INICIO_EN_HORAS_PARA_COBRO_POR_DIA
				&& totalHoraNuevoDia < Constantes.FIN_EN_HORAS_PARA_COBRO_POR_DIA)) {
			valor = (Constantes.VALOR_DIA_CARRO);
		} else {
			valor = ((Constantes.VALOR_DIA_CARRO * totalDia) + (totalHoraNuevoDia * Constantes.VALOR_HORA_CARRO));
		}

		vehiculo.setValor(valor);
	}
	
	
}
