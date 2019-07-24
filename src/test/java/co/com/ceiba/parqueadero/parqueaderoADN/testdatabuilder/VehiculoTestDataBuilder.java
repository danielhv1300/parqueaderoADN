package co.com.ceiba.parqueadero.parqueaderoADN.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private Long id;
	private String placa;
	private String tipoVehiculo;
	private String cilindraje;
	private Date fechaIngreso;
	private Date fechaSalida;
	private double total;
	
	
    public VehiculoTestDataBuilder(){
        this.id = 1L;
        this.placa = "HJI876";
        this.tipoVehiculo = Constantes.TIPO_VEHICULO_CARRO;        
        this.cilindraje = null;
        this.fechaIngreso = new  Date();
        this.fechaSalida = null;
        this.total = 0;
    }
	
	public VehiculoTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public VehiculoTestDataBuilder tipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public VehiculoTestDataBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoTestDataBuilder cilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public VehiculoTestDataBuilder fechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public VehiculoTestDataBuilder fechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
        return this;
    }
    public VehiculoTestDataBuilder total(long total) {
        this.total = total;
        return this;
    }   

    public Vehiculo build(){
    	return new Vehiculo(id, placa, tipoVehiculo, cilindraje, fechaIngreso, fechaSalida, total);
    }
}
