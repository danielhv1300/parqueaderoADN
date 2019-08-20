package co.com.ceiba.parqueadero.adn.infraestructura.adaptador.entidad;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "VehiculoEntidad")
public class VehiculoEntidad {

	public VehiculoEntidad() {
	}

	public VehiculoEntidad(Long id, String placa, String tipoVehiculo, int cilindraje, Calendar fechaIngreso,
			Calendar fechaSalida, double valorTotal) {
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valor = valorTotal;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	private String tipoVehiculo;

	@Column(nullable = true)
	private int cilindraje;

	@Column(nullable = false)
	private Calendar fechaIngreso;

	@Column(nullable = true)
	private Calendar fechaSalida;

	@Column(nullable = true)
	private double valor;

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

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public Calendar getFechaSalida() {
		return fechaSalida;
	}

	public double getValor() {
		return valor;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
