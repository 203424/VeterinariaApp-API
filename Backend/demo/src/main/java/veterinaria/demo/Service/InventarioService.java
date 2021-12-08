package veterinaria.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import veterinaria.demo.model.Inventario;

public interface InventarioService {
    public Iterable<Inventario> findAll();
	
	public Page<Inventario> findAll(Pageable pageable);
	
	public Optional<Inventario> findById(Long idMedicamento);
	
	public void deleteById(Long idMedicamento);

	public Inventario save(Inventario inventario);
    
    
}
