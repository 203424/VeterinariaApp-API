package veterinaria.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import veterinaria.demo.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{

}