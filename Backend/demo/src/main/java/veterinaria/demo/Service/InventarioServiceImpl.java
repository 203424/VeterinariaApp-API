package veterinaria.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import veterinaria.demo.model.Inventario;
import veterinaria.demo.repository.InventarioRepository;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
	@Transactional(readOnly = true)
	public Iterable<Inventario> findAll() {
		return inventarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Inventario> findAll(Pageable pageable) {
		return inventarioRepository.findAll(pageable); 
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Inventario> findById(Long idMedicamento) {
		return inventarioRepository.findById(idMedicamento);
	}

	@Override
	@Transactional
	public Inventario save(Inventario inventario) {
		return inventarioRepository.save(inventario);
	}	
	
	@Override
	@Transactional
	public void deleteById(Long idMedicamento) {
		inventarioRepository.deleteById(idMedicamento);
	}
}
