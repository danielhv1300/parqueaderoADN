package co.com.ceiba.parqueadero.adn.testdatabuilder;


import co.com.ceiba.parqueadero.adn.aplicacion.comando.VehiculoComando;

public class VehiculoComandoTestDataBuilder {

	private String placa;
	private String tipoVehiculo;
	private int cilindraje;

    public VehiculoComandoTestDataBuilder(){
        this.placa = "EOW328";
        this.tipoVehiculo = "CARRO";
        this.cilindraje = 0;

    }

    public VehiculoComandoTestDataBuilder id(Long id) {
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

    public VehiculoComandoTestDataBuilder cilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }


    public VehiculoComando build(){
        return new VehiculoComando(placa,tipoVehiculo,cilindraje);
    }
}
