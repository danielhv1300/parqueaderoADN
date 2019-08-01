package co.com.ceiba.parqueadero.parqueaderoADN.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private int cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double total;
	
	
    public VehiculoTestDataBuilder(){
        this.id = 1L;
        this.placa = "HJI876";
        this.tipoVehiculo = Constantes.TIPO_VEHICULO_CARRO;        
        this.cilindraje = 0;
        this.fechaIngreso = new  Date();
        this.fechaSalida = null;
        this.total = 0;
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

    public VehiculoTestDataBuilder conFechaIngreso(Date conFechaIngreso) {
        this.fechaIngreso = conFechaIngreso;
        return this;
    }

    public VehiculoTestDataBuilder conFechaSalida(Date conFechaSalida) {
        this.fechaSalida = conFechaSalida;
        return this;
    }
    public VehiculoTestDataBuilder conTotal(double conTotal) {
        this.total = conTotal;
        return this;
    }   

    public Vehiculo build(){
    	return new Vehiculo(id, placa, tipoVehiculo, cilindraje, fechaIngreso, fechaSalida, total);
    }
}
