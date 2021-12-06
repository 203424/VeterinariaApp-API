package veterinaria.demo.Controller;

import veterinaria.demo.Service.InventarioService;
import veterinaria.demo.model.Inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/inventarios")
@CrossOrigin("*")
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    private ResponseEntity<List<Inventario>> getAllInventario() {
        return ResponseEntity.ok(inventarioService.findAll());
    }

    @PostMapping
    private ResponseEntity<Inventario> saveInventario (@RequestBody Inventario inventario){
        try {
            Inventario inventarioGuardada = inventarioService.save(inventario);
        return ResponseEntity.created(new URI("/inventarios/" + inventarioGuardada.getIdMedicamento())).body(inventarioGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping (value = "delete/{id}")
    private ResponseEntity<Boolean> deleteInventario (@PathVariable ("id") Integer id){
        inventarioService.deleteById(id);
        return ResponseEntity.ok(!(inventarioService.findById(id) == null));
    }
}
