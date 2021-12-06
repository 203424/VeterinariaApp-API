package equipoBD.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import equipoBD.demo.model.Cita;
import equipoBD.demo.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository userRepository;

    @Override
	@Transactional(readOnly = true)
	public Iterable<Cita> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Cita> findAll(Pageable pageable) {
		return userRepository.findAll(pageable); 
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cita> findById(Long idCita) {
		return userRepository.findById(idCita);
	}

	@Override
	@Transactional
	public Cita save(Cita user) {
		return userRepository.save(user);
	}	
	
	@Override
	@Transactional
	public void deleteById(Long idCita) {
		userRepository.deleteById(idCita);
	}
}
