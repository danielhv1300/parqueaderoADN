package co.com.ceiba.parqueadero.adn.infraestructura.adaptador.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parqueadero.adn.infraestructura.adaptador.entidad.VehiculoEntidad;

public interface RepositorioVehiculoJPA extends CrudRepository<VehiculoEntidad, Integer>{
	
	@Query("SELECT COUNT(id) FROM VehiculoEntidad p WHERE p.tipoVehiculo = :tipoVehiculo AND p.fechaSalida IS NULL")
    int cuposPorTipoVehiculo(@Param("tipoVehiculo") String tipoVehiculo);

    @Query("SELECT p FROM VehiculoEntidad p WHERE p.placa = :placa AND p.fechaSalida IS NULL")
    VehiculoEntidad buscarPorPlaca(@Param("placa") String placa);

    @Query("SELECT p FROM VehiculoEntidad p WHERE p.fechaSalida IS NULL")
    List<VehiculoEntidad> buscarRegistroVehiculos();

    @Query("SELECT CASE WHEN COUNT(p.id) > 0 THEN true ELSE false END FROM VehiculoEntidad p WHERE p.placa = :placa AND p.fechaSalida IS NULL")
    boolean existeVehiculo(@Param("placa") String placa);

}
