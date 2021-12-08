package veterinaria.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import veterinaria.demo.model.Mascota;

public interface MascotaService {
	
	public Iterable<Mascota> findAll();
	
	public Page<Mascota> findAll(Pageable pageable);
	
	public Optional<Mascota> findById(Long id);
	
	public void deleteById(Long id);

	public Mascota save(Mascota mascota);

}