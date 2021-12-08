package veterinaria.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import veterinaria.demo.model.TipoMascotas;



@Repository
public interface TipoMascotasRepository extends JpaRepository<TipoMascotas, Integer> {
   
}