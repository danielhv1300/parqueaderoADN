package co.com.ceiba.parqueadero.adn.aplicacion.comando;

import java.io.Serializable;

public class VehiculoComando implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;
	private double valor;

	public VehiculoComando() {
	}

	public VehiculoComando(String placa, String tipoVehiculo, int cilindraje) {
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
	}

	public Long getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public double getValor() {
		return valor;
	}

}
