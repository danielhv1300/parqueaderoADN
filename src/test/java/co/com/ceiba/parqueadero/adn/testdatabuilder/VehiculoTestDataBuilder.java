package co.com.ceiba.parqueadero.adn.testdatabuilder;

import java.util.Calendar;


import co.com.ceiba.parqueadero.adn.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.adn.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;
	private Calendar fechaIngreso;
	private Calendar fechaSalida;
	private double valor;
	
	
    public VehiculoTestDataBuilder(){
        this.id = 1L;
        this.placa = "HJI876";
        this.tipoVehiculo = Constantes.TIPO_VEHICULO_CARRO;        
        this.cilindraje = 0;
        this.fechaIngreso = null;
        this.fechaSalida = null;
        this.valor = 0;
    }
	
	public VehiculoTestDataBuilder conId(Long conId) {
        this.id = conId;
        return this;
    }

    public VehiculoTestDataBuilder conTipoVehiculo(String conTipoVehiculo) {
        this.tipoVehiculo = conTipoVehiculo;
        return this;
    }

    public VehiculoTestDataBuilder conPlaca(String conPlaca) {
        this.placa = conPlaca;
        return this;
    }

    public VehiculoTestDataBuilder conCilindraje(int conCilindraje) {
        this.cilindraje = conCilindraje;
        return this;
    }

    public VehiculoTestDataBuilder conFechaIngreso(Calendar conFechaIngreso) {
        this.fechaIngreso = conFechaIngreso;
        return this;
    }

    public VehiculoTestDataBuilder conFechaSalida(Calendar conFechaSalida) {
        this.fechaSalida = conFechaSalida;
        return this;
    }
    public VehiculoTestDataBuilder conValor(double conValor) {
        this.valor = conValor;
        return this;
    }   

    public Vehiculo build(){
    	return new Vehiculo(id, placa, tipoVehiculo, cilindraje, fechaIngreso, fechaSalida, valor);
    }
}
