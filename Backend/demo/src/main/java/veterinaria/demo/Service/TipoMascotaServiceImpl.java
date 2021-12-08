package veterinaria.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import veterinaria.demo.model.TipoMascotas;
import veterinaria.demo.repository.TipoMascotasRepository;


@Service
public class TipoMascotaServiceImpl implements TipoMascotaService{

	@Autowired
	private TipoMascotasRepository mascotaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<TipoMascotas> findAll() {
		return mascotaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoMascotas> findAll(Pageable pageable) {
		return mascotaRepository.findAll(pageable); 
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<TipoMascotas> findById(Integer id) {
		return mascotaRepository.findById(id);
	}

	@Override
	@Transactional
	public TipoMascotas save(TipoMascotas mascota) {
		return mascotaRepository.save(mascota);
	}	
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
		mascotaRepository.deleteById(id);
	}
}
