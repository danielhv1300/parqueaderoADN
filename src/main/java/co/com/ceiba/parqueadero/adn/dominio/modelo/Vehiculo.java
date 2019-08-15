package co.com.ceiba.parqueadero.adn.dominio.modelo;

import java.util.Calendar;


import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;

public class Vehiculo {
	
	public static final String MENSAJE_CAMPO_TIPO_VEHICULO_OBLIGATORIO ="El tipo de vehiculo no puede estar vacio.";
	public static final String MENSAJE_VALOR_CAMPO_TIPO_VEHICULO_INCORRECTO ="El campo tipo vehiculo no tiene valor valido.";
	public static final String MENSAJE_CAMPO_PLACA_OBLIGATORIO = "Es necesario que ingrese la placa del vehiculo";
	public static final String MENSAJE_CAMPO_CILINDRAJE_OBLIGATORIO = "Es obligatorio indicar el cilindraje de la moto";
	public static final String MENSAJE_NO_SE_ENCUENTRA_REGISTRO_VEHICULO = "El registro no existe";
	public static final String MENSAJE_SIN_CUPOS_DISPONIBLES = "En el momento el parqueadero no cuenta con un espacio disponible para este tipo de vehiculo";
	public static final String MENSAJE_RESTRICCION_POR_PLACA = "No se puede ingresar vehiculo con placa A los dias domingo y lunes";
	public static final String MENSAJE_VEHICULO_YA_EXISTE_EN_PARQUEADERO = "Ya existe un vehiculo dentro del parqueadero con la placa que desea ingresar";
	public static final String MENSAJE_VEHICULO_NO_EXISTE_EN_PARQUEADERO = "El vehiculo ya no se encuentra en el parqueadero";
	public static final char LETRA_DE_RESTRICCION_POR_PLACA = 'A';
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	private double valor;
	
	public Vehiculo() {

	}
	
	public Vehiculo(Long id, String placa, String tipoVehiculo, int cilindraje, Calendar fechaIngreso, Calendar fechaSalida, double valor) {
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
		this.valor = valor;
	}
	
	public Vehiculo(Long id, String placa, String tipoVehiculo, int cilindraje, double valor) {
		this(id, placa, tipoVehiculo, cilindraje, null, null, valor);
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
