package veterinaria.demo.Controller;

import veterinaria.demo.Service.InventarioService;
import veterinaria.demo.model.Inventario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
@RequestMapping("/api/inventarios")
@CrossOrigin(origins = "*")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Inventario inventario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioService.save(inventario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value ="id") Long idMedicamento) {
        Optional<Inventario> oInventario = inventarioService.findById(idMedicamento);

        if(!oInventario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oInventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Inventario inventarioDetails, @PathVariable(value="id") Long idMedicamento) {
        Optional<Inventario> inventario = inventarioService.findById(idMedicamento);

        if(!inventario.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        inventario.get().setIdMedicamento(inventarioDetails.getIdMedicamento());
        inventario.get().setNombreMed(inventarioDetails.getNombreMed());
        inventario.get().setSustanciaAct(inventarioDetails.getSustanciaAct());
        

        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioService.save(inventario.get()));
    
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value="id") Long idMedicamento) {
        
        if(!inventarioService.findById(idMedicamento).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        inventarioService.deleteById(idMedicamento);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Inventario> readAll() {
        
        List<Inventario> users = StreamSupport
            .stream(inventarioService.findAll().spliterator(), false)
            .collect(Collectors.toList());
        return users;

    }


}
