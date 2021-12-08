package veterinaria.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import veterinaria.demo.model.Duenio;
import veterinaria.demo.repository.DuenioRepository;

@Service
public class DuenioServiceImpl implements DueniosService{

    @Autowired
    private DuenioRepository duenioRepository;



    @Override
    public Duenio saveDuenio(Duenio duenio){
        return duenioRepository.save(duenio);
    }

    @Override
    public List<Duenio> getAllDuenios(){
        return duenioRepository.findAll();
    }

    @Override
    public void eliminar(Integer id){
        duenioRepository.deleteById(id);
    }

    @Override
    public Duenio updateNum(Duenio duenio){
        return duenioRepository.save(duenio);
    }
}
