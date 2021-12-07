package Bautista.Mascotas.Controller;

import Bautista.Mascotas.Model.Mascotas;
import Bautista.Mascotas.Repository.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MascotasController {

    @Autowired
    private MascotasRepository MascotasRepository;

    @GetMapping(value = "/tipoMascota")
    @CrossOrigin(origins = "https://localhost:3000")
    public List<Mascotas> getTipoMascota() {
        return MascotasRepository.findAll();
    }

    @PostMapping(value = "/agregarMascota")
    @CrossOrigin(origins = "https://localhost:3000")
    public Mascotas addTipoMascota(@RequestBody Mascotas mascotas) {

        return MascotasRepository.save(mascotas);
    }

}
