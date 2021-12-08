package veterinaria.demo.Service;

import java.util.List;

import veterinaria.demo.model.Duenio;

public interface DueniosService {
    public Duenio saveDuenio(Duenio duenio);
    public List<Duenio> getAllDuenios();
    public void eliminar(Integer id);
    public Duenio updateNum(Duenio duenio);
}