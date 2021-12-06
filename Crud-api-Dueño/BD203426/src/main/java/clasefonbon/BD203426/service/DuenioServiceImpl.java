package clasefonbon.BD203426.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clasefonbon.BD203426.model.Duenio;
import clasefonbon.BD203426.repository.DuenioRepository;

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
    public void updateNum(Duenio duenio){
        duenioRepository.save(duenio);
    }
}
