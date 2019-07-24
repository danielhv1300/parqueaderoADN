package co.com.ceiba.parqueadero.parqueaderoADN.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.constantes.Constantes;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.excepcion.ExcepcionNoExisteRegistroVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.ValidadorVehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;

public class ServicioActualizarSalidaVehiculo {

	private VehiculoRepositorio vehiculoRepositorio;
	
	public ServicioActualizarSalidaVehiculo(VehiculoRepositorio parqueaderoRepositorio){
        this.vehiculoRepositorio = parqueaderoRepositorio;
    }
	
	public double actualizar(String placa){
		ValidadorVehiculo.validarDatoObligatorio(placa, Vehiculo.MENSAJE_CAMPO_PLACA_OBLIGATORIO);
		Vehiculo vehiculo = validarRegistro(placa);
		vehiculo.setFechaSalida(Calendar.getInstance().getTime());
		if(vehiculo.getTipoVehiculo().equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
			calcularPrecioMoto(vehiculo);
		}else{
			calcularPrecioCarro(vehiculo);
		}
		
        this.vehiculoRepositorio.crearVehiculo(vehiculo);
        return vehiculo.getValor();
    }
	
	private Vehiculo validarRegistro(String placa) {
		Vehiculo vehiculo = this.vehiculoRepositorio.buscarPorPlaca(placa);
		if (vehiculo == null) {
			throw new ExcepcionNoExisteRegistroVehiculo(Vehiculo.MENSAJE_VEHICULO_NO_EXISTE_EN_PARQUEADERO);
		}
		return vehiculo;
	}
	
	public void calcularPrecioMoto(Vehiculo registry) {
        long value;
        double milisegund = (registry.getFechaSalida().getTime() - registry.getFechaIngreso().getTime());
        double hour = (milisegund/3600000);
        double minute = (milisegund/60000);
        long totalHour = Math.round(hour);
        long totalMinute = Math.round(minute);
        int totalDay = (int)  totalHour / 24;
        int  totalHourNewDay = (int) totalHour % 24;


        if(totalHour < 9){
            if((totalMinute >= 2) && (totalHour == 0)){
                value = 500;
            }else{
                value = totalHour * 500;
            }
        }else if(totalHourNewDay == 0 || (totalHourNewDay >= 9 && totalHourNewDay < 24)){
            value = (4000 * (totalDay == 0 ? 1:totalDay));
        }else{
            value = ((4000 * totalDay) + (totalHourNewDay * 500));
        }
        
        if(Integer.valueOf(registry.getCilindraje()) > 500 ){
            value = value + 2000;
        }
        
        registry.setValor(value);
    }
	
	public void calcularPrecioCarro(Vehiculo vehiculo) {
        long total;
        double miliseg = (vehiculo.getFechaSalida().getTime() - vehiculo.getFechaIngreso().getTime());
        double horaCarro = (miliseg/3600000);
        double minutosCarro = (miliseg/60000);
        long totalHora = Math.round(horaCarro);
        long totalMinutos = Math.round(minutosCarro);
        int totalDia = (int)  totalHora / 24;
        int totalHoraNuevoDia = (int) totalHora % 24;


        if(totalHora < 9){
            if((totalMinutos >= 2) && (totalHora == 0)){
            	total = 1000;
            }else{
            	total = totalHora * 1000;
            }
        }else if(totalHoraNuevoDia == 0 || (totalHoraNuevoDia >= 9 && totalHoraNuevoDia < 24)){
        	total = (8000 * (totalDia == 0 ? 1:totalDia));
        }else{
        	total = ((8000 * totalDia) + (totalHoraNuevoDia * 1000));
        }
        
        vehiculo.setValor(total);
    }
}
