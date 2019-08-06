package co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando;

import java.io.Serializable;
import java.util.Calendar;



public class VehiculoComando implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	private double total;

	public VehiculoComando() {}
	
	public VehiculoComando(String placa, String tipoVehiculo, int cilindraje) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
