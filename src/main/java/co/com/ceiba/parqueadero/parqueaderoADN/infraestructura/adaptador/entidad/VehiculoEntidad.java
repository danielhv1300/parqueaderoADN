package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.adaptador.entidad;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity(name = "VehiculoEntidad")
public class VehiculoEntidad {
	
	public VehiculoEntidad() {}

	
	public VehiculoEntidad(Long id, String placa, String tipoVehiculo, int cilindraje, Calendar fechaIngreso, Calendar fechaSalida, double valorTotal) {
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valorTotal = valorTotal;
	}
	
	@Id
	@TableGenerator(name = "codigoVehiculo", initialValue = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator  = "codigoVehiculo")
	private Long id;

	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private String tipoVehiculo;

	@Column
	private int cilindraje;
	
	@Column(nullable = false)
	private Calendar fechaIngreso;
	
	@Column
	private Calendar fechaSalida;
	
	@Column
	private double valorTotal;

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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
