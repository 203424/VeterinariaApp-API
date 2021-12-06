package veterinaria.demo.repository;

import veterinaria.demo.model.Inventario;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InventarioRepository extends JpaRepository <Inventario, Integer> { 
    
}
