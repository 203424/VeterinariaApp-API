package Bautista.tipoMascota.Controller;

import Bautista.tipoMascota.Model.TipoMascota;
import Bautista.tipoMascota.Repository.TipoMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/BD203462")
public class TipoMascotaController {

    @Autowired
    TipoMascotaRepository tipoMascotaRepository;

    @GetMapping(value = "/ListTipoMascota")
    public List<TipoMascota> getTipoMascota() {
        List<TipoMascota> res = tipoMascotaRepository.findAll();
        if (res == null) {
            return null;
        } else {
            return res;
        }
    }

    @PostMapping(value = "/tipoMascota")
    public TipoMascota getTipoMascota(@RequestBody TipoMascota tipoMascota) {
        return tipoMascotaRepository.findByTipoMascota(tipoMascota.getTipoMascota());
    }

    @PostMapping(value = "/caracteristicas")
    public TipoMascota getCaracteristicas(@RequestBody TipoMascota tipoMascota) {
        return tipoMascotaRepository.findByCaracteristicas(tipoMascota.getCaracteristicas());
    }

    @PostMapping(value = "/agregarTipoMascota", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TipoMascota addCustomer(@RequestBody TipoMascota customer) {

        return tipoMascotaRepository.save(customer);
    }

}
