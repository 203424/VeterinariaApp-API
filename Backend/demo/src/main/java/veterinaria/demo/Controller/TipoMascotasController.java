package veterinaria.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import veterinaria.demo.Service.TipoMascotaService;
import veterinaria.demo.model.TipoMascotas;


@RestController
@RequestMapping("/api/tipoMascotas")
@CrossOrigin(origins = "*")
public class TipoMascotasController {

    @Autowired
    private TipoMascotaService tipoMascotaService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TipoMascotas mascota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoMascotaService.save(mascota));
    }

    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value ="idTipoMascota") Integer id) {
        Optional<TipoMascotas> oMascota = tipoMascotaService.findById(id);

        if(!oMascota.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oMascota);
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TipoMascotas mascotaDetails, @PathVariable(value="idTipoMascota") Integer id) {
        Optional<TipoMascotas> mascota = tipoMascotaService.findById(id);

        if(!mascota.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        mascota.get().setIdTipoMascota(mascotaDetails.getIdTipoMascota());
        mascota.get().setTipo(mascotaDetails.getTipo());
        mascota.get().setRaza(mascotaDetails.getRaza());

        return ResponseEntity.status(HttpStatus.CREATED).body(tipoMascotaService.save(mascota.get()));
    
    }

    //Delete an user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Integer id) {
        
        if(!tipoMascotaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        tipoMascotaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Read all users
    @GetMapping
    public List<TipoMascotas> readAll() {
        
        List<TipoMascotas> mascotas = StreamSupport
            .stream(tipoMascotaService.findAll().spliterator(), false)
            .collect(Collectors.toList());
        return mascotas;
    }

}
