package veterinaria.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import veterinaria.demo.model.TipoMascotas;

public interface TipoMascotaService {
	
	public Iterable<TipoMascotas> findAll();
	
	public Page<TipoMascotas> findAll(Pageable pageable);
	
	public Optional<TipoMascotas> findById(Integer id);
	
	public void deleteById(Integer id);

	public TipoMascotas save(TipoMascotas tipoMascota);

}