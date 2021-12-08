package veterinaria.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import veterinaria.demo.model.Mascota;
import veterinaria.demo.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{

	@Autowired
	private MascotaRepository mascotaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Mascota> findAll() {
		return mascotaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Mascota> findAll(Pageable pageable) {
		return mascotaRepository.findAll(pageable); 
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mascota> findById(Long id) {
		return mascotaRepository.findById(id);
	}

	@Override
	@Transactional
	public Mascota save(Mascota mascota) {
		return mascotaRepository.save(mascota);
	}	
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		mascotaRepository.deleteById(id);
	}
}