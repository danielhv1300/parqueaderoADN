package co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;

public class Vehiculo {
	
	public static final String MENSAJE_CAMPO_TIPO_VEHICULO_OBLIGATORIO ="El tipo de vehiculo no puede estar vacio.\n Ingrese un tipo de veh�culo";
	public static final String MENSAJE_VALOR_CAMPO_TIPO_VEHICULO_INCORRECTO ="El campo tipo vehiculo no tiene valor (%S) valido.";
	public static final String MENSAJE_CAMPO_PLACA_OBLIGATORIO = "Es necesario que ingrese la placa del veh�culo";
	public static final String MENSAJE_CAMPO_CILINDRAJE_OBLIGATORIO = "Es obligatorio indicar el cilindraje de la moto";
	public static final String MENSAJE_NO_SE_ENCUENTRA_REGISTRO_VEHICULO = "El registro no existe";
	public static final String MENSAJE_SIN_CUPOS_DISPONIBLES = "En el momento el parqueadero no cuenta con un espacio disponible para este tipo de veh�culo";
	public static final String MENSAJE_RESTRICCION_POR_PLACA = "Por politicas del parqueadero el vehiculo no puede ingresar el d�a de hoy debido a que su placa inica por \"A\"";
	public static final String MENSAJE_VEHICULO_YA_EXISTE_EN_PARQUEADERO = "Ya existe un veh�culo dentro del parqueadero con la placa que desea ingresar";
	public static final String MENSAJE_VEHICULO_NO_EXISTE_EN_PARQUEADERO = "El vehiculo ya no se encuentra en el parqueadero";
	public static final String LETRA_DE_RESTRICCION_POR_PLACA = "A";
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double valor;
	
	public Vehiculo(Long id, String placa, String tipoVehiculo, String cilindraje, Date fechaIngreso, Date fechaSalida, double total) {
		ValidadorVehiculo.validarDatoObligatorio(placa, MENSAJE_CAMPO_PLACA_OBLIGATORIO);
		ValidadorVehiculo.validarDatoObligatorio(tipoVehiculo,MENSAJE_CAMPO_TIPO_VEHICULO_OBLIGATORIO);
		
		ValidadorVehiculo.validarTipoVehiculo(tipoVehiculo, MENSAJE_VALOR_CAMPO_TIPO_VEHICULO_INCORRECTO);
		
		if(tipoVehiculo.equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
			ValidadorVehiculo.validarDatoObligatorio(cilindraje, MENSAJE_CAMPO_CILINDRAJE_OBLIGATORIO);
		}
		
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.cilindraje = cilindraje;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.valor = total;
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

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
