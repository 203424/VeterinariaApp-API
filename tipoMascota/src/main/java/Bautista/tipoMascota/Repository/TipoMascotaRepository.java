package Bautista.tipoMascota.Repository;

import Bautista.tipoMascota.Model.TipoMascota;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TipoMascotaRepository extends CrudRepository<TipoMascota, String> {
    List<TipoMascota> findAll();

    TipoMascota findByTipoMascota(String idTipoMascota);

    TipoMascota findByCaracteristicas(String caracteristicas);

    TipoMascota save(TipoMascota tipoMascota);
}