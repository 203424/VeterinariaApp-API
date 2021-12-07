package Bautista.Mascotas.Repository;

import Bautista.Mascotas.Model.Mascotas;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MascotasRepository extends CrudRepository<Mascotas, String> {
   List<Mascotas> findAll();

   Mascotas save(Mascotas mascota);
}