package clasefonbon.BD203426.service;


import java.util.List;

import clasefonbon.BD203426.model.Duenio;

public interface DueniosService {
    public Duenio saveDuenio(Duenio duenio);
    public List<Duenio> getAllDuenios();
    public void eliminar(Integer id);
    public void updateNum(Duenio duenio);
}
