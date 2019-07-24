package co.com.ceiba.parqueadero.parqueaderoADN.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.parqueaderoADN.aplicacion.comando.VehiculoComando;

public class VehiculoComandoTestDataBuilder {

	private Long id;
	private String placa;
	private String tipoVehiculo;
	private String cilindraje;

    public VehiculoComandoTestDataBuilder(){
        this.id = 1L;
        this.placa = "EOW328";
        this.tipoVehiculo = "CARRO";
        this.cilindraje = null;

    }

    public VehiculoComandoTestDataBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public VehiculoComandoTestDataBuilder tipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public VehiculoComandoTestDataBuilder placa(String placa) {
        this.placa = placa;
        return this;
    }

    public VehiculoComandoTestDataBuilder cilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }


    public VehiculoComando build(){
        return new VehiculoComando(placa,tipoVehiculo,cilindraje);
    }
}
