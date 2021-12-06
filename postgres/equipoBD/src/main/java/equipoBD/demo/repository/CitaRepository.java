package equipoBD.demo.repository;

import equipoBD.demo.model.Cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CitaRepository extends JpaRepository <Cita, Long> { 
    
}