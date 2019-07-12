package co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.adaptador;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.parqueaderoADN.dominio.modelo.Vehiculo;
import co.com.ceiba.parqueadero.parqueaderoADN.dominio.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.adaptador.entidad.VehiculoEntidad;
import co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.adaptador.repositorio.RepositorioVehiculoJPA;
import co.com.ceiba.parqueadero.parqueaderoADN.infraestructura.mapeador.VehiculoMapeador;

@Repository
public class RepositorioVehiculoH2Adaptador implements VehiculoRepositorio{

	private RepositorioVehiculoJPA repositorioVehiculoJPA;
	private VehiculoMapeador mapeador;
	
	public RepositorioVehiculoH2Adaptador(RepositorioVehiculoJPA parqueaderoRepositorioJPA, VehiculoMapeador mapeador){
        this.repositorioVehiculoJPA = parqueaderoRepositorioJPA;
        this.mapeador = mapeador;
    }
	    
	@Override
	public Vehiculo crearVehiculo(Vehiculo parqueadero) {
		VehiculoEntidad parqueaderoEntidad = repositorioVehiculoJPA.save(mapeador.convertirAEntidad(parqueadero));
		return mapeador.convertirADominio(parqueaderoEntidad);
	}


	@Override
	public int cuposPorTipoVehiculo(String tipoVehiculo) {
		return repositorioVehiculoJPA.cuposPorTipoVehiculo(tipoVehiculo);
	}

	@Override
	public boolean existeVehiculo(String placa) {
		return repositorioVehiculoJPA.existeVehiculo(placa);
	}

	@Override
	public List<Vehiculo> buscarRegistroVehiculos() {
		List<VehiculoEntidad> listaParqueaderoEntidad = repositorioVehiculoJPA.buscarRegistroVehiculos();
		return mapeador.listaConvertirADominio(listaParqueaderoEntidad);
	}

	@Override
	public Vehiculo buscarPorPlaca(String placa) {
		VehiculoEntidad parqueaderoEntidad = repositorioVehiculoJPA.buscarPorPlaca(placa);
		return mapeador.convertirADominio(parqueaderoEntidad);
	}

}
