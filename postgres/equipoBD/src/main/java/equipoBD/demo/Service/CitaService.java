package equipoBD.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import equipoBD.demo.model.Cita;

public interface CitaService {
    public Iterable<Cita> findAll();
	
	public Page<Cita> findAll(Pageable pageable);
	
	public Optional<Cita> findById(Long idCita);
	
	public void deleteById(Long idCita);

	public Cita save(Cita user);
    
    
}
