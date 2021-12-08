package veterinaria.demo.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import veterinaria.demo.model.Mascota;
import veterinaria.demo.Service.MascotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mascotas")
@CrossOrigin(origins = "*")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    //Create a new user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Mascota mascota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.save(mascota));
    }

    //Read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value ="id") Long id) {
        Optional<Mascota> oMascota = mascotaService.findById(id);

        if(!oMascota.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oMascota);
    }

    //Update an user
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Mascota mascotaDetails, @PathVariable(value="id") Long mascotaId) {
        Optional<Mascota> mascota = mascotaService.findById(mascotaId);

        if(!mascota.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        mascota.get().setIdMascota(mascotaDetails.getIdMascota());
        mascota.get().setIdDuenio(mascotaDetails.getIdDuenio());
        mascota.get().setIdTipoMascota(mascotaDetails.getIdTipoMascota());
        mascota.get().setTipo(mascotaDetails.getTipo());
        mascota.get().setNombre(mascotaDetails.getNombre());
        mascota.get().setFechaIngreso(mascotaDetails.getFechaIngreso());
        mascota.get().setMotivoIngreso(mascotaDetails.getMotivoIngreso());

        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.save(mascota.get()));
    
    }

    //Delete an user
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long mascotaId) {
        
        if(!mascotaService.findById(mascotaId).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        mascotaService.deleteById(mascotaId);
        return ResponseEntity.ok().build();
    }

    //Read all users
    @GetMapping
    public List<Mascota> readAll() {
        
        List<Mascota> mascotas = StreamSupport
            .stream(mascotaService.findAll().spliterator(), false)
            .collect(Collectors.toList());
        return mascotas;
    }
}
