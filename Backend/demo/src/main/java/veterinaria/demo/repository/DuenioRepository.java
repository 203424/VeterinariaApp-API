package veterinaria.demo.repository;

import veterinaria.demo.model.Duenio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface DuenioRepository
        extends JpaRepository <Duenio, Integer> {

    List<Duenio> findAll();

    Duenio findByIdDuenio (int id_duenio);

    Duenio findByNombreDuenio (String nombreDueño);

    Duenio findByDireccion (String direccion);

    Duenio findByNumTelefono (int numero);

    Duenio findByCantMascotas(int cantMascotas);


    Duenio save(Duenio duenio);


}